package com.varun.secondtry.Creation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.varun.secondtry.R
import kotlinx.android.synthetic.main.fragment_final_screen.*

/**
 * A simple [Fragment] subclass.
 */
class FinalScreen : Fragment() {
        var id:String ?=null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

            arguments?.let{

                var args  = addQuestionsArgs.fromBundle(it)
                id = args.rmid
            }


        return inflater.inflate(R.layout.fragment_final_screen, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        code.setText(id.toString())



    }


}
