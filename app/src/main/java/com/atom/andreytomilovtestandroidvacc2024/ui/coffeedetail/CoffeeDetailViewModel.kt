package com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetCoffeeDetailUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class CoffeeDetailViewModel @Inject constructor(private val getCoffeeDetailUseCase: GetCoffeeDetailUseCase) :
    ViewModel() {
    private val _selectedCoffee = MutableLiveData<Coffee?>()
    val selectedCoffee: MutableLiveData<Coffee?> get() = _selectedCoffee

    fun setSelectedCoffeeId(id: Int) {
        viewModelScope.launch {
            try {
                val coffee = getCoffeeDetailUseCase(id)
                _selectedCoffee.value = coffee
                Log.d("CoffeeDetailViewModel", "Selected coffee: $coffee")
            } catch (e: Exception) {
                Log.e("CoffeeDetailViewModel", "Error getting coffee details", e)
            }
        }
    }
}