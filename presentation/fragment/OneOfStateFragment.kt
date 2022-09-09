package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import lolka.example.PsyPath.R
import lolka.example.PsyPath.domain.model.Task


class OneOfStateFragment(val data:Task) : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_one_of_state, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

            val task:TextView = view.findViewById(R.id.task)
            val time:TextView = view.findViewById(R.id.time)

            task.text = data.text
            time.text = data.time

    }

}