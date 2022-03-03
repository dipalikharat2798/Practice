package com.geico.adexpress.utility;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;

public interface IFirebaseSnapshotHandler {
    void onResultReceived(DataSnapshot snapshot);

    void onErrorReceived(DatabaseError databaseError);
}
