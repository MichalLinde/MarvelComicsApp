package com.mlinde.marvelcomicsapp.searchList

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlinde.marvelcomicsapp.comicsList.ComicsListAdapter
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.databinding.FragmentSearchBinding
import com.mlinde.marvelcomicsapp.details.DetailsActivity


class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var viewModel: SearchViewModel
    private var clicked: Boolean = false

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchButton  = binding.searchButton

        searchButton.setOnClickListener {
            val searchText = binding.searchInput.text.toString()
            if (searchText != null){
                binding.infoLayout.isVisible = false
                setUpComponents(searchText)
                setUpFoundObserver()
            }
        }
    }

    private fun setUpFoundObserver(){
        viewModel.foudnData.observe(viewLifecycleOwner){
            if (it == false){
                binding.apply {
                    searchRV.isVisible = false
                    notFoundLayout.isVisible = true
                }
            } else{
                binding.apply {
                    searchRV.isVisible = true
                    notFoundLayout.isVisible = false
                }
            }
        }
    }

    private fun setUpAdapter(it: ComicDataWrapper){
        binding.searchRV.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ComicsListAdapter(it.data.results){
                onClick(it)
            }
        }
        binding.searchRV.adapter!!.notifyDataSetChanged()
    }

    private fun setUpObserver(){
        viewModel.comicsLiveData.observe(viewLifecycleOwner){
            it?.let {
                setUpAdapter(it)
            }
        }
    }

    private fun setUpComponents(searchText: String){
        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)
        setUpObserver()
        viewModel.searchComics(searchText)
    }
    private fun onClick(comicBook: ComicBook){
        val intent = Intent(requireContext(), DetailsActivity::class.java)
        intent.putExtra("comicBook", comicBook)
        startActivity(intent)
    }



}