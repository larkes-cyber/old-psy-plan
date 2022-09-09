package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import lolka.example.PsyPath.R


class WhoAreYouFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_who_are_you, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val but: AppCompatButton = view.findViewById(R.id.button)
        val switch:TextView = view.findViewById(R.id.other_dude)
        val name:AppCompatButton = view.findViewById(R.id.name)

        val bundle = Bundle()

        var flag = false

        name.setOnClickListener {
            flag = !flag
            switch.visibility = if(flag) View.VISIBLE else View.GONE
            if(flag){
                name.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_baseline_keyboard_arrow_up_24,0)
            }else{
                name.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_baseline_keyboard_arrow_down_24,0)
            }

        }

        switch.setOnClickListener {
            val state = name.text
            name.text = switch.text
            switch.text = state
            switch.visibility = View.GONE
            name.setCompoundDrawablesWithIntrinsicBounds(0,0,R.drawable.ic_baseline_keyboard_arrow_down_24,0)
        }

        but.setOnClickListener {
            bundle.putString("whoAreYou",name.text.toString())
            view.findNavController().navigate(R.id.action_whoAreYouFragment2_to_authFragment22)
        }

    }


}