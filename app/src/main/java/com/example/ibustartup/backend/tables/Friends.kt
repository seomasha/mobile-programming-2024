package com.example.ibustartup.backend.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("friends")
data class Friends(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0
)
