package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.repository.UserRepository

class UseInsertToDatabase(val userRepository: UserRepository) {

    suspend fun execute(props:SomeData){
        userRepository.insertToDataBase(props = props)
    }

}