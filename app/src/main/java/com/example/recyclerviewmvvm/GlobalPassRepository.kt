package com.example.recyclerviewmvvm

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.recyclerviewmvvm.POJO.GobalPassListingPOJO
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

public class GlobalPassRepository(val apiInterface: ApiInterface) {
    private var globalpassListing:MutableLiveData<GobalPassListingPOJO> = MutableLiveData<GobalPassListingPOJO>()
    val globalLiveData:LiveData<GobalPassListingPOJO>
    get() = globalpassListing

    public fun getGlobalPassListing(apikey:String?, authValue:String?):MutableLiveData<GobalPassListingPOJO>{

        apiInterface.globalPassListing(apikey,authValue)?.enqueue(object :Callback<GobalPassListingPOJO?>{
            override fun onResponse(
                call: Call<GobalPassListingPOJO?>,
                response: Response<GobalPassListingPOJO?>
            ) {
                globalpassListing.value=response.body();
            }

            override fun onFailure(call: Call<GobalPassListingPOJO?>, t: Throwable) {
                Log.e("",t.toString())
            }
        })
        return globalpassListing;
    }
}