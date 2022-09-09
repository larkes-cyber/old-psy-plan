package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import lolka.example.PsyPath.App.App
import lolka.example.PsyPath.R
import lolka.example.PsyPath.presentation.viewmodel.AuthViewModel
import lolka.example.PsyPath.presentation.viewmodel.AuthViewModelFactory
import lolka.example.PsyPath.presentation.viewmodel.PatientProfileViewModel
import lolka.example.PsyPath.presentation.viewmodel.PatientProfileViewModelFactory
import kotlinx.coroutines.launch
import org.w3c.dom.Text
import javax.inject.Inject


class ProfileOfPatientFragment : BaseFragment() {

    @Inject
    lateinit var vmFactory: PatientProfileViewModelFactory
    val wm by lazy {
        ViewModelProvider(this, vmFactory).get(PatientProfileViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profile_of_patient, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App).appComponent.injectPatientProfileFragment(this)

        val name:TextView = view.findViewById(R.id.name)
        val birth:TextView = view.findViewById(R.id.birth)
        val email:TextView = view.findViewById(R.id.email)
        val hill:TextView = view.findViewById(R.id.hill)
        val oms:TextView = view.findViewById(R.id.oms)
        val dms:TextView = view.findViewById(R.id.dms)

        wm.lifeResultDatabaseConst.observe(viewLifecycleOwner){
            Toast.makeText(getActivity()?.getApplicationContext(),it.name,Toast.LENGTH_LONG).show()
            Log.d("data",it.name.toString())

            name.text = it.name
            birth.text = "День рождения: ${it.birthday}"
            email.text = "Почта: ${it.login}"
            hill.text = "Заболевания: ${it.disease}"
            oms.text = "ОМС: ${it.oms}"
            dms.text = "ДМС: ${it.dms}"

        }



        launch {
            wm.getUserData()
        }


        val back: ImageView = view.findViewById(R.id.back)

        back.setOnClickListener {
            view.findNavController().navigate(R.id.action_profileOfPatientFragment_to_mainFragment)
        }


    }
}