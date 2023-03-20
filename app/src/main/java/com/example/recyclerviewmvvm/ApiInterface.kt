package com.example.recyclerviewmvvm

import com.example.recyclerviewmvvm.POJO.GobalPassListingPOJO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header


public interface ApiInterface {
    @GET("reserveglobalpass/format/json")
    open fun globalPassListing(
        @Header("Authorization") apiKey: String?,
        @Header("Application-Authorization") apiAuthKey: String?,): Call<GobalPassListingPOJO?>?
}