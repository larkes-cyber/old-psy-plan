package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.ViewModel

import lolka.example.PsyPath.domain.model.Login
import lolka.example.PsyPath.domain.model.PatientDataServer
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.usecase.UseCheckUser
import lolka.example.PsyPath.domain.usecase.UseGetPatientDataFromServer
import lolka.example.PsyPath.domain.usecase.UseInsertPatientDataToDatabase
import lolka.example.PsyPath.domain.usecase.UseSaveSession

class SignInViewModel(
    val useCheckUser: UseCheckUser,
    val useSaveSession: UseSaveSession,
    val useGetPatientDataFromServer: UseGetPatientDataFromServer,
    val useInsertPatientDataToDatabase: UseInsertPatientDataToDatabase
):ViewModel() {

    suspend fun check(login: Login):Session{
        return useCheckUser.execute(login)
    }

    suspend fun getPatientData(session: Session): PatientDataServer{
        return useGetPatientDataFromServer.execute(props = session)
    }

    suspend fun saveSession(session: Session){
        return useSaveSession.execute(session)
    }


}