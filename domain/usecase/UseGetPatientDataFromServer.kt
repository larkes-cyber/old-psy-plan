package lolka.example.PsyPath.domain.usecase

import lolka.example.PsyPath.domain.model.PatientDataServer
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.domain.repository.UserRepository

class UseGetPatientDataFromServer(val userRepository: UserRepository){

    suspend fun execute(props:Session):PatientDataServer{
        return userRepository.getPatientDataFromServer(props)
    }

}