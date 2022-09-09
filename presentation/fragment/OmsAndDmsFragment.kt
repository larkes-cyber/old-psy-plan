package lolka.example.PsyPath.presentation.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.navigation.findNavController
import lolka.example.PsyPath.R


class OmsAndDmsFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_oms_and_dms, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val bundle = Bundle()

        val but: AppCompatButton = view.findViewById(R.id.button)
        val dms:EditText = view.findViewById(R.id.dms)
        val oms:EditText = view.findViewById(R.id.oms)
        val error:TextView = view.findViewById(R.id.error)
//
//        var k = 0
//        var save:String = "ddrdfgdrfhsatEARHGAEWOTSERKTRS[DAEG"
//
//        oms.addTextChangedListener(object : TextWatcher {
//            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//            }
//            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
//                val almostTime = p0.toString()
//                if(almostTime != save){
//                    for(i in 0..almostTime.length-1){
//                        if((i == 3 && k == 0) || (i == 8 && k==1) || (i == 13 && k == 2) || (i == 18 && k == 3)){
//                            save = "${almostTime}-"
//                            oms.setText("${almostTime}-")
//                            oms.setSelection(oms.length())
//                            k++
//                        }
//                        if(k == 3){
//                            save = "${almostTime}-"
//                            oms.setText("${almostTime}-")
//                        }
//                    }
//                }
//
//                if(almostTime.length == 4 && ":" !in almostTime){
//                    oms.setText("${almostTime[0]}${almostTime[1]}:${almostTime[2]}")
//                    oms.setSelection(oms.length())
//                }
//            }
//            override fun afterTextChanged(p0: Editable?) {
//            }
//        })

        but.setOnClickListener {

            var k = 0
            oms.text.toString().forEach {
                if("-" == it.toString()){
                    k++
                }
            }

            var c = 0

            dms.text.toString().forEach {
                if("-" == it.toString()){
                    c++
                }
            }

            if(k != 3 || c != 3){
                error.visibility = View.VISIBLE
            }else{
                error.visibility = View.GONE
                bundle.putString("name",arguments?.getString("name").toString())
                bundle.putString("whoAreYou",arguments?.getString("whoAreYou").toString())
                bundle.putString("dms",dms.text.toString())
                bundle.putString("oms",oms.text.toString())
                view.findNavController().navigate(R.id.action_omsAndDmsFragment_to_authFragment32,bundle)
            }


        }

    }
}