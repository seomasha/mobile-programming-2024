package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.FriendDao
import com.example.ibustartup.backend.tables.Friends
import kotlinx.coroutines.flow.Flow

class FriendsRepository (private val friendsDao: FriendDao): BaseRepository<Friends> {
    override suspend fun insert(t: Friends) = friendsDao.insertFriend(t)

    override suspend fun update(t: Friends) = friendsDao.updateFriend(t)

    override suspend fun delete(t: Friends) = friendsDao.deleteFriend(t)

    override suspend fun upsert(t: Friends) = friendsDao.upsertFriend(t)

    override fun getAll(): Flow<List<Friends>> = friendsDao.getAllFriends()

    override fun getByID(id: Int): Flow<Friends> = friendsDao.getFriendByID(id)
}