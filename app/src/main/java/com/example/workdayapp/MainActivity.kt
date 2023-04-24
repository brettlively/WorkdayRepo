package com.example.workdayapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.workdayapp.viewmodel.MainViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var searchBar: SearchView
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: NasaAdapter
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // initialize
        searchBar = findViewById(R.id.search_view)
        recyclerView = findViewById(R.id.recycler_view)
        adapter = NasaAdapter()
        viewModel = ViewModelProvider(this)[MainViewModel::class.java]

        viewModel.images.observe(this) {
            adapter.setAdapterData(it)
        }

        viewModel.filteredImages.observe(this) {
            adapter.setAdapterData(it)
        }

        // search
        searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                viewModel.filterList(newText)
                return true
            }
        })

        // recycler view
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        viewModel.fetchData()
    }
}

