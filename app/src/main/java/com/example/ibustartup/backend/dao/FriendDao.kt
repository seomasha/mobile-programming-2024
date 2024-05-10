package com.example.ibustartup.backend.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Friends
import kotlinx.coroutines.flow.Flow

@Dao
interface FriendDao {
    @Upsert
    suspend fun upsertFriend(friends: Friends)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertFriend(friends: Friends)

    @Update
    suspend fun updateFriend(friends: Friends)

    @Delete
    suspend fun deleteFriend(friends: Friends)

    @Query("SELECT * FROM friends")
    fun getAllFriends(): Flow<List<Friends>>

    @Query("SELECT * FROM friends WHERE id = :id")
    fun getFriendByID(id: Int): Flow<Friends>
}