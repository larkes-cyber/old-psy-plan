package lolka.example.PsyPath.presentation.fragment


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import lolka.example.PsyPath.R
import lolka.example.PsyPath.domain.model.Score



class HappyFragment : Fragment() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_happy, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val back: ImageView = view.findViewById(R.id.back)






        back.setOnClickListener {
            view.findNavController().navigate(R.id.action_happyFragment_to_mainFragment)
        }

    }


}