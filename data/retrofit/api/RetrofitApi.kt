package lolka.example.PsyPath.data.retrofit.api

import lolka.example.PsyPath.data.retrofit.model.*
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST


interface RetrofitApi {

    @GET("posts/1")
    suspend fun getSomeData(): RetrofitSomeData

    @Headers("Content-Type: application/json")
    @POST("/log")
    suspend fun pushSomeData(
       @Body retrofitGoalData: RetrofitSomeData
    ): Response<RetrofitSomeDataResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/reg/patient")
    suspend fun pushPatientData(
        @Body retrofitPatientData: PatientDataRetrofit
    ):Response<PatientDataResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/log")
    suspend fun checkUser(
        @Body retrofitLogin: RetrofitLogin
    ):Response<RetrofitSession>

    @Headers("Content-Type: application/json")
    @POST("/reg/add_task")
    suspend fun pushTask(
        @Body retrofitPatientData: RetrofitTask
    ):Response<RetrofitTaskResponse>

    @Headers("Content-Type: application/json")
    @POST("/api/profile/patient")
    suspend fun getPatientDataServer(
        @Body session: RetrofitSession
    ):Response<RetrofitPatientDataServer>


}