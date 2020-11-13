package com.idea.hmspushkit.view

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import com.idea.hmspushkit.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val receiver = Receiver()
        val intentFilter = IntentFilter()
        intentFilter.addAction("com.huawei.codelabpush.ON_NEW_TOKEN")
        registerReceiver(receiver, intentFilter)
    }

    class Receiver : BroadcastReceiver(){
        override fun onReceive(context: Context?, intent: Intent?) {
            if(intent?.action.equals("com.huawei.codelabpush.ON_NEW_TOKEN")){
                val token : String = intent?.getStringExtra("token").toString()
                Log.i("BroadcastLog", token)
            }
        }
    }
}