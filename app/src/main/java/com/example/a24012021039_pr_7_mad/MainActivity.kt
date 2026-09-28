package com.example.a24012021039_pr_7_mad

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.a24012021039_pr_7_mad.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var adapter: PersonAdapter
    private val personList = ArrayList<Person>()
    companion object {

        private const val TAG = "MainActivity"
        private const val API_URL =
            "https://api.json-generator.com/templates/9Rul6Z6MrDF-/data"
        private const val TOKEN =
            "PASTE_YOUR_VALID_TOKEN_HERE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        setupRecyclerView()

        loadPersonsFromDatabase()

        getPersonDataFromApi()
    }

    private fun setupRecyclerView() {

        adapter = PersonAdapter(
            this,
            personList,
            databaseHelper
        )

        binding.recyclerViewPersons.layoutManager =
            LinearLayoutManager(this)

        binding.recyclerViewPersons.adapter = adapter
    }

    private fun getPersonDataFromApi() {

        CoroutineScope(Dispatchers.IO).launch {

            try {

                val data = HttpRequest().makeServiceCall(
                    reqUrl = API_URL,
                    token = TOKEN
                )

                Log.d(TAG, "API RESPONSE = $data")

                withContext(Dispatchers.Main) {

                    if (data != null && data.isNotEmpty()) {

                        getPersonDetailsFromJson(data)

                    } else {

                        Log.e(TAG, "API returned no data")
                    }
                }

            } catch (e: Exception) {

                Log.e(TAG, "API ERROR", e)
            }
        }
    }

    private fun getPersonDetailsFromJson(json: String) {

        try {

            val jsonArray = JSONArray(json)

            if (jsonArray.length() == 0) {

                Log.e(TAG, "JSON array is empty")
                return
            }

            Log.d(
                TAG,
                "Persons received: ${jsonArray.length()}"
            )

            val db = databaseHelper.writableDatabase

            db.delete(
                PersonDbTableData.TABLE_NAME,
                null,
                null
            )

            db.close()

            for (i in 0 until jsonArray.length()) {

                val obj = jsonArray.getJSONObject(i)

                val profile =
                    obj.getJSONObject("profile")

                val location =
                    profile.getJSONObject("location")

                val person = Person(
                    obj.getString("id"),
                    profile.getString("name"),
                    obj.getString("email"),
                    obj.getString("phone"),
                    profile.getString("address"),
                    location.getDouble("lat"),
                    location.getDouble("long")
                )

                val result =
                    databaseHelper.insertPerson(person)

                Log.d(
                    TAG,
                    "Inserted ${person.name}: $result"
                )
            }

            loadPersonsFromDatabase()

        } catch (e: Exception) {

            Log.e(
                TAG,
                "JSON ERROR: ${e.message}",
                e
            )
        }
    }
    private fun loadPersonsFromDatabase() {

        personList.clear()

        personList.addAll(
            databaseHelper.getAllPersons()
        )
        Log.d(
            TAG,
            "Database persons: ${personList.size}"
        )
        adapter.notifyDataSetChanged()
    }
}