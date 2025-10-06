package com.example.lab_week_06.model

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.R

// Gender symbols
private const val FEMALE_SYMBOL = "\u2640"
private const val MALE_SYMBOL = "\u2642"
private const val UNKNOWN_SYMBOL = "?"

class CatViewHolder(
    private val containerView: View,
    private val imageLoader: ImageLoader,
    private val onClickListener: CatAdapter.OnClickListener
)
: RecyclerView.ViewHolder(containerView) {

    // Find the layout views
    private val catBiographyView: TextView by lazy {
        containerView.findViewById(R.id.cat_biography)
    }
    private val catBreedView: TextView by lazy {
        containerView.findViewById(R.id.cat_breed)
    }
    private val catGenderView: TextView by lazy {
        containerView.findViewById(R.id.cat_gender)
    }
    private val catNameView: TextView by lazy {
        containerView.findViewById(R.id.cat_name)
    }
    private val catPhotoView: ImageView by lazy {
        containerView.findViewById(R.id.cat_photo)
    }

    // Called by adapter to bind each cat's data
    fun bindData(cat: CatModel) {
        // Handle click events for each item
        containerView.setOnClickListener {
            onClickListener.onItemClick(cat)
        }

        // Load image and bind text
        imageLoader.loadImage(cat.imageUrl, catPhotoView)
        catNameView.text = cat.name
        catBiographyView.text = cat.biography

        catBreedView.text = when (cat.breed) {
            CatBreed.AmericanCurl -> "American Curl"
            CatBreed.BalineseJavanese -> "Balinese-Javanese"
            CatBreed.ExoticShorthair -> "Exotic Shorthair"
        }

        catGenderView.text = when (cat.gender) {
            Gender.Female -> FEMALE_SYMBOL
            Gender.Male -> MALE_SYMBOL
            Gender.Unknown -> UNKNOWN_SYMBOL
        }
    }
}

// Interface for handling item click events
interface OnClickListener {
    fun onItemClick(cat: CatModel)
}
