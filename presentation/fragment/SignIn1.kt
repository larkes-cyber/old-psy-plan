package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import kotlinx.coroutines.launch
import lolka.example.PsyPath.R
import lolka.example.PsyPath.domain.model.Login
import lolka.example.PsyPath.domain.model.Session
import lolka.example.PsyPath.presentation.viewmodel.SignInViewModel
import lolka.example.PsyPath.presentation.viewmodel.SignInViewModelFactory
import lolka.example.PsyPath.presentation.viewmodel.SignOrAuthViewModel
import lolka.example.PsyPath.presentation.viewmodel.SignOrAuthViewModelFactory
import javax.inject.Inject
import kotlin.math.log


class SignIn1 : BaseFragment() {

    @Inject
    lateinit var vmFactory: SignInViewModelFactory
    val wm by lazy {
        ViewModelProvider(this, vmFactory).get(SignInViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_in1, container, false)
    }
//button
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       (getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App).appComponent.injectSignInFragment(this)

        val but: AppCompatButton = view.findViewById(R.id.button)
        val pass:EditText = view.findViewById(R.id.pass)
        val login:EditText = view.findViewById(R.id.login)
        val error:TextView = view.findViewById(R.id.error)

         but.setOnClickListener {

             launch {


                 val resp = wm.check(Login(
                     login = login.text.toString(),
                     password = pass.text.toString()
                 ))
               //  Toast.makeText(getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App,resp.session,Toast.LENGTH_LONG).show()

                 if(resp.session != "None") {
                     wm.saveSession(
                         Session(
                             session = resp.session,
                             role = resp.role
                         )
                     )

                     Toast.makeText(getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App,resp.session,Toast.LENGTH_LONG).show()
                     val data = wm.getPatientData(
                         Session(
                             session = resp.session,
                             role = resp.role
                       )
                     )
                     Toast.makeText(getActivity()?.getApplicationContext() as lolka.example.PsyPath.App.App,data.name,Toast.LENGTH_LONG).show()

                     view.findNavController().navigate(R.id.action_signIn1_to_emptyFragment)
                 }else{
                     error.visibility = View.VISIBLE
                 }



//                 if(resp == "true"){
//                   //  view.findNavController().navigate(R.id.action_signIn1_to_authFragment6)
//                 }else{
//                     error.visibility = View.VISIBLE
//                 }
             }

//             if(pass.text.toString().isEmpty() || login.text.toString().isEmpty()){
//                 error.visibility = View.VISIBLE
//             }
//             else{
//                 view.findNavController().navigate(R.id.action_signIn1_to_authFragment6)
//             }

        }
    }

}