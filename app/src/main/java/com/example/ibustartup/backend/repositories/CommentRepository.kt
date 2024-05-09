package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.CommentDao
import com.example.ibustartup.backend.tables.Comment
import kotlinx.coroutines.flow.Flow

class CommentRepository(private val commentDao: CommentDao): BaseRepository<Comment> {
    override suspend fun insert(t: Comment) = commentDao.insertComment(t)

    override suspend fun update(t: Comment) = commentDao.updateComment(t)

    override suspend fun delete(t: Comment) = commentDao.deleteComment(t)

    override suspend fun upsert(t: Comment) = commentDao.upsertComment(t)

    override fun getAll(): Flow<List<Comment>> = commentDao.getAllComments()

    override fun getByID(id: Int): Flow<Comment> = commentDao.getCommentByID(id)

}