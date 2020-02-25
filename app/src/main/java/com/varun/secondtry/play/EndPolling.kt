package com.varun.secondtry.play


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation

import com.varun.secondtry.R
import com.varun.secondtry.graph.dummy
import kotlinx.android.synthetic.main.fragment_end_polling.*

/**
 * A simple [Fragment] subclass.
 */
class EndPolling : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_end_polling, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bu.setOnClickListener{
            Navigation.findNavController(view).navigate(R.id.action_endPolling_to_loading)


        }

    }


}
