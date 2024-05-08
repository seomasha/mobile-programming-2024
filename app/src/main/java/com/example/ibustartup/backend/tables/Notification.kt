package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("notifications")
data class Notification(
    @PrimaryKey(autoGenerate = true)
    val id: Int
)