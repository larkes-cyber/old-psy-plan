package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.repository.UserRepository

class UseGetSession(val userRepository: UserRepository) {

    suspend fun execute():Session{
        return userRepository.getSession()
    }

}