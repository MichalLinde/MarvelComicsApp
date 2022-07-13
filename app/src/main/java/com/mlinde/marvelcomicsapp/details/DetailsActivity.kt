package com.mlinde.marvelcomicsapp.details

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mlinde.marvelcomicsapp.R
import com.mlinde.marvelcomicsapp.data.ComicBook
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)
    }
}