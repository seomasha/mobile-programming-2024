package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("startups")
data class Startup (
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0,
    @ColumnInfo("name")
    val name: String,
    @ColumnInfo("username")
    val username: String,
    /*@ColumnInfo("logo_image")
    val logoImage: Int
    */
)