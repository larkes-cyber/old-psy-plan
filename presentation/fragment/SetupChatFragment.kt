package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.navigation.findNavController
import lolka.example.PsyPath.R


class SetupChatFragment : Fragment(), SomePersonInChatFragment.CallBack {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_setup_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val back:ImageView = view.findViewById(R.id.back)

        back.setOnClickListener {
            view.findNavController().navigate(R.id.action_setupChatFragment_to_mainFragment)
        }

        for(i in 0..10){
            val mFragmentManager = fragmentManager
            val mFragmentTransaction = mFragmentManager?.beginTransaction()
            val fragment = SomePersonInChatFragment()
            fragment.registerCallBack(this)
            mFragmentTransaction?.add(R.id.container, fragment)
            mFragmentTransaction?.commit()

        }

    }

    override fun getFocusedPerson(person: LinearLayout) {

        view?.findNavController()?.navigate(R.id.action_setupChatFragment_to_chatFragment)
        Log.d("check","sfdgsdfgd")

    }

}