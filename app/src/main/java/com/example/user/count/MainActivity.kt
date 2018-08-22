package com.example.user.count

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val pref=getSharedPreferences("cou", Context.MODE_PRIVATE)
        var count=pref.getInt("COUNT",0)

        textView.text=count.toString()

        var tasu:Int=intent.getIntExtra("NN",2)
        when(tasu){
            2->plusPlus.setText("+2")
            3->plusPlus.setText("+3")
            4->plusPlus.setText("+4")
            5->plusPlus.setText("+5")
            6->plusPlus.setText("+6")
            7->plusPlus.setText("+7")
            8->plusPlus.setText("+8")
            9->plusPlus.setText("+9")
            10->plusPlus.setText("+10")
        }

        plus.setOnClickListener {
            count++
            textView.text=count.toString()
            pref.edit().putInt("COUNT",count).apply()
        }
        plusPlus.setOnClickListener {
            count+=tasu
            textView.text=count.toString()
            pref.edit().putInt("COUNT",count).apply()
        }
        reset.setOnClickListener {
            count=0
            textView.text=count.toString()
            pref.edit().putInt("COUNT",count).apply()
        }

        setButton.setOnClickListener { change() }
    }

    fun change(){
        val intent=Intent(this,setting::class.java)
        startActivity(intent)
    }
}
