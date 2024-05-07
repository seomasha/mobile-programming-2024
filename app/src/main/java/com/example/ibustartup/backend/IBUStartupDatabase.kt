package com.example.ibustartup.backend

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ibustartup.backend.dao.UserDao
import com.example.ibustartup.backend.tables.User

@Database(
    entities = [User::class],
    version = 1,
    exportSchema = false
)
abstract class IBUStartupDatabase : RoomDatabase() {

    abstract fun userDao(): UserDao

    companion object {
        @Volatile
        private var Instance: IBUStartupDatabase? = null

        fun getDatabase(context: Context): IBUStartupDatabase {
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(
                    context,
                    IBUStartupDatabase::class.java,
                    "ibu_startup_database"
                ).fallbackToDestructiveMigration().build().also { Instance = it }
            }
        }
    }
}