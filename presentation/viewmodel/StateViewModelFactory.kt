package lolka.example.PsyPath.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import lolka.example.PsyPath.domain.usecase.*

class StateViewModelFactory(
    val useGetTasksFromDatabase: UseGetTasksFromDatabase,
    val useInsertTaskToDatabase: UseInsertTaskToDatabase,
    val useGetSession: UseGetSession
): ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StateViewModel(
            useInsertTaskToDatabase = useInsertTaskToDatabase,
            useGetTasksFromDatabase = useGetTasksFromDatabase,
            useGetSession = useGetSession
        ) as T
    }

}