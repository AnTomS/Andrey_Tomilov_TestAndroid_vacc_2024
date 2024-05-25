package com.atom.andreytomilovtestandroidvacc2024.ui.coffeedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.atom.andreytomilovtestandroidvacc2024.domain.usecase.GetCoffeeDetailUseCase
import javax.inject.Inject

class CoffeeDetailViewModel @Inject constructor(private val getCoffeeDetailUseCase: GetCoffeeDetailUseCase) :
    ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
}