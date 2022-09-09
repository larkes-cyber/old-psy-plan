package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import lolka.example.PsyPath.App.App
import lolka.example.PsyPath.R
import lolka.example.PsyPath.domain.model.PatientData
import lolka.example.PsyPath.domain.model.SomeData
import lolka.example.PsyPath.presentation.viewmodel.AuthViewModel
import lolka.example.PsyPath.presentation.viewmodel.AuthViewModelFactory
import kotlinx.coroutines.launch
import lolka.example.PsyPath.domain.model.Session
import javax.inject.Inject


class AuthFragment : BaseFragment() {

    @Inject
    lateinit var vmFactory:AuthViewModelFactory
    val wm by lazy {
        ViewModelProvider(this, vmFactory).get(AuthViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    //that

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App).appComponent.injectSomeFragment(this)


        Log.d("data","name: ${arguments?.getString("name")}")
        Log.d("data","birthday: ${arguments?.getString("birthday")}")
        Log.d("data","hill: ${arguments?.getString("hill")}")
        Log.d("data","count: ${arguments?.getString("count")}")
        Log.d("data","codeOfExpert: ${arguments?.getString("codeOfExpert")}")
        Log.d("data","pass: ${arguments?.getString("pass")}")
        Log.d("data","contact: ${arguments?.getString("contact")}")
        Log.d("data","dms: ${arguments?.getString("dms")}")
        Log.d("data","oms: ${arguments?.getString("oms")}")

        launch {
            wm.insertToDatabase(
                PatientData(
                    login = arguments?.getString("contact"),
                    password = arguments?.getString("pass"),
                    name = arguments?.getString("name"),
                    birthday = arguments?.getString("birthday"),
                    oms = arguments?.getString("oms"),
                    dms = arguments?.getString("dms"),
                    disease = arguments?.getString("hill"),
                    spec_id = "NzsKND"
                )
            )
        }

        launch {
            val sess = wm.usePushPatientDataToServer.execute(
                PatientData(
                    login = arguments?.getString("contact"),
                    password = arguments?.getString("pass"),
                    name = arguments?.getString("name"),
                    birthday = "${arguments?.getString("birthday")} 00:00:00",
                    oms = arguments?.getString("oms"),
                    dms = arguments?.getString("dms"),
                    disease = arguments?.getString("hill"),
                    spec_id = "NzsKND"

                )
            )
            Toast.makeText(getActivity()?.getApplicationContext() as App,sess.session, Toast.LENGTH_LONG).show()
            wm.saveSession(sess)

        }

        val timer = object: CountDownTimer(2000, 1000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                view.findNavController().navigate(R.id.action_authFragment6_to_emptyFragment)
            }
        }
        timer.start()
    }
}