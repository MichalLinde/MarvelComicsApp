package com.mlinde.marvelcomicsapp.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mlinde.marvelcomicsapp.R
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.databinding.ActivityDetailsBinding

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)

        val comicBook = intent.getParcelableExtra<ComicBook>("comicBook") as ComicBook

        if (savedInstanceState == null){
            val detailsFragment = DetailsFragment.newInstance(comicBook)
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.detailsActivityLayout, detailsFragment)
                commit()
            }
        }

    }
}