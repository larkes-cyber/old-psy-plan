package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.repository.UserRepository

class UsePushPatientDataToServer(val userRepository: UserRepository){

    suspend fun execute(props:PatientData):Session{
       return userRepository.pushPatientDataToServer(props = props)
    }

}