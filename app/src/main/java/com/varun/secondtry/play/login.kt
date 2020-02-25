package com.varun.secondtry.play


import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.database.*
import com.varun.secondtry.R
import com.varun.secondtry.data_model.model
import kotlinx.android.synthetic.main.fragment_login.*
import java.lang.Exception

/**
 * A simple [Fragment] subclass.
 */
class login : Fragment() {
    var ref :DatabaseReference ?=null
    var id :String ?=null
    var a:model?=null
    var survey:model ?=null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

       ref = FirebaseDatabase.getInstance().getReference()
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        button.setOnClickListener{
           Next(it)

        }

    }

    fun Next(view:View){
    var v:model ?=null

        if (TextUtils.isEmpty(editText69.text.toString())){
        Toast.makeText(activity,"fill the ID",Toast.LENGTH_LONG).show()

        }
        else{

        id = editText69.text.toString()


        ref!!.addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
            if(p0.hasChild(id!!)){

                var action = loginDirections.actionLoginToQuiz(id.toString())
                Navigation.findNavController(view).navigate(action)



            }
                else{
                Toast.makeText(activity,"id not found in database",Toast.LENGTH_LONG).show()

            }


            }


        })




    }}


}
