package com.dev.kotlinproject

/**
 * Created by Rasul Mamadov on 10/23/2020.
 */
data class RecyclerList(val items: ArrayList<RecyclerData>)

data class RecyclerData(
    val status: String,
    val dataflow: String,
    val message: String,
    val dataBean: DataBean
)

data class DataBean(
    val id: Int,
    val user_id: Int,
    val store_id: Int,
    val title: String,
    val message: String,
    val created: String,
    val image: String,
)