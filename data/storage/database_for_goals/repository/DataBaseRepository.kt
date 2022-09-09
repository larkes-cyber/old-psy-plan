package lolka.example.PsyPath.data.storage.database_for_goals.repository

import android.content.Context
import lolka.example.PsyPath.App.App

import lolka.example.PsyPath.data.storage.InterfaceService
import lolka.example.PsyPath.data.storage.database_for_goals.dao.SomeDao
import lolka.example.PsyPath.data.storage.database_for_goals.dao.TaskDao
import lolka.example.PsyPath.data.storage.database_for_goals.entity.EntitySomeData
import lolka.example.PsyPath.data.storage.database_for_goals.entity.EntityTask
import lolka.example.PsyPath.data.storage.models.PatientDataStorage
import lolka.example.PsyPath.data.storage.models.SessionStorage
import lolka.example.PsyPath.data.storage.models.SomeDataStorage
import lolka.example.PsyPath.data.storage.models.TaskStorage
import javax.inject.Inject
import kotlin.math.log


class DataBaseRepository(private val context: Context): InterfaceService {
    @Inject
    lateinit var taskDao: TaskDao
    lateinit var someDao: SomeDao

    init{
        (context as lolka.example.PsyPath.App.App).appComponent.injectDataBaseRepository(this)
    }

    override suspend fun getFromDatabase(): SomeDataStorage {
        val data = someDao.getAllSome()[0]
        return SomeDataStorage(
            some = data.some
        )
    }

    override suspend fun insertToDatabase(props: SomeDataStorage) {
        someDao.addSome(entitySomeData = EntitySomeData(
            some = props.some
        ))
    }

    override suspend fun getPatientDataFromDatabase(): PatientDataStorage {
        return PatientDataStorage(
            login = "sdfedsdf",
            password = "sdfedsdf",
            name = "sdfedsdf",
            birthday = "sdfedsdf",
            oms = "sdfedsdf",
            dms = "sdfedsdf",
            disease = "sdfedsdf",
            spec_id = "sdfedsdf"

        )
    }

    override suspend fun insertPatientDataToDatabase(props: PatientDataStorage) {

    }

    override suspend fun insertTaskToDatabase(task: TaskStorage) {
        taskDao.addTask(EntityTask(
            text = task.text,
            time = task.time
        ))
    }

    override suspend fun getTaskFromDatabase(): MutableList<TaskStorage> {

        val data = taskDao.getAllTasks()
        val array:MutableList<TaskStorage> = ArrayList()

        for(i in 0 until data.size){
            array.add(
                TaskStorage(
                time = data[i].time,
                text = data[i].text
            )
            )
        }
        return array
    }

    override suspend fun saveSession(props: SessionStorage) {

    }

    override suspend fun getSession(): SessionStorage {
        return SessionStorage(
            "sdf","efsdf"
        )
    }

}