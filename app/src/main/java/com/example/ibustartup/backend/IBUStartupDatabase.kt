package com.example.ibustartup.backend

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ibustartup.backend.dao.CommentDao
import com.example.ibustartup.backend.dao.FriendDao
import com.example.ibustartup.backend.dao.InvestorApplyDao
import com.example.ibustartup.backend.dao.InvestorDao
import com.example.ibustartup.backend.dao.NotificationDao
import com.example.ibustartup.backend.dao.PositionDao
import com.example.ibustartup.backend.dao.StartupDao
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.Comment
import com.example.ibustartup.backend.tables.Friends
import com.example.ibustartup.backend.tables.Investor
import com.example.ibustartup.backend.tables.InvestorApply
import com.example.ibustartup.backend.tables.Notification
import com.example.ibustartup.backend.tables.Position
import com.example.ibustartup.backend.tables.Startup
import com.example.ibustartup.backend.tables.User

@Database(
    entities = [User::class, Comment::class, Friends::class, Investor::class, InvestorApply::class, Notification::class, Position::class, Startup::class],
    version = 6,
    exportSchema = false
)
abstract class IBUStartupDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao
    abstract fun commentDao(): CommentDao
    abstract fun investorApplyDao(): InvestorApplyDao
    abstract fun positionDao(): PositionDao
    abstract fun friendDao(): FriendDao
    abstract fun investorDao(): InvestorDao
    abstract fun notificationDao(): NotificationDao
    abstract fun startupDao(): StartupDao


    companion object {
        @Volatile
        private var Instance: IBUStartupDatabase? = null

        fun getDatabase(context: Context): IBUStartupDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context, IBUStartupDatabase::class.java, "ibu_startup_database"
                ).fallbackToDestructiveMigration().build().also { Instance = it }
            }
        }
    }
}