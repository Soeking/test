package com.example.user.count

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_setting.*

class setting : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        val pref=getSharedPreferences("set",Context.MODE_PRIVATE)
        var setnum=pref.getInt("SET",0)
        var decit=setnum+2

        seekBar.progress=setnum
        plusnum.text=decit.toString()

        seekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekbar: SeekBar?, progress: Int, fromUser: Boolean) {
                setnum=progress
                decit=setnum+2
                plusnum.text=decit.toString()
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {
            }

            override fun onStopTrackingTouch(p0: SeekBar?) {
            }
        })

        backButton.setOnClickListener {
            val intent=Intent(this,MainActivity::class.java)
            intent.putExtra("NN",decit)
            pref.edit().putInt("SET",setnum).apply()
            startActivity(intent)
        }
    }
}
