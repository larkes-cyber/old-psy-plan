package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.repository.UserRepository

class UseGetSomeDataFromServer(private val userRepository: UserRepository) {

    suspend fun execute():SomeData{
        return userRepository.getSomeDataFromServer()
    }

}