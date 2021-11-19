package com.android.mealzapp.model

import com.google.gson.annotations.SerializedName

//todo 1 add model (next repository)
data class MealzCategoriesResponse(
     val categories: List<MealResponse>
)

data class MealResponse(
    @SerializedName("idCategory")  val id: String,
    @SerializedName("strCategory")  val name: String,
    @SerializedName("strCategoryDescription")  val description: String,
    @SerializedName("strCategoryThumb")  val imageUrl: String
)