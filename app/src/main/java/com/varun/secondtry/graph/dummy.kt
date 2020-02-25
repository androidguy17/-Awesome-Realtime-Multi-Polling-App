package com.varun.secondtry.graph

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.varun.secondtry.R
import kotlinx.android.synthetic.main.activity_dummy.*

class dummy : AppCompatActivity() {

    var id:String ?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dummy)

        button6.setOnClickListener{
           id =  result_id.text.toString()

            val intent = Intent(this, graph::class.java)
            intent.putExtra("ID",id)
            startActivity(intent)

        }

    }


}
