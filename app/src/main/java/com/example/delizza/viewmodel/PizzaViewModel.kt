package com.example.delizza.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.delizza.model.PizzaItem
import com.example.delizza.network.PizzaApi
import kotlinx.coroutines.launch
import java.lang.Exception

class PizzaViewModel : ViewModel() {

    //pizza list initialised with mutable live data since the list is dynamic and values could change
    private val _pizzaList = MutableLiveData<List<PizzaItem>>()

    //livedata of is immutable as the list object is retrieved here and not changed
    val pizzaList:LiveData<List<PizzaItem>> = _pizzaList

    init {
        getPizza()
    }

    private fun getPizza(){

            viewModelScope.launch {
                try {
                    _pizzaList.value=PizzaApi.retroFitService.getPizzas()
                    Log.d("Pizza_List","Pizza list retrieved successfully! "+pizzaList.value!!.size)
                }
                catch (e:Exception){
                    Log.d("Exception","Exception occurred in fetching data "+e.message)
                }
            }

    }
}