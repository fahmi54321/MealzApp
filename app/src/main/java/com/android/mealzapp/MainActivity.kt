package com.android.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mealzapp.model.MealResponse
import com.android.mealzapp.ui.theme.MealzAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MealzAppTheme {
                MealzCategoriesScreen()
            }
        }
    }
}

@Composable
fun MealzCategoriesScreen() {

    // view model dengan compose
    val viewModel : MealCategoriesViewModel = viewModel() // todo 1 add viewmodel dan repository (next MealzCategorieViewModel)

    var rememberedMealz = remember{ mutableStateOf(emptyList<MealResponse>())}

    //todo 3 add model (finish) next implementasi retrofit agar ui bisa bind data dari view model
    viewModel.getMeals{
        //todo 5 retrofit (finish)
        val meals = it?.categories
        rememberedMealz.value = meals.orEmpty()
    }

    LazyColumn{
        items(rememberedMealz.value){
            Text(text = it.name)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealzCategoriesScreen()
    }
}