package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.repository.UserRepository

class UsePushSomeDataToServer(private val userRepository: UserRepository) {

    suspend fun execute(props:SomeData):String{
        return userRepository.pushSomeDataToServer(props = props)
    }

}