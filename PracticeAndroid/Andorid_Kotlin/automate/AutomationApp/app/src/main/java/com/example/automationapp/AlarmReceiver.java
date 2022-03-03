package com.example.automationapp;

import android.app.Application;
import android.app.PendingIntent;
import android.app.admin.DevicePolicyManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.AudioManager;
import android.net.wifi.WifiManager;
import android.telephony.TelephonyManager;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.lang.reflect.Method;
import java.util.Objects;

import static android.app.Application.*;
import static android.content.Context.DEVICE_POLICY_SERVICE;
import static android.content.Context.WIFI_SERVICE;

public class AlarmReceiver extends BroadcastReceiver implements AudioManager.OnAudioFocusChangeListener {
    DevicePolicyManager deviceManger;
    ComponentName compName;
    WifiManager wifiManager;
    Context context;
    public static final String MyPREFERENCES = "MyPrefs";
    SharedPreferences sharedpreferences;
    SharedPreferences.Editor editor;

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        deviceManger = (DevicePolicyManager) context.getSystemService(DEVICE_POLICY_SERVICE);
        compName = new ComponentName(context, DeviceAdmin.class);
        wifiManager = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);
        sharedpreferences = context.getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        editor = sharedpreferences.edit();
        boolean active = deviceManger.isAdminActive(compName);
        Intent i = new Intent(context, MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, i, 0);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context, "automate")
                .setSmallIcon(R.drawable.sm)
                .setContentTitle("Automate")
                .setContentText("Automate will turn off your mobile screen")
                .setAutoCancel(true)
                .setDefaults(NotificationCompat.DEFAULT_ALL)
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setContentIntent(pendingIntent);
        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(context);
        notificationManagerCompat.notify(123, builder.build());
        wifisetting();
//        boolean t = getMobileDataState();
//        Log.d("TAG", "onReceive: " + t);
//        if (t) {
//          //  setMobileDataState(t);
//            Log.d("TAG2", "onReceive: " + t);
//        }
        //       backToHome();
        stopMusic();

        editor.putString("Time", null);
        editor.commit();

        deviceManger.lockNow();
    }

    private void backToHome() {
        // context.getApplicationContext().moveTaskToback(true);
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.getApplicationContext().startActivity(startMain);
    }

    private void wifisetting() {
        boolean isWifiEnabled = wifiManager.isWifiEnabled();
        if (isWifiEnabled) {
            wifiManager.setWifiEnabled(false);
        }
    }

    private void stopMusic() {
        AudioManager am = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        boolean t = am.isMusicActive();
        Log.d("TAG", "onCreate: ");
        am.requestAudioFocus(this, AudioManager.STREAM_MUSIC,
                AudioManager.AUDIOFOCUS_GAIN);
    }

    @Override
    public void onAudioFocusChange(int focusChange) {
        switch (focusChange) {
            case AudioManager.AUDIOFOCUS_GAIN:
                Log.d("TAG", "onAudioFocusChange: " + "AUDIOFOCUS_GAIN");
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                // resumePlayer(); // Resume your media player here
                Log.d("TAG", "onAudioFocusChange: " + "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                break;
            case AudioManager.AUDIOFOCUS_LOSS:
                Log.d("TAG", "onAudioFocusChange: " + "AUDIOFOCUS_LOSS");
                break;
            case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                //  pausePlayer();// Pause your media player here
                Log.d("TAG", "onAudioFocusChange: " + "AUDIOFOCUS_LOSS_TRANSIENT");
                break;
        }
    }

    public void setMobileDataState(boolean mobileDataEnabled) {
        try {
            TelephonyManager telephonyService = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            Method setMobileDataEnabledMethod = Objects.requireNonNull(telephonyService).getClass().getDeclaredMethod("setDataEnabled", boolean.class);
            setMobileDataEnabledMethod.invoke(telephonyService, mobileDataEnabled);
            Log.d("TAG3", "onReceive: " + "inside the setmobileDataState" + mobileDataEnabled);
        } catch (Exception ex) {
            Log.e("MainActivity2", "Error setting mobile data state", ex);
        }
    }

    public boolean getMobileDataState() {
        try {
            TelephonyManager telephonyService = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            Method getMobileDataEnabledMethod = Objects.requireNonNull(telephonyService).getClass().getDeclaredMethod("getDataEnabled");
            return (boolean) (Boolean) getMobileDataEnabledMethod.invoke(telephonyService);
        } catch (Exception ex) {
            Log.e("MainActivity2", "Error getting mobile data state", ex);
        }
        return false;
    }
}
