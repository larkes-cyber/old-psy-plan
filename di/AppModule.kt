package lolka.example.PsyPath.di

import android.content.Context
import lolka.example.PsyPath.domain.usecase.*
import lolka.example.PsyPath.presentation.viewmodel.*
import dagger.Module
import dagger.Provides

@Module
class AppModule(val context: Context) {

    @Provides
   fun provideContext():Context{
        return context
    }

    @Provides
    fun provideAuthViewModelFactory(
         usePushPatientDataToServer: UsePushPatientDataToServer,
         useInsertPatientDataToDatabase: UseInsertPatientDataToDatabase,
         useSaveSession: UseSaveSession
    ):AuthViewModelFactory{
        return AuthViewModelFactory(
            usePushPatientDataToServer = usePushPatientDataToServer,
            useInsertPatientDataToDatabase = useInsertPatientDataToDatabase,
            useSaveSession = useSaveSession
        )
    }

    @Provides
    fun providePatientProfileViewModelFactory(
        useGetPatientDataFromDatabase: UseGetPatientDataFromDatabase
    ):PatientProfileViewModelFactory{
        return PatientProfileViewModelFactory(
            useGetPatientDataFromDatabase = useGetPatientDataFromDatabase
        )
    }

    @Provides
    fun provideAuthOrSignViewModelFactory(
        useGetPatientDataFromDatabase: UseGetPatientDataFromDatabase
    ):SignOrAuthViewModelFactory{
        return SignOrAuthViewModelFactory(
            useGetPatientDataFromDatabase = useGetPatientDataFromDatabase
        )
    }

    @Provides
    fun provideStateViewModelFactory(
        useInsertTaskToDatabase: UseInsertTaskToDatabase,
        useGetTasksFromDatabase: UseGetTasksFromDatabase,
        useGetSession: UseGetSession
    ):StateViewModelFactory{
        return StateViewModelFactory(
            useGetTasksFromDatabase = useGetTasksFromDatabase,
            useInsertTaskToDatabase = useInsertTaskToDatabase,
            useGetSession = useGetSession
        )
    }

    @Provides
    fun provideSignInViewModelFactory(
        useCheckUser: UseCheckUser,
        useSaveSession: UseSaveSession,
        useGetPatientDataFromServer: UseGetPatientDataFromServer,
        useInsertPatientDataToDatabase: UseInsertPatientDataToDatabase
    ):SignInViewModelFactory{
        return SignInViewModelFactory(
            useCheckUser = useCheckUser,
            useSaveSession = useSaveSession,
            useGetPatientDataFromServer = useGetPatientDataFromServer,
            useInsertPatientDataToDatabase = useInsertPatientDataToDatabase
        )
    }



}