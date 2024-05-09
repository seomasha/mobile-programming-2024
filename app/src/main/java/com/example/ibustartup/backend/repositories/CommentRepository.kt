package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.CommentDao
import com.example.ibustartup.backend.tables.Comment
import kotlinx.coroutines.flow.Flow

class CommentRepository(private val commentDao: CommentDao) {

    suspend fun upsertComment(comment: Comment) = commentDao.upsertComment(comment)

    suspend fun insertComment(comment: Comment) = commentDao.insertComment(comment)

    suspend fun updateComment(comment: Comment) = commentDao.updateComment(comment)

    suspend fun deleteComment(comment: Comment) = commentDao.deleteComment(comment)

    fun getAllComments(): Flow<List<Comment>> = commentDao.getAllComments()

    fun getCommentByID(id: Int): Flow<Comment> = commentDao.getCommentByID(id)
}