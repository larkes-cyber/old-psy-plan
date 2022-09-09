package lolka.example.PsyPath.data.retrofit.repository

import lolka.example.PsyPath.data.retrofit.model.*
import retrofit2.Response
import retrofit2.Retrofit


interface RetrofitInterface {

    suspend fun pushSomeDataToServer(props:RetrofitSomeData):Response<RetrofitSomeDataResponse>
    suspend fun getSomeData():RetrofitSomeData

    suspend fun pushPatientDataToServer(props: PatientDataRetrofit):Response<PatientDataResponse>
    suspend fun pushTaskToServer(props: RetrofitTask):Response<RetrofitTaskResponse>

    suspend fun checkUser(props:RetrofitLogin):Response<RetrofitSession>

    suspend fun getPatientDataFromServer(props:RetrofitSession):Response<RetrofitPatientDataServer>
}