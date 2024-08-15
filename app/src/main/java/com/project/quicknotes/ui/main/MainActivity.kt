package com.project.quicknotes.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.project.quicknotes.databinding.ActivityMainBinding
import com.project.quicknotes.ui.detail.DetailActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var noteAdapter: NoteAdapter
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setAction()
        setNote()
    }

    private fun setAction() {
        with(binding) {
            fabAdd.setOnClickListener {
                navigateToAddNote()
            }
        }
    }

    private fun setNote() {
        noteAdapter = NoteAdapter { note ->
            navigateToDetail(note.id)
        }

        binding.rvNote.apply {
            layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
            adapter = noteAdapter
        }

        mainViewModel.getAllNotes.observe(this@MainActivity) {
            if (!it.isNullOrEmpty()) {
                isNotEmpty()
                noteAdapter.submitList(it)
            } else {
                isEmpty()
            }
        }
    }

    private fun isEmpty() {
        binding.apply {
            rvNote.visibility = View.GONE
            tvEmptyNote.visibility = View.VISIBLE
        }
    }

    private fun isNotEmpty() {
        binding.apply {
            rvNote.visibility = View.VISIBLE
            tvEmptyNote.visibility = View.GONE
        }
    }

    private fun navigateToDetail(id: String) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra(EXTRA_DATA, id)
        startActivity(intent)
    }

    private fun navigateToAddNote() {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        startActivity(intent)
    }

    companion object {
        const val EXTRA_DATA = "extra_data"
    }
}