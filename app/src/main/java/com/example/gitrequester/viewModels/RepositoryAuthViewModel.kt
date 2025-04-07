package com.example.gitrequester.viewModels

import android.util.Log
import com.example.gitrequester.data.Repository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import java.net.HttpURLConnection
import java.net.URL

class RepositoryAuthViewModel {
    suspend fun CheckAuthToken(authToken: String): Pair<Int, List<Repository>?> {

        return withContext(Dispatchers.IO) {

            val url = URL("https://api.github.com/user/repos")
            val connection = url.openConnection() as HttpURLConnection

            try {
                connection.requestMethod = "GET"
                connection.setRequestProperty("Authorization", "Bearer $authToken")
                connection.setRequestProperty("Accept", "application/vnd.github.v3+json")


                val responseCode = connection.responseCode
                val responseMessage = try {
                    connection.inputStream.bufferedReader().use { it.readText() }
                } catch (e: Exception) {
                    connection.errorStream?.bufferedReader()?.use { it.readText() }
                } ?: "Ошибка чтения ответа"

                Log.d("CheckAuthToken", "Response Code: $responseCode")
                Log.d("CheckAuthToken", "Response: $responseMessage")
                if (responseCode == 200) {
                    val repositories: List<Repository> = Json { ignoreUnknownKeys = true }
                        .decodeFromString(responseMessage)
                    Pair(responseCode, repositories)
                } else {
                    Pair(responseCode, null)
                }


            } catch (e: Exception) {
                Log.e("CheckAuthToken", "Ошибка запроса", e)
                Pair(-1, null)
            } finally {
                connection.disconnect()
            }
        }

    }

}