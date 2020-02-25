package com.varun.secondtry


import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation


/**
 * A simple [Fragment] subclass.
 */
class loading : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment



        return inflater.inflate(R.layout.fragment_loading, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mainLooperHandler = Handler(Looper.getMainLooper())

        mainLooperHandler.postDelayed(
            Runnable { Navigation.findNavController(view).navigate(R.id.action_loading_to_choose) },
            2000
        )

    }




}
