package com.android.mealzapp

import com.android.mealzapp.model.MealzCategoriesResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

//todo 2 add model
class MealzRepository(
    private val webService: MealzApi = MealzApi() //todo 3 retrofit
) {
    //todo 4 retrofit (next view model)
    fun getMealz(successCallback: (response: MealzCategoriesResponse?) -> Unit) {
        return webService.getMealz().enqueue(object : Callback<MealzCategoriesResponse> {
            override fun onResponse(
                call: Call<MealzCategoriesResponse>,
                response: Response<MealzCategoriesResponse>
            ) {
                if (response.isSuccessful) {
                    successCallback(response.body())
                }
            }

            override fun onFailure(call: Call<MealzCategoriesResponse>, t: Throwable) {

            }

        })
    }
}