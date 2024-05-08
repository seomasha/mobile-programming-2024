package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("startups")
data class Startup (
    @PrimaryKey(autoGenerate = true)
    val id: Int
)