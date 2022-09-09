package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.domain.repository.UserRepository

class UseGetPatientDataFromDatabase(val userRepository: UserRepository) {

    suspend fun execute():PatientData{
        return userRepository.getPatientDataToDatabase()
    }

}