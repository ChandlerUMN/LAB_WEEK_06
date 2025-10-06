package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.*
import androidx.recyclerview.widget.ItemTouchHelper

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.recycler_view)
    }

    private val catAdapter by lazy {
        // Glide is used here to load the images
        // Here we are passing the onClickListener function to the Adapter
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatAdapter.OnClickListener {
                // When this is triggered, the pop up dialog will be shown
                override fun onItemClick(cat: CatModel) = showSelectionDialog(cat)
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Setup the adapter for the recycler view
        recyclerView.adapter = catAdapter

        // Setup the layout manager for the recycler view
        recyclerView.layoutManager = LinearLayoutManager(
            this,
            LinearLayoutManager.VERTICAL,
            false
        )

        // Add data to the model list in the adapter
        catAdapter.setData(
            listOf(
                CatModel(
                    Gender.Male,
                    CatBreed.BalineseJavanese,
                    "Fred",
                    "Silent and deadly",
                    "https://cdn2.thecatapi.com/images/7dj.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.ExoticShorthair,
                    "Wilma",
                    "Cuddly assassin",
                    "https://cdn2.thecatapi.com/images/egv.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.AmericanCurl,
                    "Curious George",
                    "Award winning investigator",
                    "https://cdn2.thecatapi.com/images/bar.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Bengal,
                    "Shadow",
                    "Fast and playful",
                    "https://cdn2.thecatapi.com/images/O3btzLlsO.png"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.MaineCoon,
                    "Luna",
                    "Loves naps and attention",
                    "https://cdn2.thecatapi.com/images/MTY3ODIyMQ.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.Sphynx,
                    "Baldy",
                    "Chills a lot, literally",
                    "https://cdn2.thecatapi.com/images/BDb8ZXb1v.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Siamese,
                    "Misty",
                    "Talkative and elegant",
                    "https://cdn2.thecatapi.com/images/ai6Jps4sx.jpg"
                ),
                CatModel(
                    Gender.Unknown,
                    CatBreed.Ragdoll,
                    "Coco",
                    "Soft as a cloud",
                    "https://cdn2.thecatapi.com/images/KBroiVNcm.jpg"
                ),
                CatModel(
                    Gender.Male,
                    CatBreed.BritishShorthair,
                    "Oliver",
                    "Loves climbing curtains",
                    "https://cdn2.thecatapi.com/images/nhXzQyq0C.jpg"
                ),
                CatModel(
                    Gender.Female,
                    CatBreed.Birman,
                    "Snowy",
                    "Graceful and sweet",
                    "https://cdn2.thecatapi.com/images/HOrX5gwLS.jpg"
                )
            )
        )


        //Instantiate ItemTouchHelper for the swipe to delete callback and
        //attach it to the recycler view
        val itemTouchHelper = ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

    }

    // This will create a pop up dialog when one of the items from the recycler view is clicked
    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
