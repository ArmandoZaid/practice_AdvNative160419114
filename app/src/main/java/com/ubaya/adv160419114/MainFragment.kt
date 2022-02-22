package com.ubaya.adv160419114

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import kotlinx.android.synthetic.main.fragment_main.*
import kotlin.random.Random


/**
 * A simple [Fragment] subclass.
 * Use the [MainFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var resNum1 = textNum1.text.toString().toInt()
        var resNum2 = textNum2.text.toString().toInt()
        var score = 0
        val inputNum = editNumber.text.toString().toInt()


        buttonStart.setOnClickListener {

            val resultNum = resNum1 + resNum2

            if(resultNum == inputNum){
                score++
                resNum1 = Random.nextInt(100)
                resNum2 = Random.nextInt(100)
            } else {
                val act = MainFragmentDirections.actionMainFragmentToGameFragment(score)
                Navigation.findNavController(it).navigate(act)
            }
        }
    }
}