package com.varun.secondtry.Creation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.google.firebase.database.FirebaseDatabase
import com.varun.secondtry.R
import kotlinx.android.synthetic.main.fragment_roomid.*
import kotlinx.android.synthetic.main.fragment_roomid.view.*

/**
 * A simple [Fragment] subclass.
 */
class roomid : Fragment() {


    var id:String ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_roomid, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        et_roomid.setText(getAlphaNumericString(5))
        id= et_roomid.text.toString()

        button4.setOnClickListener{
            uploaded(it)

        }

    }

    fun uploaded(view: View){

       var ref =  FirebaseDatabase.getInstance().getReference("/$id")
        ref.setValue(id)

        val action = roomidDirections.actionRoomidToAddQuestions(id.toString())
        Navigation.findNavController(view).navigate(action)




    }



    fun getAlphaNumericString(n: Int): String { // chose a Character random from this String
        val AlphaNumericString = ("ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz")
        // create StringBuffer size of AlphaNumericString
        val sb = StringBuilder(n)
        for (i in 0 until n) { // generate a random number between
// 0 to AlphaNumericString variable length
            val index = (AlphaNumericString.length
                    * Math.random()).toInt()
            // add Character one by one in end of sb
            sb.append(
                AlphaNumericString[index]
            )
        }
        return sb.toString()
    }

}
