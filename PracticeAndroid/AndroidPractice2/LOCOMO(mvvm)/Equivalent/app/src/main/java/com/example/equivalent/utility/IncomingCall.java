package com.example.equivalent.utility;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.Gravity;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class IncomingCall extends BroadcastReceiver {
    public static String TAG = "Incoming calls";

    @Override
    public void onReceive(Context context, Intent intent) {

        if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK)) {
            showToast(context, "Call started...");
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE)) {
            showToast(context, "Call ended...");
        } else if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
            sendDataToUser(incomingNumber);
            showToast(context, "Incoming call...");
        }
    }

    private void sendDataToUser(String incomingNumber) {
        Map<String, Object> user = new HashMap<>();
        user.put("senderNum", incomingNumber);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("userscalls")
                .add(user)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "DocumentSnapshot added with ID: " + documentReference.getId());
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.w(TAG, "Error adding document", e);
                    }
                });
    }

    void showToast(Context context, String message) {
        Toast toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
//        try {
//            String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
//            String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
//
//            if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){
//
//                Toast.makeText(context,"Ringing State Number is - " + incomingNumber, Toast.LENGTH_SHORT).show();
//                Log.d(TAG, "onReceive: "+incomingNumber);
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }

//    }
//
//    public void showText(Context c, String msg) {
//        Toast toast = Toast.makeText(c, msg, Toast.LENGTH_LONG);
//        toast.setGravity(Gravity.CENTER, 0, 0);
//        toast.show();
//    }

//    private class MyPhoneStateListener extends PhoneStateListener{
//        public void onCallStateChanged(int state,String incomingNumber){
//            Log.d(TAG, "MyPhoneStateListener "+state+" incoming number"+incomingNumber);
//
//            if (state==1){
//                String msg = "New Phone Call Event. IncomingNumber"+incomingNumber;
//                int duration = Toast.LENGTH_LONG;
//                Toast toast=Toast.makeText(c1,msg,duration);
//                toast.show();
//            }
//        }
//    }
}
