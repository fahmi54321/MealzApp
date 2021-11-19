package com.android.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.android.mealzapp.model.MealResponse
import com.android.mealzapp.ui.theme.MealzAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

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

    val viewModel : MealCategoriesViewModel = viewModel()
    var rememberedMealz = remember{ mutableStateOf(emptyList<MealResponse>())}
    val coroutineScope = rememberCoroutineScope()
    LaunchedEffect(key1 = "GET_MEALS", block = {
        coroutineScope.launch(Dispatchers.IO){
            val meals = viewModel.getMeals()
            rememberedMealz.value = meals
        }
    })


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