package com.mustafayigit.kotlinrestexample.data

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class ApiClient {
    companion object {
        private const val BASE_URL = "https://restapi-4b53c.firebaseio.com/"
        private var client: Retrofit? = null

        fun getClient(): Retrofit {
            if (client == null) {
                client = Retrofit.Builder()
                    .addConverterFactory(
                        GsonConverterFactory.create(
                            GsonBuilder().setLenient().create()
                        )
                    )
                    .baseUrl(BASE_URL)
                    .build()
            }
            return client!!
        }
    }
}