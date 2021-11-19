package com.android.mealzapp

import androidx.lifecycle.ViewModel
import com.android.mealzapp.model.MealResponse
import com.android.mealzapp.model.MealzCategoriesResponse

class MealCategoriesViewModel(
    private val repository: MealzRepository = MealzRepository()
) : ViewModel() {

    suspend fun getMeals(): List<MealResponse>{
        return repository.getMealz().categories
    }
}