package com.example.a24012021039_pr_7_mad

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.a24012021039_pr_7_mad.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapBinding.inflate(layoutInflater)

        setContentView(binding.root)

        val person =
            intent.getSerializableExtra(
                "Object"
            ) as Person

        binding.txtName.text =
            person.name

        binding.txtLatitude.text =
            "Latitude : ${person.latitude}"

        binding.txtLongitude.text =
            "Longitude : ${person.longitude}"

        binding.txtAddress.text =
            person.address
    }
}