package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.os.CountDownTimer
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import lolka.example.PsyPath.R
import lolka.example.PsyPath.databinding.FragmentChatBinding
import lolka.example.PsyPath.presentation.fragment.adapter.MessageAdapter
import lolka.example.PsyPath.presentation.fragment.adapter.MessageModel


class ChatFragment : Fragment() {

    lateinit var container:RecyclerView
    private val adapter = MessageAdapter()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val back: ImageView = view.findViewById(R.id.back)
        val mess:TextView = view.findViewById(R.id.mess)
        val send:ImageView = view.findViewById(R.id.send)

        var count = 0

          container = view.findViewById(R.id.rc_view)
          var mLayout = LinearLayoutManager(this@ChatFragment.context)
          container.layoutManager = mLayout
          container.adapter = adapter
          send.setOnClickListener {
              if(count == 4){
                  adapter.addMessage(MessageModel(
                      whose = 1,
                      message = "Привет"
                  ))
              }
            adapter.addMessage(
                MessageModel(
                whose = 0,
                message = mess.text.toString()
            )
            )
              mess.setText("")
              count++
          }

        back.setOnClickListener {

            view.findNavController().navigate(R.id.action_chatFragment_to_setupChatFragment)

        }
//
//        var count = 0
//

//
//
//
//        val timer = object: CountDownTimer(5000, 1000) {
//            override fun onTick(millisUntilFinished: Long) {
//
//            }
//
//            override fun onFinish() {
//
//            }
//        }
//        timer.start()
//


    }

}