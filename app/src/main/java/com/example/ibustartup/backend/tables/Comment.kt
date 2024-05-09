package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("comments")
data class Comment(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0,
    @ColumnInfo("user_id")
    val userID: Int,
    @ColumnInfo("position_id")
    val positionID: Int,
    @ColumnInfo("comment_body")
    val commentBody: String
)
