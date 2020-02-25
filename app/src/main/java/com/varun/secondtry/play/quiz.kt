package com.varun.secondtry.play


import android.animation.ObjectAnimator
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.Navigation
import com.google.firebase.database.*
import com.varun.secondtry.R
import com.varun.secondtry.data_model.model
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import com.xwray.groupie.Item
import kotlinx.android.synthetic.main.button.view.*
import kotlinx.android.synthetic.main.fragment_quiz.*
import kotlinx.android.synthetic.main.token.*
import kotlinx.android.synthetic.main.token.view.*

/**
 * A simple [Fragment] subclass.
 */
class quiz : Fragment() {
    var id:String ?=null

    var ref : DatabaseReference ?=null

    val adapter =  GroupAdapter<GroupieViewHolder>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        arguments?.let {

            val args = quizArgs.fromBundle(it)
            id = args.rmid
        }

        recyclerview.adapter = adapter




        ref= FirebaseDatabase.getInstance().getReference("/$id")
        ref!!.addListenerForSingleValueEvent(object: ValueEventListener{
            override fun onCancelled(p0: DatabaseError) {

            }

            override fun onDataChange(p0: DataSnapshot) {
              for(child in p0.children){




                var q :String = child.child("quesdec").getValue().toString()
                  var o1 :String = child.child("op1").getValue().toString()
                  var vo1 :String = child.child("vop1").getValue().toString()

                  var o2 :String = child.child("op2").getValue().toString()
                  var vo2 :String = child.child("vop2").getValue().toString()

                  var o3 :String = child.child("op3").getValue().toString()
                  var vo3 :String = child.child("vop3").getValue().toString()

                  var o4 :String = child.child("op4").getValue().toString()
                  var vo4 :String = child.child("vop4").getValue().toString()

                  var no :Int = child.child("quesno").getValue().toString().toInt()
                    adapter.add(question(q,o1,vo1.toInt(),o2,vo2.toInt(),o3,vo3.toInt(),o4,vo4.toInt(),no,id!!))
              }
                adapter.add(button(view))


            }





        })



    }






    inner class question(var question:String,var op1:String,var vo1:Int, var op2:String, var vo2:Int, var op3:String,var vo3:Int, var op4:String,var vo4:Int, var no:Int, var id:String):Item<GroupieViewHolder>(){



        override fun getLayout(): Int {
            return R.layout.token
        }

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {



            if(op3==""){
                viewHolder.itemView.rd3.setVisibility(View.INVISIBLE)

            }

            if(op4==""){
                viewHolder.itemView.rd4.setVisibility(View.INVISIBLE)

            }

            viewHolder.itemView.pb1.setVisibility(View.INVISIBLE)
            viewHolder.itemView.pb2.setVisibility(View.INVISIBLE)
            viewHolder.itemView.pb3.setVisibility(View.INVISIBLE)
            viewHolder.itemView.pb4.setVisibility(View.INVISIBLE)


            fun disable(){
                viewHolder.itemView.rd1.isEnabled = false
                viewHolder.itemView.rd2.isEnabled = false
                viewHolder.itemView.rd3.isEnabled = false
                viewHolder.itemView.rd4.isEnabled = false


                viewHolder.itemView.pb1.setVisibility(View.VISIBLE)
                viewHolder.itemView.pb2.setVisibility(View.VISIBLE)

                if(op3==""){
                    viewHolder.itemView.pb3.setVisibility(View.INVISIBLE)

                }else{
                    viewHolder.itemView.pb3.setVisibility(View.VISIBLE)
                }

                if(op4==""){
                    viewHolder.itemView.rd4.setVisibility(View.INVISIBLE)

                }else {

                    viewHolder.itemView.pb4.setVisibility(View.VISIBLE)
                }

            }

            fun cal(){

                var per:Float= (vo1.toFloat()/(vo1.toFloat()+vo2.toFloat()+vo3.toFloat()+vo4.toFloat()))*1000
                var q = (per/10).toInt().toString()



                viewHolder.itemView.rd1.text = ("$q %" ).toString()

                var per2:Float= (vo2.toFloat()/(vo1.toFloat()+vo2.toFloat()+vo3.toFloat()+vo4.toFloat()))*1000
                var p = (per2/10).toInt().toString()
                viewHolder.itemView.rd2.text = ("$p %").toString()

                var per3:Float= (vo3.toFloat()/(vo1.toFloat()+vo2.toFloat()+vo3.toFloat()+vo4.toFloat()))*1000
                var r = (per3/10).toInt().toString()
                viewHolder.itemView.rd3.text = ("$r %").toString()

                var per4:Float= (vo4.toFloat()/(vo1.toFloat()+vo2.toFloat()+vo3.toFloat()+vo4.toFloat()))*1000
                var s = (per4/10).toInt().toString()
                viewHolder.itemView.rd4.text = ("$s %").toString()



//
//                viewHolder.itemView.pb1.setProgress(per.toInt())
//                viewHolder.itemView.pb2.setProgress(per2.toInt())
//                viewHolder.itemView.pb3.setProgress(per3.toInt())
//                viewHolder.itemView.pb4.setProgress(per4.toInt())



                ObjectAnimator.ofInt(viewHolder.itemView.pb1, "progress", per.toInt()).start()
                ObjectAnimator.ofInt(viewHolder.itemView.pb2, "progress", per2.toInt()).start()
                ObjectAnimator.ofInt(viewHolder.itemView.pb3, "progress", per3.toInt()).start()
                ObjectAnimator.ofInt(viewHolder.itemView.pb4, "progress", per4.toInt()).start()

            }


            var reff =FirebaseDatabase.getInstance().getReference("/$id/$no")
            viewHolder.itemView.question.setText(question)
            viewHolder.itemView.rd1.setText(op1)
            viewHolder.itemView.rd2.setText(op2)
            viewHolder.itemView.rd3.setText(op3)
            viewHolder.itemView.rd4.setText(op4)



//            viewHolder.itemView.pb1.max = vo1+vo2+vo3+vo4+1
//            viewHolder.itemView.pb2.max = vo1+vo2+vo3+vo4+1
//            viewHolder.itemView.pb3.max = vo1+vo2+vo3+vo4+1
//            viewHolder.itemView.pb4.max = vo1+vo2+vo3+vo4+1






            var a:Int =0




            viewHolder.itemView.rd1.setOnClickListener{
                Toast.makeText(activity,"you choose 1",Toast.LENGTH_LONG).show()
                a=1
                vo1 += 1
                reff.child("vop1").setValue("$vo1")
                 disable()
                cal()




            }

            viewHolder.itemView.rd2.setOnClickListener{
                Toast.makeText(activity,"you choose 2",Toast.LENGTH_LONG).show()
                a=2
                vo2 += 1
                reff.child("vop2").setValue("$vo2")
                disable()
                cal()











            }

            viewHolder.itemView.rd3.setOnClickListener{
                Toast.makeText(activity,"you choose 3",Toast.LENGTH_LONG).show()
                a=3
                vo3 += 1
                reff.child("vop3").setValue("$vo3")
                disable()

                cal()


            }

            viewHolder.itemView.rd4.setOnClickListener{
                Toast.makeText(activity,"you choose 4",Toast.LENGTH_LONG).show()
                a=4
                vo4 += 1
                reff.child("vop4").setValue("$vo4")
                it.isEnabled = false
                disable()

               cal()






            }



           /* viewHolder.itemView.up.setOnClickListener{
                up.visibility = View.VISIBLE
                when(a){
                    1-> {
                        vo1 += 1
                        reff.child("vop1").setValue("$vo1")
                        up.visibility= View.GONE
                    }

                    2->{
                        vo2 += 1
                        reff.child("vop2").setValue("$vo2")
                        up.visibility= View.INVISIBLE

                    }
                    3->{
                        vo3 += 1

                        reff.child("vop3").setValue("$vo3")
                        up.visibility= View.INVISIBLE
                    }
                    4->{
                        vo4 += 1
                        reff.child("vop4").setValue("$vo4")
                        up.visibility= View.INVISIBLE
                    }

                }


            }*/




        }




    }

    inner class button(ew:View):Item<GroupieViewHolder>(){
        val v = ew
        override fun getLayout(): Int {
            return R.layout.button
        }

        override fun bind(viewHolder: GroupieViewHolder, position: Int) {
            viewHolder.itemView.button5.setOnClickListener{


                Navigation.findNavController(v).navigate(R.id.action_quiz_to_endPolling)


            }
        }


    }

}
