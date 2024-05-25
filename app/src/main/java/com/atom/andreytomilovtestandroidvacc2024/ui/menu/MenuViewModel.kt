package com.atom.andreytomilovtestandroidvacc2024.ui.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.andreytomilovtestandroidvacc2024.data.network.ResultState
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetAllCoffeeListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getAllCoffeeListUseCase: GetAllCoffeeListUseCase
) : ViewModel() {

    private val _coffees = MutableLiveData<ResultState<List<Coffee>>>()
    val coffees: LiveData<ResultState<List<Coffee>>> get() = _coffees

    fun fetchCoffees() {
        viewModelScope.launch {
            Log.d("MenuViewModel", "Fetching coffees")
            _coffees.value = ResultState.Loading
            try {
                val coffeeList = getAllCoffeeListUseCase()
                _coffees.value = ResultState.Success(coffeeList)
                Log.d("MenuViewModel", "Coffees fetched successfully: ${coffeeList.size}")
            } catch (e: Exception) {
                _coffees.value = ResultState.Failure(e)
                Log.e("MenuViewModel", "Error fetching coffees", e)
            }
        }
    }
}