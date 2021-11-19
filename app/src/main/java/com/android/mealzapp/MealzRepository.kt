package com.android.mealzapp

import com.android.mealzapp.model.MealzCategoriesResponse

class MealzRepository(
    private val webService: MealzApi = MealzApi()
) {
    suspend fun getMealz(): MealzCategoriesResponse {
        return webService.getMealz()
    }
}