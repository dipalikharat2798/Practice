package com.example.newlocation;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnShowAddress;
    TextView tvAddress;
    Location location;
    AppLocationService appLocationService;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAddress = findViewById(R.id.tvAddress);
        appLocationService = new
                AppLocationService(MainActivity.this);
        btnShowAddress = findViewById(R.id.btnShowAddress);
        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                location = appLocationService.getLocation(LocationManager.GPS_PROVIDER);
                double latitude = 13.1000727;
                double longitude = 80.2126274;
                LocationAddress locationAddress = new LocationAddress();
                locationAddress.getAddressFromLocation(latitude, longitude,
                        getApplicationContext(), new GeoCodeHandler());
                showSettingsAlert();
            }
            public void showSettingsAlert() {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setTitle("SETTINGS");
                alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
                alertDialog.setPositiveButton("Settings", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        MainActivity.this.startActivity(intent);
                    }
                });
                alertDialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                alertDialog.show();
            }
            class GeoCodeHandler extends Handler {
                @Override
                public void handleMessage(Message message) {
                    String locationAddress;
                    switch (message.what) {
                        case 1:
                            Bundle bundle = message.getData();
                            locationAddress = bundle.getString("address");
                            break;
                        default:
                            locationAddress = null;
                    }
                    tvAddress.setText(locationAddress);
                }
            }
        });
    }
}