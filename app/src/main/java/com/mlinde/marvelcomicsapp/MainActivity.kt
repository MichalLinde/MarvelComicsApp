package com.mlinde.marvelcomicsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.mlinde.marvelcomicsapp.comicsList.ComicsListFragment
import com.mlinde.marvelcomicsapp.databinding.ActivityMainBinding
import com.mlinde.marvelcomicsapp.searchList.SearchFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewPager: ViewPager
    private lateinit var tabs: TabLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewPager = binding.viewPager
        tabs = binding.tabs

        setUpTabs()

    }

    private fun setUpTabs(){
        val adapter = ViewPagerAdapter(supportFragmentManager)
        adapter.addFragment(ComicsListFragment(), "")
        adapter.addFragment(SearchFragment(), "")

        viewPager.adapter = adapter
        viewPager.setPageTransformer(true, ZoomOutPageTransformer())
        tabs.setupWithViewPager(viewPager)

        tabs.getTabAt(0)!!.setIcon(R.drawable.ic_home_24)
        tabs.getTabAt(1)!!.setIcon(R.drawable.ic_search_24)
    }



}