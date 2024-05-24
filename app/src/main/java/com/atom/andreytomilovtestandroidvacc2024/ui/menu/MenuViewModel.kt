package com.atom.andreytomilovtestandroidvacc2024.ui.menu

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.atom.andreytomilovtestandroidvacc2024.domain.dto.Coffee
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetAllCoffeeListUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

class MenuViewModel @Inject constructor(
    private val getAllCoffeeListUseCase: GetAllCoffeeListUseCase
) : ViewModel() {

    private val _coffeeList = MutableLiveData<Result<List<Coffee>>>()
    val coffees: LiveData<Result<List<Coffee>>> get() = _coffeeList


    fun fetchCoffees() {
        viewModelScope.launch {
            _coffeeList.value = getAllCoffeeListUseCase.invoke()
        }
    }
}