package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import lolka.example.PsyPath.R


class AuthFragment3 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth3, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val but: ImageView = view.findViewById(R.id.button)
        val text:TextView = view.findViewById(R.id.text)
        val day:EditText = view.findViewById(R.id.birth)
        val hill:EditText = view.findViewById(R.id.hill)
        val error:TextView = view.findViewById(R.id.error)
        val bundle = Bundle()

        text.text = arguments?.getString("name").toString()



        but.setOnClickListener {

            var k = 0
            day.text.toString().forEach {
                if("." == it.toString()){
                    k++
                }
            }

            if(k != 2 || hill.text.toString().length < 3){
                error.visibility = View.VISIBLE
            }else{
                error.visibility = View.GONE
                bundle.putString("name",text.text.toString())
                bundle.putString("birthday",day.text.toString())
                bundle.putString("hill",hill.text.toString())
                bundle.putString("whoAreYou",arguments?.getString("whoAreYou").toString())
                bundle.putString("oms",arguments?.getString("oms").toString())
                bundle.putString("dms",arguments?.getString("dms").toString())
                view.findNavController().navigate(R.id.action_authFragment32_to_authFragment43,bundle)
            }


        }
    }
}