package lolka.example.PsyPath.data.storage.database_for_goals.dao

import androidx.room.*
import lolka.example.PsyPath.data.storage.database_for_goals.entity.EntitySomeData
import lolka.example.PsyPath.data.storage.database_for_goals.entity.EntityTask

@Dao
interface TaskDao {
    @Insert
    suspend fun addTask(entityTask: EntityTask)

    @Query("SELECT * FROM EntityTask")
    suspend fun getAllTasks():MutableList<EntityTask>

    @Delete
    suspend fun removeTask(entityTask: EntityTask)

    @Update
    suspend fun updateTask(entityTask: EntityTask)
}