package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lolka.example.PsyPath.domain.usecase.*

class AuthViewModelFactory (

    val usePushPatientDataToServer: UsePushPatientDataToServer,
    val useInsertPatientDataToDatabase:UseInsertPatientDataToDatabase,
    val useSaveSession: UseSaveSession

): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return AuthViewModel(
            usePushPatientDataToServer = usePushPatientDataToServer,
            useInsertPatientDataToDatabase = useInsertPatientDataToDatabase,
            useSaveSession = useSaveSession
        ) as T
    }
}