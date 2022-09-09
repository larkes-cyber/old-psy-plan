package lolka.example.PsyPath.data.storage.database_for_goals

import androidx.room.Database
import androidx.room.RoomDatabase
import lolka.example.PsyPath.data.storage.database_for_goals.dao.SomeDao
import lolka.example.PsyPath.data.storage.database_for_goals.dao.TaskDao
import lolka.example.PsyPath.data.storage.database_for_goals.entity.EntitySomeData
import lolka.example.PsyPath.data.storage.database_for_goals.entity.EntityTask

//gfghfghfh
@Database(entities = [EntitySomeData::class,EntityTask::class], version = 1)
abstract class AppDatabase:RoomDatabase() {
    abstract fun someDao(): SomeDao
    abstract fun taskDao():TaskDao
}