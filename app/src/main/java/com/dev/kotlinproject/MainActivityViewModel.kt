package com.dev.kotlinproject

import android.util.Log.d
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import retrofit2.Call
import retrofit2.Response
import java.util.logging.Logger
import javax.security.auth.callback.Callback

/**
 * Created by Rasul Mamadov on 10/23/2020.
 */
class MainActivityViewModel : ViewModel() {
    lateinit var recyclerListData: MutableLiveData<RecyclerList>
    lateinit var recyclerViewAdapter: RecyclerViewAdapter

    init {
        recyclerListData = MutableLiveData()
        recyclerViewAdapter = RecyclerViewAdapter()
    }

    fun getAdapter(): RecyclerViewAdapter {
        return recyclerViewAdapter
    }

    fun setAdapterData(data: ArrayList<RecyclerData>) {
        recyclerViewAdapter.setDataList(data)
        recyclerViewAdapter.notifyDataSetChanged()

    }

    fun getRecyclerListDataObserver(): MutableLiveData<RecyclerList> {
        return recyclerListData
    }

    fun makeApiCall() {
        val retroInstance = RetroInstance.getRetroInstance().create(RetroService::class.java)
        val call = retroInstance.getData("1","az","53")
        call.enqueue(object : retrofit2.Callback<RecyclerList> {
            override fun onResponse(call: Call<RecyclerList>, response: Response<RecyclerList>) {
                if (response.isSuccessful()) {
                    recyclerListData.postValue(response.body())


                } else {
                    recyclerListData.postValue(null)
                }

            }

            override fun onFailure(call: Call<RecyclerList>, t: Throwable) {
                recyclerListData.postValue(null)
            }

        })
    }
}