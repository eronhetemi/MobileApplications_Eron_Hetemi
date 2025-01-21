package com.example.createaccountapp

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow(
        listOf(
            Recipe(1, R.drawable.spaghetti, "Spaghetti", "Delicious spaghetti recipe."),
            Recipe(2, R.drawable.pizza, "Pizza", "Tasty homemade pizza."),
            Recipe(3, R.drawable.salad, "Salad", "Healthy fresh salad.")
        )
    )

    // Kjo do të ekspozojë recetat për të mundësuar observimin nga fragmenti
    val recipes: StateFlow<List<Recipe>> get() = _recipes

    fun filterRecipes(query: String) {
        // Filtron recetat bazuar në query
        val filteredRecipes = if (query.length >= 3) {
            _recipes.value.filter {
                it.title.contains(query, ignoreCase = true) || it.description.contains(query, ignoreCase = true)
            }
        } else {
            _recipes.value // Kthe listën pa ndryshime kur query është më i shkurtër se 3 karaktere
        }

        // Azhurnoni _recipes me recetat e filtruar
        _recipes.value = filteredRecipes
    }
}
