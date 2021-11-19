package com.android.mealzapp

import androidx.lifecycle.ViewModel
import com.android.mealzapp.model.MealResponse

class MealCategoriesViewModel(
    private val repository: MealzRepository = MealzRepository() //todo 2 add viewmodel dan repository (finish)
):ViewModel() {

    //todo 3 add model (next view)
    fun getMeals():List<MealResponse>{
        return repository.getMealz().categories
    }
}