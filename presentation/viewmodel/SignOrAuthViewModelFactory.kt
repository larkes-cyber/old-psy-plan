package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lolka.example.PsyPath.domain.usecase.UseGetPatientDataFromDatabase

class SignOrAuthViewModelFactory(
    val useGetPatientDataFromDatabase: UseGetPatientDataFromDatabase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return SignOrAuthViewModel(
            useGetPatientDataFromDatabase = useGetPatientDataFromDatabase
        ) as T
    }

}