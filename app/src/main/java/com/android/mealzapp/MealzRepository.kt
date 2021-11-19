package com.android.mealzapp

import com.android.mealzapp.model.MealzCategoriesResponse

//todo 2 add model (next viewmodel)
class MealzRepository {
    fun getMealz(): MealzCategoriesResponse = MealzCategoriesResponse(arrayListOf())
}