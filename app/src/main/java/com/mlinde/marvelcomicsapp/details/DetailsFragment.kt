package com.mlinde.marvelcomicsapp.details

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.ui.platform.ComposeView
import androidx.navigation.fragment.navArgs
import com.mlinde.marvelcomicsapp.data.ComicBook
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {


    private lateinit var comicBook: ComicBook
    private val args: DetailsFragmentArgs by navArgs()

    @OptIn(ExperimentalMaterialApi::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        comicBook = args.comicBook
        return ComposeView(requireContext()).apply {
            setContent {
                Details(comicBook)
            }
        }
    }
}