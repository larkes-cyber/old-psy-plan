package lolka.example.PsyPath.data.repository

import android.util.Log
import lolka.example.PsyPath.data.retrofit.model.*
import lolka.example.PsyPath.domain.repository.UserRepository
import lolka.example.PsyPath.data.retrofit.repository.RetrofitRepository
import lolka.example.PsyPath.data.storage.Service
import lolka.example.PsyPath.data.storage.models.PatientDataStorage
import lolka.example.PsyPath.data.storage.models.SessionStorage
import lolka.example.PsyPath.data.storage.models.SomeDataStorage
import lolka.example.PsyPath.data.storage.models.TaskStorage
import lolka.example.PsyPath.domain.model.*
import kotlin.math.log

class UserRepositoryData(
    private val service: Service,
    private val retrofitRepository: RetrofitRepository
    ): UserRepository {

    override suspend fun pushSomeDataToServer(props: SomeData): String {
        val resp = retrofitRepository.pushSomeDataToServer(props = RetrofitSomeData(
            some = props.some
        ))
        return "true"
    }

    override suspend fun getSomeDataFromServer(): SomeData {
        val data:RetrofitSomeData = retrofitRepository.getSomeData()
        return SomeData(some = data.some)
    }


    override suspend fun insertToDataBase(props: SomeData) {
        service.insertToDatabase(props = SomeDataStorage(
            some = props.some
        ))
    }

    override suspend fun getFromDatabase(): SomeData {
        val data = service.getFromDatabase()
        return SomeData(
            id = data.id,
            some = data.some
        )
    }

    override suspend fun pushPatientDataToServer(props: PatientData):Session {
        val data = retrofitRepository.pushPatientDataToServer(PatientDataRetrofit(
            login = props.login,
            password = props.password,
            name = props.name,
            birthday = props.birthday,
            oms = props.oms,
            dms = props.dms,
            disease = props.disease,
            spec_id = props.spec_id
        ))
        Log.d("resp",data.body()?.role.toString())
        Log.d("resp",data.body()?.session.toString())
        return Session(
            session = data.body()?.session.toString(),
            role = data.body()?.role.toString()
        )
    }

    override suspend fun getAllMessages(props: UserDataToGetMessages): MutableList<Message> {

        val array:MutableList<Message> = ArrayList()
        return array

    }

    override suspend fun pushMessageToServer(props: Message): String {

        return "dsfsf"

    }

    override suspend fun insertPatientDataToDatabase(props: PatientData) {
        service.insertPatientDataToDatabase(PatientDataStorage(
            login = props.login,
            password = props.password,
            name = props.name,
            birthday = props.birthday,
            oms = props.oms,
            dms = props.dms,
            disease = props.disease,
            spec_id = props.spec_id
        ))
    }

    override suspend fun getPatientDataToDatabase(): PatientData {

        val props = service.getPatientDataFromDatabase()

        return PatientData(
            login = props.login,
            password = props.password,
            name = props.name,
            birthday = props.birthday,
            oms = props.oms,
            dms = props.dms,
            disease = props.disease,
            spec_id = props.spec_id
        )

    }

    override suspend fun insertTaskToDatabase(task: Task) {
        service.insertTaskToDatabase(
            TaskStorage(
                text = task.text,
                time = task.time
            )
        )
    }

    override suspend fun getTasksFromDatabase(): MutableList<Task> {

        val array:MutableList<Task> = ArrayList()
        val data = service.getTaskFromDatabase()

        for(i in 0 until data.size){
            array.add(
                Task(
                    text = data[i].text,
                    time = data[i].time
                )
            )
        }
        return array
    }

    override suspend fun pushTaskToServer(task: Task): Int {
        val resp = retrofitRepository.pushTaskToServer(RetrofitTask(
            text = task.text,
            time = task.time
        ))

        return resp.body()?.id!!
    }

    override suspend fun saveSession(session: Session) {
        service.saveSession(SessionStorage(
            session = session.session,
            role = session.role
        ))
    }

    override suspend fun getSession(): Session {

        val data = service.getSession()

        return Session(
            session = data.session,
            role = data.role
        )

    }



    override suspend fun checkUser(login: Login): Session {
       val resp = retrofitRepository.checkUser(RetrofitLogin(
           login = login.login,
           password = login.password
       ))

        return Session(
            session = resp.body()!!.session,
            role = resp. body()!!.role
        )
    }

    override suspend fun getPatientDataFromServer(session: Session): PatientDataServer {

        val data = retrofitRepository.getPatientDataFromServer(
            RetrofitSession(
            session = session.session,
            role = session.role
         )
        )

        val pill:MutableList<ElemOfPill> = ArrayList()
        val spec:MutableList<ElemOfSpec> = ArrayList()

        for(i in 0 until data.body()!!.pill.size){
            pill.add(
                ElemOfPill(
                    id = data.body()!!.pill[i].id,
                    name = data.body()!!.pill[i].name,
                    dose = data.body()!!.pill[i].dose
            ))
        }

        for(i in 0 until data.body()!!.spec.size){
            spec.add(
                ElemOfSpec(
                    id = data.body()!!.spec[i].id,
                    name = data.body()!!.spec[i].name,
                    birthday = data.body()!!.spec[i].birthday
                ))
        }

        return PatientDataServer(
            name = data.body()!!.name,
            birthday = data.body()!!.birthday,
            oms = data.body()!!.oms,
            dms = data.body()!!.dms,
            disease = data.body()!!.disease,
            pill = pill,
            spec = spec
        )

    }


}