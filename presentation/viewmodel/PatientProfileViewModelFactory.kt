package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lolka.example.PsyPath.domain.usecase.UseGetPatientDataFromDatabase
import lolka.example.PsyPath.domain.usecase.UseInsertPatientDataToDatabase
import lolka.example.PsyPath.domain.usecase.UsePushPatientDataToServer

class PatientProfileViewModelFactory(
    val useGetPatientDataFromDatabase: UseGetPatientDataFromDatabase
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PatientProfileViewModel(
            useGetPatientDataFromDatabase = useGetPatientDataFromDatabase
        ) as T
    }
}