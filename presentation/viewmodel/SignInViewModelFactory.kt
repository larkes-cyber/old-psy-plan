package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lolka.example.PsyPath.domain.usecase.UseCheckUser
import lolka.example.PsyPath.domain.usecase.UseGetPatientDataFromServer
import lolka.example.PsyPath.domain.usecase.UseInsertPatientDataToDatabase
import lolka.example.PsyPath.domain.usecase.UseSaveSession

class SignInViewModelFactory(
    val useCheckUser: UseCheckUser,
    val useSaveSession: UseSaveSession,
    val useGetPatientDataFromServer: UseGetPatientDataFromServer,
    val useInsertPatientDataToDatabase: UseInsertPatientDataToDatabase
): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignInViewModel(
            useCheckUser = useCheckUser,
            useSaveSession = useSaveSession,
            useGetPatientDataFromServer = useGetPatientDataFromServer,
            useInsertPatientDataToDatabase = useInsertPatientDataToDatabase
        ) as T
    }
}