package com.example.createaccountapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    private val onLikeClick: (Recipe) -> Unit,
    private val onShareClick: (Recipe) -> Unit
) : ListAdapter<Recipe, RecipeAdapter.RecipeViewHolder>(RecipeDiffCallback()) {

    // ViewHolder for each recipe item
    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recipe_image)
        val titleTextView: TextView = itemView.findViewById(R.id.recipe_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.recipe_description)
        val likeButton: Button = itemView.findViewById(R.id.like_button)
        val shareButton: Button = itemView.findViewById(R.id.share_button)
    }

    // Inflating the layout for each item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    // Binding the data to the views
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = getItem(position) // Use getItem() for ListAdapter

        holder.imageView.setImageResource(recipe.imageResId)
        holder.titleTextView.text = recipe.title
        holder.descriptionTextView.text = recipe.description

        // Click listener for the item view
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Clicked: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }

        // Like button click listener
        holder.likeButton.setOnClickListener {
            onLikeClick(recipe)
        }

        // Share button click listener
        holder.shareButton.setOnClickListener {
            onShareClick(recipe)
        }
    }

    // DiffUtil callback for comparing recipes
    class RecipeDiffCallback : DiffUtil.ItemCallback<Recipe>() {
        override fun areItemsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Recipe, newItem: Recipe): Boolean {
            return oldItem == newItem
        }
    }
}
