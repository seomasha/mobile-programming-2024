package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("notifications")
data class Notification(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int,
    @ColumnInfo("profileImage")
    val profileImage: Int,
    @ColumnInfo("message")
    val message: String
)