package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.Login
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.repository.UserRepository
import kotlin.math.log

class UseCheckUser(val userRepository: UserRepository) {

    suspend fun execute(login: Login):Session{
        return userRepository.checkUser(login)
    }

}