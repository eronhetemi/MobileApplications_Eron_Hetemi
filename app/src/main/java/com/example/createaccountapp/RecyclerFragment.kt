package com.example.createaccountapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.createaccountapp.Recipe
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class RecyclerFragment : Fragment() {

    private lateinit var recipeAdapter: RecipeAdapter
    private lateinit var viewModel: RecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_recycler, container, false)

        val recyclerView: RecyclerView = view.findViewById(R.id.recipeRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(context)

        // Krijoni adapterin dhe kaloni eventet
        recipeAdapter = RecipeAdapter(
            onLikeClick = { recipe -> /* Handle Like action */ },
            onShareClick = { recipe -> /* Handle Share action */ }
        )
        recyclerView.adapter = recipeAdapter

        // Përdorni ViewModel dhe koleksiononi rezultatet
        viewModel = ViewModelProvider(this).get(RecipeViewModel::class.java)

        lifecycleScope.launchWhenStarted {
            viewModel.recipes.collect { recipes -> // Ndrysho 'Recipe' në 'recipes'
                recipeAdapter.submitList(recipes) // Azhurnoni listën në adapter
            }
        }

        return view
    }
}
