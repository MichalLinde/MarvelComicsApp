package com.mlinde.marvelcomicsapp.details

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Html
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.mlinde.marvelcomicsapp.GlideApp
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.databinding.FragmentDetailsBinding
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : Fragment() {


    private lateinit var binding: FragmentDetailsBinding
    private lateinit var comicBook: ComicBook
    private val args: DetailsFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        comicBook = args.comicBook

        GlideApp.with(requireContext())
            .load(comicBook.thumbnail.getPath())
            .into(binding.detailsImage)
        binding.apply {

            if (comicBook.creators.items.isEmpty()){
                binding.bottomSheetAuthor.text = "No author was given :("
            } else{
                var authors = ""
                for (creator in comicBook.creators.items){
                    authors += " ${creator.name},"
                }
                binding.bottomSheetAuthor.text = authors.dropLast(1)
            }
            binding.bottomSheetTitle.text = comicBook.title
            if (comicBook.description == null || comicBook.description == ""){
                binding.bottomSheetDescription.text = "Sorry, no description was given :("
            } else{
                binding.bottomSheetDescription.text = comicBook.description
            }
        }

        binding.findOutMoreButton.setOnClickListener {
            if (comicBook.urls.isEmpty()){
                Toast.makeText(requireContext(), "Sorry, no links were given :(", Toast.LENGTH_SHORT).show()
            } else{
                val urlIntent = Intent(Intent.ACTION_VIEW)
                urlIntent.data = Uri.parse(comicBook.urls[0].url)
                startActivity(urlIntent)
            }
        }

    }

}