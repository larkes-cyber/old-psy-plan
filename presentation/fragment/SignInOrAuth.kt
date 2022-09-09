package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import lolka.example.PsyPath.App.App
import lolka.example.PsyPath.R
import lolka.example.PsyPath.presentation.viewmodel.PatientProfileViewModel
import lolka.example.PsyPath.presentation.viewmodel.PatientProfileViewModelFactory
import lolka.example.PsyPath.presentation.viewmodel.SignOrAuthViewModel
import lolka.example.PsyPath.presentation.viewmodel.SignOrAuthViewModelFactory
import kotlinx.coroutines.launch
import javax.inject.Inject

class SignInOrAuth : BaseFragment() {

    @Inject
    lateinit var vmFactory: SignOrAuthViewModelFactory
    val wm by lazy {
        ViewModelProvider(this, vmFactory).get(SignOrAuthViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in_or_auth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        (getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App).appComponent.injectSignOrAuthFragment(this)

        val sign:AppCompatButton = view.findViewById(R.id.sign_id)
        val auth:AppCompatButton = view.findViewById(R.id.auth)

        wm.lifeResultDatabaseConst.observe(viewLifecycleOwner){

            if(it.name != "none"){
                view.findNavController().navigate(R.id.action_signInOrAuth_to_mainFragment)
            }

        }

        launch {
            wm.getPatient()
        }


        sign.setOnClickListener {
            view.findNavController().navigate(R.id.action_signInOrAuth_to_signIn1)
        }
        auth.setOnClickListener {
            view.findNavController().navigate(R.id.action_signInOrAuth_to_authFragment14)
        }

    }
}