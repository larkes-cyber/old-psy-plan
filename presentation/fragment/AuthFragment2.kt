package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import lolka.example.PsyPath.R


class AuthFragment2 : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("kek","dsfsdf")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragmen

        return inflater.inflate(R.layout.fragment_auth2, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val bundle = Bundle()

        val but: AppCompatButton = view.findViewById(R.id.buttonf)
        val name:TextView = view.findViewById(R.id.name)
        val error:TextView = view.findViewById(R.id.error)

        but.setOnClickListener {

            if(name.text.toString().isEmpty()){
                error.visibility = View.VISIBLE
            }else{
                bundle.putString("name",name.text.toString())
                bundle.putString("whoAreYou",arguments?.getString("whoAreYou").toString())
                view.findNavController().navigate(R.id.action_authFragment22_to_omsAndDmsFragment,bundle)
            }


        }
    }
}