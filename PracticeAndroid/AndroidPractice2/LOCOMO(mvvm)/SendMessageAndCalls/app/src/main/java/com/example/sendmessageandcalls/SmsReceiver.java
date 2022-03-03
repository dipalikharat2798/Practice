package com.example.sendmessageandcalls;

import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

public class SmsReceiver extends BroadcastReceiver {

    private static String TAG = "Receiver";
    public SmsReceiver(){}
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle=intent.getExtras();
        try {
            if (bundle!=null){
                Object[] smsObj=(Object[]) bundle.get("pdus");

                if (smsObj != null){
                    for (Object sms1 : smsObj){
                        SmsMessage currentMessage= getIncomingMessage(sms1,bundle);
                        String senderNum=currentMessage.getDisplayOriginatingAddress();
                        String message = currentMessage.getDisplayMessageBody();

                        Log.d(TAG, "onReceive: "+senderNum+message);

                        Intent directIntent = new Intent(context,sender.class);
                        directIntent.putExtra(sender.EXTRA_SMS_Number,senderNum);
                        directIntent.putExtra(sender.EXTRA_SMS_Message,message);
                        Toast.makeText(context, ""+senderNum+message, Toast.LENGTH_SHORT).show();

                        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,directIntent,PendingIntent.FLAG_UPDATE_CURRENT);
                        pendingIntent.send();
                    }
                }else {
                    Log.d(TAG, "onReceive: SMS is Null");
                }
            }
        }catch (Exception e){
            Log.d(TAG , "onReceive: "+e);
        }
    }
    private SmsMessage getIncomingMessage(Object object,Bundle bundle){
        SmsMessage currentSMS;
        if (Build.VERSION.SDK_INT>=23){
            String format = bundle.getString("format");
            currentSMS=SmsMessage.createFromPdu((byte[]) object,format);
        }else {
            currentSMS=SmsMessage.createFromPdu((byte[]) object);
        }
        return currentSMS;
    }
}
