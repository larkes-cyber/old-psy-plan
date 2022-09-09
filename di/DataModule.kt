package lolka.example.PsyPath.di

import android.content.Context
import androidx.room.Room
import lolka.example.PsyPath.App.App
import lolka.example.PsyPath.data.repository.UserRepositoryData
import lolka.example.PsyPath.data.retrofit.repository.RetrofitRepository
import lolka.example.PsyPath.data.storage.Service
import lolka.example.PsyPath.data.storage.database_for_goals.AppDatabase
import lolka.example.PsyPath.data.storage.database_for_goals.dao.SomeDao
import lolka.example.PsyPath.data.storage.database_for_goals.dao.TaskDao
import lolka.example.PsyPath.data.storage.database_for_goals.repository.DataBaseRepository
import lolka.example.PsyPath.data.storage.user_data.PatientData
import lolka.example.PsyPath.domain.repository.UserRepository
import dagger.Module
import dagger.Provides

@Module
class DataModule {
    @Provides
    fun provideDataBase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,"goals_database"
        ).build()
    }


    @Provides
    fun provideSomeDao(database: AppDatabase): SomeDao {
        return database.someDao()
    }

    @Provides
    fun provideTaskDao(database:AppDatabase):TaskDao{
        return database.taskDao()
    }

    @Provides
    fun provideRetrofitRepository(): RetrofitRepository {
        return RetrofitRepository()
    }


    @Provides
    fun provideDataBaseRepository(context: Context): DataBaseRepository {
        return DataBaseRepository(context)
    }


    @Provides
    fun provideService(
        context: Context,
        dataBaseRepository: DataBaseRepository,
        patientData: PatientData
    ): Service {
        return Service(context,dataBaseRepository,patientData)
    }

    @Provides
    fun providePatientData(context: Context): PatientData {
        return PatientData(context)
    }

    @Provides
    fun provideUserRepository(
        service:Service,
        retrofitRepository: RetrofitRepository
    ): UserRepository {
        return lolka.example.PsyPath.data.repository.UserRepositoryData(service, retrofitRepository)

    }
}