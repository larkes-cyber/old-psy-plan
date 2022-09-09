package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import lolka.example.PsyPath.R
import java.io.LineNumberReader


class SomePersonInChatFragment : Fragment() {

    lateinit var callBack: CallBack

    fun registerCallBack(callBack: CallBack){
        this.callBack = callBack
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_some_person_in_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val but:LinearLayout = view.findViewById(R.id.button)

        but.setOnClickListener {

            callBack.getFocusedPerson(person = but)

        }

    }

    interface CallBack {
         fun getFocusedPerson(person:LinearLayout)
    }

}