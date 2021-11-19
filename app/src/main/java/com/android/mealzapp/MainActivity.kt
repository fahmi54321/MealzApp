package com.android.mealzapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
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
    Text(text = "Hello compose")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MealzAppTheme {
        MealzCategoriesScreen()
    }
}