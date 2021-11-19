package com.android.mealzapp

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.android.mealzapp.model.MealResponse
import com.android.mealzapp.model.MealzCategoriesResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MealCategoriesViewModel(
    private val repository: MealzRepository = MealzRepository()
) : ViewModel() {

    init {
        Log.d("TAG","we are about to lunch a coroutine") // 1
        viewModelScope.launch(Dispatchers.IO){
            Log.d("TAG","we have lunched the coroutine") // 3
            val meals = getMeals()
            Log.d("TAG","we have received the async data") // 4
            mealsState.value = meals
        }
        Log.d("TAG","other work") // 2
    }

    var mealsState: MutableState<List<MealResponse>> =  mutableStateOf(emptyList<MealResponse>())


    suspend fun getMeals(): List<MealResponse>{
        return repository.getMealz().categories
    }
}