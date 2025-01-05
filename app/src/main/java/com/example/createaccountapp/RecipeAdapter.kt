package com.example.createaccountapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(
    private val recipeList: List<Recipe> // Lista e recetave që do të shfaqen
) : RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder>() {

    // Krijo një ViewHolder që përfaqëson një artikull të vetëm në listë
    class RecipeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.recipe_image)
        val titleTextView: TextView = itemView.findViewById(R.id.recipe_title)
        val descriptionTextView: TextView = itemView.findViewById(R.id.recipe_description)
        val likeButton: Button = itemView.findViewById(R.id.like_button)
        val shareButton: Button = itemView.findViewById(R.id.share_button)
    }

    // Inflate layout-in për secilin artikull
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecipeViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return RecipeViewHolder(view)
    }

    // Vendos të dhënat për secilin artikull
    override fun onBindViewHolder(holder: RecipeViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.imageView.setImageResource(recipe.imageResId)
        holder.titleTextView.text = recipe.title
        holder.descriptionTextView.text = recipe.description

        // Event për klikimin e një artikulli
        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Clicked: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }

        // Event për butonin Like
        holder.likeButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Liked: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }

        // Event për butonin Share
        holder.shareButton.setOnClickListener {
            Toast.makeText(holder.itemView.context, "Shared: ${recipe.title}", Toast.LENGTH_SHORT).show()
        }
    }

    // Tregon numrin e artikujve në listë
    override fun getItemCount(): Int {
        return recipeList.size
    }
}
