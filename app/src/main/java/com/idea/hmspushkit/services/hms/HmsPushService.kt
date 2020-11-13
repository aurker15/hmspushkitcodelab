package com.idea.hmspushkit.services.hms

import android.content.Intent
import android.util.Log
import com.huawei.hms.push.HmsMessageService

class HmsPushService : HmsMessageService() {

    override fun onNewToken(token: String?) {
        super.onNewToken(token)
        Log.i("PushLog", token)
        sendToken(token)
    }

    private fun sendToken(token: String?){
        sendBroadcast(Intent("com.huawei.push.codelab.ON_NEW_TOKEN")
            .putExtra("token", token))
    }

}