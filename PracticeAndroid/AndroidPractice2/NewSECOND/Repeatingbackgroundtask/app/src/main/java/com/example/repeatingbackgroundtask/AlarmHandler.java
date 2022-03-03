package com.example.repeatingbackgroundtask;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

public class AlarmHandler {
    private Context context;

    public AlarmHandler(Context context) {
        this.context = context;
    }

    //this will activate alarm
    public void setAlarmManager(){
        Intent intent=new Intent(context,ExecutableService.class);
        PendingIntent sender = PendingIntent.getBroadcast(context,2,intent,0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if(am!=null){
            //the time is cal in millsec (1hr)
            long triggerAfter=1500;//this will trigger the service after
            long triggerEvery=1500;//this will repeate it every hour after
            am.setRepeating(AlarmManager.RTC_WAKEUP,triggerAfter,triggerEvery,sender);
        }
    }

   // this will cancel the alarm
    public void cancelAlarmManager(){
        Intent intent=new Intent(context,ExecutableService.class);
        PendingIntent sender = PendingIntent.getBroadcast(context,2,intent,0);
        AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if(am!=null){
            am.cancel(sender);
        }
    }
}
