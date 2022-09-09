package lolka.example.PsyPath.data.storage

import lolka.example.PsyPath.data.storage.models.PatientDataStorage
import lolka.example.PsyPath.data.storage.models.SessionStorage
import lolka.example.PsyPath.data.storage.models.SomeDataStorage
import lolka.example.PsyPath.data.storage.models.TaskStorage
import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.model.Task

interface InterfaceService {
    suspend fun getFromDatabase(): SomeDataStorage
    suspend fun insertToDatabase(props: SomeDataStorage)
    suspend fun getPatientDataFromDatabase(): PatientDataStorage
    suspend fun insertPatientDataToDatabase(props: PatientDataStorage)

    suspend fun insertTaskToDatabase(task: TaskStorage)
    suspend fun getTaskFromDatabase(): MutableList<TaskStorage>

    suspend fun saveSession(props:SessionStorage)
    suspend fun getSession():SessionStorage
}