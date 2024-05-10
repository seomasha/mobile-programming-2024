package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("friends")
data class Friends(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "username")
    val username: String,
    @ColumnInfo(name = "logo_image")
    val logoImage: Int
)
