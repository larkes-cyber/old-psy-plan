package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.usecase.*
import java.util.*

class AuthViewModel (
    val usePushPatientDataToServer: UsePushPatientDataToServer,
    val useInsertPatientDataToDatabase: UseInsertPatientDataToDatabase,
    val useSaveSession: UseSaveSession

): ViewModel() {

    private var lifeResultDatabase = MutableLiveData<SomeData>()
     val lifeResultDatabaseConst: LiveData<SomeData> = lifeResultDatabase

    private var lifeResultServer = MutableLiveData<SomeData>()
    val lifeResultServerConst: LiveData<SomeData> = lifeResultDatabase

    suspend fun pushToServer(props: PatientData):Session{
        return usePushPatientDataToServer.execute(props)
    }

    suspend fun saveSession(props: Session){
        useSaveSession.execute(session = props)
    }

    suspend fun insertToDatabase(props:PatientData){
        useInsertPatientDataToDatabase.execute(props = props)
    }

}