package com.example.recyclerviewmvvm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.recyclerviewmvvm.POJO.GobalPassListingPOJO

class GlobalPassViewModel(val respository: GlobalPassRepository) : ViewModel() {
    init {
        respository.getGlobalPassListing(
            "QmFzaWM6cXpKaGJaY2lPaUpJVXpJMU5pSXNJblI1YzZJa3AuZXlKemRXSWlPaUl4TWpNU0k2SW5SdmNUUlRqYUdWa1pHRnlJaXdpYVdGMElqb3hOVEUyS3M5Mik0a3NrQUFRa2wyMmYwMDU0OTJESXlmUS50UFFQVGNRZDItd29vdGFQVXZZbTdDVVI0cHdDTEZaUmpKMzNxbFpfc3RhZ2luZw==",
            "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpZCI6IjE3MTAwNCJ9.WsVNVYJxLesDM226LUh0TF1KQWmoGE1sAuedSn-cyCE"
        )
    }
    val globalDataList: LiveData<GobalPassListingPOJO>
    get() = respository.globalLiveData
}