package lolka.example.PsyPath.data.retrofit.repository

import lolka.example.PsyPath.data.retrofit.api.RetrofitInstance
import lolka.example.PsyPath.data.retrofit.model.*
import retrofit2.Response


class RetrofitRepository: RetrofitInterface {
    override suspend fun pushSomeDataToServer(props: RetrofitSomeData): Response<RetrofitSomeDataResponse> {
        return RetrofitInstance().api.pushSomeData(props)
    }

    override suspend fun getSomeData(): RetrofitSomeData {
        return RetrofitInstance().api.getSomeData()
    }

    override suspend fun pushPatientDataToServer(props: PatientDataRetrofit): Response<PatientDataResponse> {
        return RetrofitInstance().api.pushPatientData(props)
    }

    override suspend fun pushTaskToServer(props: RetrofitTask): Response<RetrofitTaskResponse> {
        return RetrofitInstance().api.pushTask(props)
    }

    override suspend fun checkUser(props: RetrofitLogin): Response<RetrofitSession> {
        return RetrofitInstance().api.checkUser(props)
    }

    override suspend fun getPatientDataFromServer(props: RetrofitSession): Response<RetrofitPatientDataServer> {
        return RetrofitInstance().api.getPatientDataServer(props)
    }


}