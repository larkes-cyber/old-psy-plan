package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Message
import lolka.example.PsyPath.domain.model.UserDataToGetMessages
import lolka.example.PsyPath.domain.repository.UserRepository

class UseGetAllMessages(val userRepository: UserRepository) {
    suspend fun execute(data:UserDataToGetMessages):MutableList<Message>{
        return userRepository.getAllMessages(props = data)
    }
}