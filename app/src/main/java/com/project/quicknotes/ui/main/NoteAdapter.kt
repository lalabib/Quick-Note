package com.project.quicknotes.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.project.quicknotes.data.local.entity.NoteEntities
import com.project.quicknotes.databinding.ItemNoteBinding

class NoteAdapter(private val onItemClick: (NoteEntities) -> Unit) :
    ListAdapter<NoteEntities, NoteAdapter.NoteViewHolder>(NoteDiffUtil) {

    object NoteDiffUtil : DiffUtil.ItemCallback<NoteEntities>() {
        override fun areItemsTheSame(oldItem: NoteEntities, newItem: NoteEntities): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: NoteEntities, newItem: NoteEntities): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        val binding = ItemNoteBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return NoteViewHolder(onItemClick, binding)
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = getItem(position)
        if (note != null) {
            holder.bind(note)
        }
    }

    class NoteViewHolder(
        private val onItemClick: (NoteEntities) -> Unit,
        private val binding: ItemNoteBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(note: NoteEntities) {
            binding.apply {
                tvTitle.text = note.title
                tvDescription.text = note.description
            }

            itemView.setOnClickListener { onItemClick(note) }
        }
    }
}