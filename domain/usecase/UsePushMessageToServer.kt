package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Message
import lolka.example.PsyPath.domain.repository.UserRepository

class UsePushMessageToServer(val userRepository: UserRepository) {
    suspend fun execute(message: Message):String{
        return userRepository.pushMessageToServer(props = message)
    }

}