package com.example.ibustartup.backend.tables

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity("investor_applies")
data class InvestorApply(
    @PrimaryKey(autoGenerate = true)
    @NotNull
    val id: Int = 0,
    @ColumnInfo("user_id")
    val userID: Int,
    @ColumnInfo("investor_id")
    val investorID: Int
)
