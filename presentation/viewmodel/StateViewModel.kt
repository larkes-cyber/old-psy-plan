package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.model.Task
import lolka.example.PsyPath.domain.usecase.UseGetSession
import lolka.example.PsyPath.domain.usecase.UseGetTasksFromDatabase
import lolka.example.PsyPath.domain.usecase.UseInsertTaskToDatabase
import lolka.example.PsyPath.domain.usecase.UseSaveSession

class StateViewModel(
    val useInsertTaskToDatabase: UseInsertTaskToDatabase,
    val useGetTasksFromDatabase: UseGetTasksFromDatabase,
    val useGetSession: UseGetSession
):ViewModel() {

    private var lifeResultDatabase = MutableLiveData<MutableList<Task>>()
    val lifeResultDatabaseConst: LiveData<MutableList<Task>> = lifeResultDatabase

    suspend fun getTasks(){
        lifeResultDatabase.value = useGetTasksFromDatabase.execute()
    }

    suspend fun insertTask(task: Task){
        useInsertTaskToDatabase.execute(task)
    }

    suspend fun getSession():Session{
        return useGetSession.execute()
    }


}