package lolka.example.PsyPath.data.storage.user_data

import android.content.Context
import android.util.Log
import lolka.example.PsyPath.data.storage.models.PatientDataStorage
import lolka.example.PsyPath.data.storage.models.SessionStorage
import kotlin.math.log

class PatientData(
    private val context: Context
) {

    private val sharedPreferences = context.getSharedPreferences("PatientData", Context.MODE_PRIVATE)
    private val sessionSharedPreference = context.getSharedPreferences("Session", Context.MODE_PRIVATE)

    fun getPatientData():PatientDataStorage {
        return PatientDataStorage(
            login = sharedPreferences.getString("login","none"),
            password = sharedPreferences.getString("password","none"),
            name = sharedPreferences.getString("name","none"),
            birthday = sharedPreferences.getString("birthday","none"),
            oms = sharedPreferences.getString("oms","none"),
            dms = sharedPreferences.getString("dms","none"),
            disease = sharedPreferences.getString("disease","none"),
            spec_id = sharedPreferences.getString("spec_id","none")
        )

    }


    fun insertPatientData(data:PatientDataStorage){
        sharedPreferences.edit().putString("login",data.login).apply()
        sharedPreferences.edit().putString("password",data.password).apply()
        sharedPreferences.edit().putString("name",data.name).apply()
        sharedPreferences.edit().putString("birthday",data.birthday).apply()
        sharedPreferences.edit().putString("oms",data.oms).apply()
        sharedPreferences.edit().putString("dms",data.dms).apply()
        sharedPreferences.edit().putString("disease",data.disease).apply()
        sharedPreferences.edit().putString("spec_id",data.spec_id).apply()
    }

    fun saveSession(props:SessionStorage){
        sessionSharedPreference.edit().putString("session",props.session).apply()
        sessionSharedPreference.edit().putString("role",props.role).apply()
    }

    fun getSession():SessionStorage{
        return SessionStorage(
            session = sessionSharedPreference.getString("session","none").toString(),
            role = sessionSharedPreference.getString("role","none").toString()
        )
    }

//    val login:String,
//    val password:String,
//    val name:String,
//    val birthday:String,
//    val oms:String,
//    val dms:String,
//    val disease:String,
//    val spec_id:String

}