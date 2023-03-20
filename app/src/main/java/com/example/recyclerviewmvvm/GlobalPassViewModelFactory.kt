package com.example.recyclerviewmvvm

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GlobalPassViewModelFactory(private val respository:GlobalPassRepository):ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GlobalPassViewModel(respository) as T
    }
}