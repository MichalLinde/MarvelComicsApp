package com.mlinde.marvelcomicsapp.comicsList

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.mlinde.marvelcomicsapp.api.ApiRensponse
import com.mlinde.marvelcomicsapp.data.ComicBook
import com.mlinde.marvelcomicsapp.data.ComicDataWrapper
import com.mlinde.marvelcomicsapp.databinding.FragmentComicsListBinding
import com.mlinde.marvelcomicsapp.details.DetailsActivity
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ComicsListFragment : Fragment() {


    private lateinit var binding: FragmentComicsListBinding
    private val viewModel: ComicsListViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentComicsListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentComicsListBinding.bind(view)
        val newBinding = binding

        setUpComponents()
    }

    private fun setUpAdapter(it: ComicDataWrapper){
        binding.comicsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = ComicsListAdapter(it.data.results) {                onClick(it)            }
        }
    }

    private fun setUpObserver(){
        viewModel.comicsLiveData.observe(viewLifecycleOwner){
            if (it is ApiRensponse.Success){
                it.data?.let { comicModel -> 
                    setUpAdapter(comicModel) 
                }
            }
            else if (it is ApiRensponse.Error){
                Log.e("Error", "setUpObserver: ", it.message)
            }
        }
    }

    private fun setUpComponents(){
        setUpObserver()
        viewModel.getComics()
    }

    private fun onClick(comicBook: ComicBook){
        startActivity(Intent(requireContext(), DetailsActivity::class.java).apply {
         putExtra("comicBook", comicBook)
        })
    }
}
