package com.example.introductiontofragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.RadioGroup
import androidx.fragment.app.FragmentTransaction
import androidx.navigation.findNavController

lateinit var actA: AppCompatActivity
lateinit var f1Listener: Fragment1.OnSelectButtonListener

class Fragment1 : Fragment() {

    private val TAG_F11 = "Fragment11"
    private val TAG_F12 = "Fragment12"
    var frag11: Fragment? = null
    var frag12: Fragment? = null
    lateinit var myTransaction: FragmentTransaction

    private var param1: String? = null
    private var param2: String? = null

    interface OnSelectButtonListener {
        fun onSelect(optionId: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
//            param1 = it.getString(ARG_PARAM1)
//            param2 = it.getString(ARG_PARAM2)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val myView = inflater.inflate(R.layout.fragment_1, container, false)
        return myView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if(savedInstanceState == null) {
            frag11 = Fragment11()
            frag12 = Fragment12()

            myTransaction = childFragmentManager.beginTransaction()
            myTransaction.add(R.id.frag_1_container, frag11!!, this.TAG_F11)
            myTransaction.detach(frag11!!)
            myTransaction.add(R.id.frag_1_container, frag12!!, this.TAG_F12)
            myTransaction.detach(frag12!!)
            myTransaction.commit()
        } else {
            frag11 = childFragmentManager.findFragmentByTag(this.TAG_F11)
            frag12 = childFragmentManager.findFragmentByTag(this.TAG_F12)
        }

        val button1: Button = view.findViewById(R.id.but_to_tab_1)
        button1.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fragment1_to_tabsActivity)
        }

        val button2: Button = view.findViewById(R.id.but_to_tab_2)
        button2.setOnClickListener { view ->
            view.findNavController().navigate(R.id.action_fragment1_to_tabsActivity2)
        }

    }

//    override fun onAttach(context: Context) {
//        super.onAttach(context)
//        try{
//            actA = context as MainActivity
//            listF1 = context as OnSelectListener
//        } catch (e: ClassCastException) {
//            throw ClassCastException("OnClickListener must be implemented")
//        }
//    }

    companion object {

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Fragment1().apply {
                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                    putString(ARG_PARAM2, param2)
                }
            }
    }
}