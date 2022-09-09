package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.repository.UserRepository

class UseSaveSession(val userRepository: UserRepository){
    suspend fun execute(session: Session){
        userRepository.saveSession(session)
    }
}