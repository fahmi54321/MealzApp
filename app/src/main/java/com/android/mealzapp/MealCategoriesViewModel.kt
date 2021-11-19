package com.android.mealzapp

import androidx.lifecycle.ViewModel
import com.android.mealzapp.model.MealResponse
import com.android.mealzapp.model.MealzCategoriesResponse

class MealCategoriesViewModel(
    private val repository: MealzRepository = MealzRepository() //todo 2 add viewmodel dan repository (finish)
) : ViewModel() {

    //todo 3 add model (next view)
    fun getMeals(successCallback: (response: MealzCategoriesResponse?) -> Unit){
        //todo 5 retrofit (next view)
        repository.getMealz { response ->
            successCallback(response)
        }
    }
}