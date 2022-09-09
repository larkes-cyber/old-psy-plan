package lolka.example.PsyPath.di

import lolka.example.PsyPath.domain.repository.UserRepository
import lolka.example.PsyPath.domain.usecase.*
import dagger.Module
import dagger.Provides

@Module
class DomainModule {
    @Provides
    fun provideUseGetFromDatabase(userRepository: UserRepository):UseGetFromDatabase{
        return UseGetFromDatabase(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideUseGetSomeDataFromServer(userRepository: UserRepository):UseGetSomeDataFromServer{
        return UseGetSomeDataFromServer(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideUseInsertToDatabase(userRepository: UserRepository):UseInsertToDatabase{
        return UseInsertToDatabase(
            userRepository = userRepository
        )
    }
    @Provides
    fun provideUsePushSomeDataToServer(userRepository: UserRepository):UsePushSomeDataToServer{
        return UsePushSomeDataToServer(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideUsePushPatientDataToServer(userRepository: UserRepository):UsePushPatientDataToServer{
        return UsePushPatientDataToServer(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideInsertPatientDataToDatabase(userRepository: UserRepository):UseInsertPatientDataToDatabase{
        return  UseInsertPatientDataToDatabase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideGetPatientDataFromDatabase(userRepository: UserRepository):UseGetPatientDataFromDatabase{
        return UseGetPatientDataFromDatabase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideInsertTaskToDatabase(userRepository: UserRepository):UseInsertTaskToDatabase{
        return UseInsertTaskToDatabase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideGetTasksFromDatabase(userRepository: UserRepository):UseGetTasksFromDatabase{
        return UseGetTasksFromDatabase(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideSaveSession(userRepository: UserRepository):UseSaveSession{
        return UseSaveSession(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideGetSession(userRepository: UserRepository):UseGetSession{
        return UseGetSession(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideCheckUser(userRepository: UserRepository):UseCheckUser{
        return UseCheckUser(
            userRepository = userRepository
        )
    }

    @Provides
    fun provideGetPatientDataFromServer(userRepository: UserRepository):UseGetPatientDataFromServer{
        return UseGetPatientDataFromServer(userRepository = userRepository)
    }
}