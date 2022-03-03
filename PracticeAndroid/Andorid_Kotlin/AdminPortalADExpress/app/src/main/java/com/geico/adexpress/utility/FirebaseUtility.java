package com.geico.adexpress.utility;

import android.util.Log;

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import static com.geico.adexpress.utility.FirebaseContract.Modules.USER_PROFILE;

public class FirebaseUtility {

    private static FirebaseDatabase database = FirebaseDatabase.getInstance();
    private static DatabaseReference mDatabase = database.getReference();

    public static void getFirebaseUserProfileData(String name, final IFirebaseSnapshotHandler receiver) {

        Query query = mDatabase.child(name).child(USER_PROFILE);
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }

    public static void getFirebaseFormsMainData(final IFirebaseSnapshotHandler receiver) {
        Query query = mDatabase.child("Forms");
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }

    public static void getFirebaseUserFormData(String child, final IFirebaseSnapshotHandler receiver) {
        Query query = mDatabase.child("Forms").child(child).child("Form Details");
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }

    public static void getFirebaseUserFormDataIterate(String child, final IFirebaseSnapshotHandler receiver) {

        Query query = mDatabase.child("Forms").child(child);
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }

    public static void getFirebaseNotifyData(final IFirebaseSnapshotHandler receiver) {
        Query query = mDatabase.child("onDemandNotification");
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }

    public static void getFirebaseUserNotifyData(String child, final IFirebaseSnapshotHandler receiver) {

        Query query = mDatabase.child("onDemandNotification").child(child).child("OnDemandNotification Details");
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }

    public static void getFirebaseUserNotifyData1(String child, final IFirebaseSnapshotHandler receiver) {

        Query query = mDatabase.child("onDemandNotification").child(child);
        query.keepSynced(true);
        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                receiver.onResultReceived(snapshot);
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                receiver.onErrorReceived(databaseError);
            }
        });
    }


}