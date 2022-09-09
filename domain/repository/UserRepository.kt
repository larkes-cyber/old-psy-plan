package lolka.example.PsyPath.domain.repository

import lolka.example.PsyPath.domain.model.*

interface UserRepository {

    suspend fun pushSomeDataToServer(props: SomeData):String
    suspend fun getSomeDataFromServer():SomeData
    suspend fun insertToDataBase(props: SomeData)
    suspend fun getFromDatabase():SomeData

    suspend fun pushPatientDataToServer(props: PatientData):Session
    suspend fun getAllMessages(props: UserDataToGetMessages):MutableList<Message>
    suspend fun pushMessageToServer(props:Message):String

    suspend fun insertPatientDataToDatabase(props: PatientData)
    suspend fun getPatientDataToDatabase():PatientData

    suspend fun insertTaskToDatabase(task:Task)
    suspend fun getTasksFromDatabase():MutableList<Task>

    suspend fun pushTaskToServer(task:Task):Int

    suspend fun saveSession(session: Session)
    suspend fun getSession():Session

    suspend fun checkUser(login: Login):Session

    suspend fun getPatientDataFromServer(session: Session):PatientDataServer

}