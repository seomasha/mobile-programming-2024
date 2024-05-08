package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("positions")
data class Position(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)
