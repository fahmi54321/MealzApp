package com.android.mealzapp

import com.android.mealzapp.model.MealzCategoriesResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//todo 1 retrofit (next repository)
class MealzApi {
    private lateinit var api: MealzApi

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://www.themealdb.com/api/json/v1/1/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        api = retrofit.create(MealzApi::class.java)
    }

    fun getMealz(): Call<MealzCategoriesResponse>{
        return api.getMealz()
    }

    interface MealzApi{
        @GET("categories.php")
        fun getMealz(): Call<MealzCategoriesResponse>
    }

}