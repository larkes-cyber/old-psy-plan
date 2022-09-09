package lolka.example.PsyPath.presentation.fragment

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.widget.AppCompatButton
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import lolka.example.PsyPath.App.App
import lolka.example.PsyPath.R
import lolka.example.PsyPath.domain.model.Task
import lolka.example.PsyPath.presentation.viewmodel.SignOrAuthViewModel
import lolka.example.PsyPath.presentation.viewmodel.SignOrAuthViewModelFactory
import lolka.example.PsyPath.presentation.viewmodel.StateViewModel
import lolka.example.PsyPath.presentation.viewmodel.StateViewModelFactory
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlinx.coroutines.launch
import javax.inject.Inject


class StateFragment : BaseFragment() {

    @Inject
    lateinit var vmFactory: StateViewModelFactory
    val wm by lazy {
        ViewModelProvider(this, vmFactory).get(StateViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_state, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        (getActivity()?.getApplicationContext() as App).appComponent.injectStateFragment(this)

        val but:FloatingActionButton = view.findViewById(R.id.floating_add_goal)
        val back:ImageView = view.findViewById(R.id.back)

        back.setOnClickListener {
            view.findNavController().navigate(R.id.action_stateFragment_to_mainFragment)
        }

        launch {
            wm.getTasks()
        }

        wm.lifeResultDatabaseConst.observe(viewLifecycleOwner){

            for(i in 0 until it.size){
                val mFragmentManager = fragmentManager
                val mFragmentTransaction = mFragmentManager?.beginTransaction()
                val fragment = OneOfStateFragment(Task(
                    time = it[i].time,
                    text = it[i].text
                ))
                mFragmentTransaction?.add(R.id.container, fragment)
                mFragmentTransaction?.commit()
            }

        }

        but.setOnClickListener {
            val messageBoxView = LayoutInflater.from(activity).inflate(R.layout.fragment_form_to_add_task, null)
            val messageBoxBuilder = AlertDialog.Builder(activity).setView(messageBoxView)

            val task:EditText = messageBoxView.findViewById(R.id.task)
            val time:EditText = messageBoxView.findViewById(R.id.time)
            val button:ImageView = messageBoxView.findViewById(R.id.button)

            val  messageBoxInstance = messageBoxBuilder.show()



            button.setOnClickListener {
                val mFragmentManager = fragmentManager
                val mFragmentTransaction = mFragmentManager?.beginTransaction()
                val fragment = OneOfStateFragment(Task(
                    time = time.text.toString(),
                    text = task.text.toString()
                ))
                mFragmentTransaction?.add(R.id.container, fragment)
                mFragmentTransaction?.commit()
                messageBoxInstance.dismiss()
                launch {

                    val sess = wm.getSession()

                    Toast.makeText(getActivity()?.getApplicationContext() as App,sess.session, Toast.LENGTH_LONG).show()

                    Log.d("sess",sess.session.toString())
                    Log.d("sess",sess.role.toString())

                    wm.insertTask(Task(
                        time = time.text.toString(),
                        text = task.text.toString()
                    ))
                }
            }

        }

    }

}