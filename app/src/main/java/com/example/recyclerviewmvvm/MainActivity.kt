package com.example.recyclerviewmvvm

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerviewmvvm.POJO.GobalPassListingPOJO
import com.example.recyclerviewmvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var globalPassViewModel: GlobalPassViewModel
    private val mContext: Context = this
    private lateinit var mBinding: ActivityMainBinding
    private val arrayList = ArrayList<GobalPassListingPOJO>()
//    private

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityMainBinding.inflate(layoutInflater)
        val view = mBinding.root
        setContentView(view)

        mBinding.rvGlobalList.layoutManager = LinearLayoutManager(this)

        val apiInterface = RetrofitClient.create(ApiInterface::class.java)
        val repository = GlobalPassRepository(apiInterface)

        globalPassViewModel = ViewModelProvider(
            this,
            GlobalPassViewModelFactory(repository)
        )[GlobalPassViewModel::class.java]

        globalPassViewModel.globalDataList.observe(this) {
            for (i in it) {
                arrayList.add(it)
            }
            val adapterr = GlobalPassListAdapter(arrayList)
            mBinding.rvGlobalList.adapter = adapterr
            adapterr.notifyDataSetChanged()
        }
    }
}