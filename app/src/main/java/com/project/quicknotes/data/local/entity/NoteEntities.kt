package com.project.quicknotes.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "tb_note")
data class NoteEntities (
    @PrimaryKey
    val id: String,
    val title: String? = "",
    val description: String? = ""
)