package com.example.a24012021039_pr_7_mad

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class HttpRequest {

    fun makeServiceCall(
        reqUrl: String,
        token: String
    ): String? {

        var connection: HttpURLConnection? = null

        return try {

            val url = URL(reqUrl)

            connection =
                url.openConnection() as HttpURLConnection

            connection.requestMethod = "GET"

            connection.connectTimeout = 15000
            connection.readTimeout = 15000

            connection.setRequestProperty(
                "Authorization",
                "Bearer $token"
            )

            val responseCode =
                connection.responseCode

            if (responseCode == HttpURLConnection.HTTP_OK) {

                val reader = BufferedReader(
                    InputStreamReader(
                        connection.inputStream
                    )
                )

                val response = StringBuilder()

                var line: String?

                while (
                    reader.readLine().also {
                        line = it
                    } != null
                ) {

                    response.append(line)
                }

                reader.close()

                response.toString()

            } else {

                println(
                    "HTTP Error Code: $responseCode"
                )

                null
            }

        } catch (e: Exception) {

            e.printStackTrace()

            null

        } finally {

            connection?.disconnect()
        }
    }
}