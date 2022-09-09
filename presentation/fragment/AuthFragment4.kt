package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import lolka.example.PsyPath.R


class AuthFragment4 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth4, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val bundle = Bundle()
        val but: AppCompatButton = view.findViewById(R.id.button)
        val code:EditText = view.findViewById(R.id.code)
        val error:TextView = view.findViewById(R.id.error)

        but.setOnClickListener {

            if(code.text.toString().isEmpty()){
                error.visibility = View.VISIBLE
            }else{
                bundle.putString("name",arguments?.getString("name"))
                bundle.putString("birthday",arguments?.getString("birthday"))
                bundle.putString("hill",arguments?.getString("hill"))
                bundle.putString("codeOfExpert",code.text.toString())
                bundle.putString("whoAreYou",arguments?.getString("whoAreYou").toString())
                bundle.putString("oms",arguments?.getString("oms").toString())
                bundle.putString("dms",arguments?.getString("dms").toString())
                view.findNavController().navigate(R.id.action_authFragment43_to_authFragment53,bundle)
            }


        }
    }
}