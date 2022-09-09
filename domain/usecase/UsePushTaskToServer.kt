package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Task
import lolka.example.PsyPath.domain.repository.UserRepository

class UsePushTaskToServer(val userRepository: UserRepository) {

    suspend fun execute(task:Task):Int{
       return userRepository.pushTaskToServer(task = task)
    }
}