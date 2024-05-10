package com.example.ibustartup.backend.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.example.ibustartup.backend.tables.Notification
import kotlinx.coroutines.flow.Flow

interface NotificationDao {
       @Upsert
        suspend fun upsertNotification(notification: Notification)
        @Insert(onConflict = OnConflictStrategy.IGNORE)
        suspend fun insertNotification(notification: Notification)

        @Update
        suspend fun updateNotification(notification: Notification)

        @Delete
        suspend fun deleteNotification(notification: Notification)

        @Query("SELECT * FROM notifications")
        fun getAllNotifications(): Flow<List<Notification>>

        @Query("SELECT * FROM notifications WHERE id = :id")
        fun getNotificationByID(id: Int): Flow<Notification>
}