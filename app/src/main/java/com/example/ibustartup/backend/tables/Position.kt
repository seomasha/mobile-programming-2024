package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "positions", foreignKeys = [ForeignKey (entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])])
data class Position(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0,
    @ColumnInfo("position_name")
    val positionName: String,
    @ColumnInfo("position_description")
    val positionDescription: String,
    @ColumnInfo("like_count")
    val likeCount: Int=0,
    @ColumnInfo("comment_count")
    val commentCount: Int=0,
    @ColumnInfo("apply_count")
    val applyCount: Int=0,
    @ColumnInfo("user_id")
    val userID: Int
)
