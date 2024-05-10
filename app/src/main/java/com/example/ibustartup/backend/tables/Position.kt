package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("positions")
data class Position(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int,
    val positionName: String,
    val positionDescription: String,
    val likeCount: Int,
    val commentCount: Int,
    val applyCount: Int,
    val userID: Int
)