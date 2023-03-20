package com.example.recyclerviewmvvm

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


 class RetrofitClient {
    companion object{
        val BASE_URL = "https://www.staging.coworker.com/api/v2/i/"

        public fun <T> create(serviceInterface: Class<T>?): T {
            val interceptor = HttpLoggingInterceptor()
            interceptor.level = HttpLoggingInterceptor.Level.BODY
            val client:OkHttpClient = OkHttpClient().newBuilder().addInterceptor(interceptor).build()
            val gson:Gson = GsonBuilder().create()
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build()
            return retrofit.create(serviceInterface)
        }
    }

}