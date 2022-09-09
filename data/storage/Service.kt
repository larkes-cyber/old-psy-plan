package lolka.example.PsyPath.data.storage

import android.content.Context
import lolka.example.PsyPath.data.storage.database_for_goals.repository.DataBaseRepository
import lolka.example.PsyPath.data.storage.models.PatientDataStorage
import lolka.example.PsyPath.data.storage.models.SessionStorage
import lolka.example.PsyPath.data.storage.models.SomeDataStorage
import lolka.example.PsyPath.data.storage.models.TaskStorage
import lolka.example.PsyPath.data.storage.user_data.PatientData

class Service(
    context:Context,
    private val dataBaseRepository: DataBaseRepository,
    private val patientData:PatientData
): InterfaceService {

    private val context = context
    override suspend fun getFromDatabase(): SomeDataStorage {
      return dataBaseRepository.getFromDatabase()
    }

    override suspend fun insertToDatabase(props: SomeDataStorage) {
        dataBaseRepository.insertToDatabase(props = props)
    }

    override suspend fun getPatientDataFromDatabase(): PatientDataStorage {
        return patientData.getPatientData()
    }

    override suspend fun insertPatientDataToDatabase(props: PatientDataStorage) {
        patientData.insertPatientData(props)
    }

    override suspend fun insertTaskToDatabase(task: TaskStorage) {
        dataBaseRepository.insertTaskToDatabase(task = task)
    }

    override suspend fun getTaskFromDatabase(): MutableList<TaskStorage> {
        return dataBaseRepository.getTaskFromDatabase()
    }

    override suspend fun saveSession(props: SessionStorage) {
        patientData.saveSession(props)
    }

    override suspend fun getSession(): SessionStorage {
        return patientData.getSession()
    }

}