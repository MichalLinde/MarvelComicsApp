package com.mlinde.marvelcomicsapp.searchList

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlinde.marvelcomicsapp.R
import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.comicsList.ComicsListAdapter
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.databinding.FragmentSearchBinding
import com.mlinde.marvelcomicsapp.details.DetailsActivity
import com.mlinde.marvelcomicsapp.details.DetailsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private lateinit var binding: FragmentSearchBinding
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val searchBar = binding.searchInput

        searchBar.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val searchText = binding.searchInput.text.toString()
                if (searchText != null){
                    binding.infoLayout.isVisible = false
                    setUpComponents(searchText)
                    setUpFoundObserver()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
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
            if (it is ApiRensponse.Success){
                it.data?.let { it1 -> setUpAdapter(it1) }
            }
            else if (it is ApiRensponse.Error){
                Log.e("Error", "setUpObserver: ", it.message)
            }
        }
    }

    private fun setUpComponents(searchText: String){
        setUpObserver()
        viewModel.searchComics(searchText)
    }
    private fun onClick(comicBook: ComicBook){
        val intent = Intent(requireContext(), DetailsActivity::class.java)
        intent.putExtra("comicBook", comicBook)
        startActivity(intent)
    }



}