package com.dev.kotlinproject

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by Rasul Mamadov on 10/23/2020.
 */
interface RetroService {

    @GET("notificationList")
    fun getData(
        @Query("offset") offset: String,
        @Query("language") language: String,
        @Query("user_id") user_id: String
    ): Call<RecyclerList>
}