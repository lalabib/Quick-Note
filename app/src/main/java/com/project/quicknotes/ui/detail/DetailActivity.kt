package com.project.quicknotes.ui.detail

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.project.quicknotes.R
import com.project.quicknotes.data.local.entity.NoteEntities
import com.project.quicknotes.databinding.ActivityDetailBinding
import com.project.quicknotes.ui.main.MainActivity
import com.project.quicknotes.ui.main.MainActivity.Companion.EXTRA_DATA
import dagger.hilt.android.AndroidEntryPoint
import java.util.UUID

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private var note: NoteEntities? = null
    private val detailViewModel: DetailViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setView()
        setData()
    }

    private fun setView() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
        }
    }

    private fun setData() {
        val id = intent.getStringExtra(EXTRA_DATA)
        if (id != null) {
            detailViewModel.getNoteById(id).observe(this@DetailActivity) { detailNote ->
                note = detailNote
                populateNote(detailNote)
                supportActionBar?.title = getString(R.string.detail_title)
            }
        } else {
            supportActionBar?.title = getString(R.string.add_note_title)
        }
    }

    private fun populateNote(note: NoteEntities?) {
        binding.apply {
            edtTitle.setText(note?.title)
            edtDescription.setText(note?.description)
        }
    }

    private fun saveNote() {
        binding.apply {
            val saveNote = if (note != null) {
                NoteEntities(
                    note!!.id,
                    edtTitle.text.toString(),
                    edtDescription.text.toString()
                )
            } else {
                NoteEntities(
                    UUID.randomUUID().toString(),
                    edtTitle.text.toString(),
                    edtDescription.text.toString()
                )
            }


            if (note != null && note!!.id.isNotEmpty()) {
                detailViewModel.updateNote(saveNote)
            } else {
                detailViewModel.insertNote(saveNote)
            }
        }
    }

    private fun deleteNote() {
        if (note != null) {
            binding.apply {
                val deleteNote = NoteEntities(
                    note!!.id,
                    note!!.title,
                    note!!.description
                )

                detailViewModel.deleteNote(deleteNote)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.detail_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.save -> {
                saveNote()
                backToHome()
                true
            }

            R.id.delete -> {
                deleteNote()
                backToHome()
                true
            }

            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    private fun backToHome() {
        val intent = Intent(this@DetailActivity, MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
    }
}