package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Task
import lolka.example.PsyPath.domain.repository.UserRepository

class UseInsertTaskToDatabase(val userRepository: UserRepository) {

    suspend fun execute(task:Task){
         userRepository.insertTaskToDatabase(task = task)
    }
}