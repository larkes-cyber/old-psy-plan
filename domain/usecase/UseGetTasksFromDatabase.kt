package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Task
import lolka.example.PsyPath.domain.repository.UserRepository

class UseGetTasksFromDatabase(val userRepository: UserRepository) {

    suspend fun execute():MutableList<Task>{
        return userRepository.getTasksFromDatabase()
    }

}