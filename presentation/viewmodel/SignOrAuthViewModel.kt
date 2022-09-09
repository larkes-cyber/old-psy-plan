package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.usecase.UseGetPatientDataFromDatabase

class SignOrAuthViewModel(
   val useGetPatientDataFromDatabase: UseGetPatientDataFromDatabase
):ViewModel() {

    private var lifeResultDatabase = MutableLiveData<PatientData>()
    val lifeResultDatabaseConst: LiveData<PatientData> = lifeResultDatabase

    suspend fun getPatient(){
        lifeResultDatabase.value = useGetPatientDataFromDatabase.execute()
    }

}