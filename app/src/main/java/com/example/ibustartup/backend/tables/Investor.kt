package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("investors")
data class Investor (
    @PrimaryKey(autoGenerate = true)
    val id: Int
)