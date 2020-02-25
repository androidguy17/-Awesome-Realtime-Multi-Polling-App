package com.varun.secondtry.Creation


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.google.firebase.database.FirebaseDatabase

import com.varun.secondtry.R
import com.varun.secondtry.data_model.model
import kotlinx.android.synthetic.main.fragment_add_questions.*

/**
 * A simple [Fragment] subclass.
 */
class addQuestions : Fragment() {

    var id:String?=null
    var qno:Int= 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        arguments?.let{

            val args = addQuestionsArgs.fromBundle(it)
            id= args.rmid

        }


        return inflater.inflate(R.layout.fragment_add_questions, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bu_submit.setOnClickListener{

            submit(it)

        }

        bu_addnew.setOnClickListener{
            addNew(view)
        }



    }

    fun addNew(view:View){


        var ques = etqp.text.toString()
        var quesop1 = etqp2.text.toString()
        var quesop2 = etqp3.text.toString()
        var quesop3 = etqp4.text.toString()
        var quesop4 = etqp5.text.toString()



        var data = model(
            qno.toString(),
            ques,
            quesop1,
            quesop2,
            quesop3,
            quesop4
        )

        val ref =FirebaseDatabase.getInstance().getReference("/$id")

        ref.child(qno.toString()).setValue(data).addOnSuccessListener {
            Toast.makeText(activity,"UPLoadsuccess",Toast.LENGTH_LONG).show()
        }



         etqp.setText("")
         etqp2.setText("")
        etqp3.setText("")
        etqp4.setText("")
         etqp5.setText("")


        qno += 1

    }


    fun submit(view:View){

        var ques = etqp.text.toString()
        var quesop1 = etqp2.text.toString()
        var quesop2 = etqp3.text.toString()
        var quesop3 = etqp4.text.toString()
        var quesop4 = etqp5.text.toString()




        var data = model(
            qno.toString(),
            ques,
            quesop1,
            quesop2,
            quesop3,
            quesop4
        )

        val ref =FirebaseDatabase.getInstance().getReference("/$id")

        ref.child(qno.toString()).setValue(data).addOnSuccessListener {

        }

        val action = addQuestionsDirections.actionAddQuestionsToFinalScreen(id.toString())
        Navigation.findNavController(view).navigate(action)

    }


}
