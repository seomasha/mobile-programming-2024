package com.example.ibustartup.backend.repositories

import com.example.ibustartup.backend.dao.NotificationDao
import com.example.ibustartup.backend.tables.Notification
import kotlinx.coroutines.flow.Flow

class NotificationRepository (private val notificationDao: NotificationDao): BaseRepository<Notification> {
    override suspend fun insert(t: Notification) = notificationDao.insertNotification(t)

    override suspend fun update(t: Notification) = notificationDao.updateNotification(t)

    override suspend fun delete(t: Notification) = notificationDao.deleteNotification(t)

    override suspend fun upsert(t: Notification) = notificationDao.upsertNotification(t)

    override fun getAll(): Flow<List<Notification>> = notificationDao.getAllNotifications()

    override fun getByID(id: Int): Flow<Notification> = notificationDao.getNotificationByID(id)
}