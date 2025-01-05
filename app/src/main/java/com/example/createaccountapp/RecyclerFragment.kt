package com.example.createaccountapp

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recipeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        val recipes = listOf(
            Recipe(1, R.drawable.spaghetti, "Spaghetti", "Delicious spaghetti recipe."),
            Recipe(2, R.drawable.pizza, "Pizza", "Tasty homemade pizza."),
            Recipe(3, R.drawable.salad, "Salad", "Healthy fresh salad.")
        )

        recyclerView.adapter = RecipeAdapter(recipes)

        return view
    }
}
