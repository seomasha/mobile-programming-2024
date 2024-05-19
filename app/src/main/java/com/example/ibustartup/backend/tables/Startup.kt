package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "startups", foreignKeys = [ForeignKey(entity = User::class, parentColumns = ["id"], childColumns = ["user_id"])])
data class Startup (
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("username")
    val username: String,
    @ColumnInfo("user_id")
    val userID: Int
    /*@ColumnInfo("logo_image")
    val logoImage: Int
    */
)