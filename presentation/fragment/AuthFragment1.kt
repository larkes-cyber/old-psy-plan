package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import lolka.example.PsyPath.R

class AuthFragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_auth1, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val but:AppCompatButton = view.findViewById(R.id.button)

        but.setOnClickListener {
            view.findNavController().navigate(R.id.action_authFragment14_to_whoAreYouFragment2)

        }
    }

}