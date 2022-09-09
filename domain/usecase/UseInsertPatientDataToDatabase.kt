package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.repository.UserRepository

class UseInsertPatientDataToDatabase(val userRepository: UserRepository) {

    suspend fun execute(props:PatientData){
        userRepository.insertPatientDataToDatabase(props = props)
    }

}