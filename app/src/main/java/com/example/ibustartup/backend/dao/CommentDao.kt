package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Comment
import kotlinx.coroutines.flow.Flow

@Dao
interface CommentDao {

    @Upsert
    suspend fun upsertComment(comment: Comment)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertComment(comment: Comment)

    @Update
    suspend fun updateComment(comment: Comment)

    @Delete
    suspend fun deleteComment(comment: Comment)

    @Query("SELECT * FROM comments")
    fun getAllComments(): Flow<List<Comment>>

    @Query("SELECT * FROM comments WHERE id = :id")
    fun getCommentByID(id: Int): Flow<Comment>
}