package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import androidx.navigation.findNavController
import lolka.example.PsyPath.R
import java.text.SimpleDateFormat
import java.util.*


class MainFragment : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val health:RelativeLayout = view.findViewById(R.id.health)
        val chat:RelativeLayout = view.findViewById(R.id.chat)
        val plan:RelativeLayout = view.findViewById(R.id.plan)
        val happy:RelativeLayout = view.findViewById(R.id.happy)
        val profile:LinearLayout = view.findViewById(R.id.profile)
        val time:TextView = view.findViewById(R.id.time)

        val sdf = SimpleDateFormat("hh:mm")
        val currentDate = sdf.format(Date())
        time.text = currentDate

        profile.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_profileOfPatientFragment)
        }

        plan.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_meetingWithDoctorFragment)
        }

        happy.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_happyFragment)
        }

        chat.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_setupChatFragment)
        }

        health.setOnClickListener {
            view.findNavController().navigate(R.id.action_mainFragment_to_stateFragment)
        }

    }

}