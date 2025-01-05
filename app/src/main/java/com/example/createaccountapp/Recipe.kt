package com.example.createaccountapp

data class Recipe(
    val id: Int,          // ID unike e recetës
    val imageResId: Int,  // ID e imazhit nga drawable (p.sh., R.drawable.recipe_image)
    val title: String,    // Titulli i recetës
    val description: String // Përshkrimi i shkurtër i recetës
)
