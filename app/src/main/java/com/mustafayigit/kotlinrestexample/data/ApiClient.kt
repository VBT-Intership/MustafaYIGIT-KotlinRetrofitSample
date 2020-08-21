package com.mustafayigit.kotlinrestexample.data

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ApiClient {
    companion object {
        private const val BASE_URL = "https://restapi-4b53c.firebaseio.com/versions.json/"
        private var client: Retrofit? = null

        fun getClient(): Retrofit {
            if (client == null) {
                client = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }
            return client!!
        }
    }
}