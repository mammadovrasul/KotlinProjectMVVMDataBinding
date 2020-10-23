package com.dev.kotlinproject

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Created by Rasul Mamadov on 10/23/2020.
 */
class RetroInstance {

    companion object {
        val BASE_URL = "http://3.125.87.249/webservices/"

        fun getRetroInstance(): Retrofit {
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        }
    }
}