package com.example.reflect;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.reflect.Adapter.NotesAdapter;
import com.example.reflect.Model.NotesModel;
import com.example.reflect.ViewModel.NotesViewModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class NotesActivity extends AppCompatActivity implements DataLoadListener {

    RecyclerView recyclerView;
    ArrayList<NotesModel> datalist;
    FirebaseFirestore db;
    NotesAdapter myadapter;
    FirebaseUser firebaseUser;
    FirebaseAuth auth;
   FloatingActionButton button;
   NotesViewModel notesViewModel;
   int year,day;
   String month;
    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notes);
        recyclerView=findViewById(R.id.recycler);
       // recyclerView.setLayoutManager(new LinearLayoutManager(this));

        auth=FirebaseAuth.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        datalist=new ArrayList<>();
        myadapter=new NotesAdapter(datalist,this);
        recyclerView.setAdapter(myadapter);
        button=findViewById(R.id.done_notes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesViewModel= new ViewModelProvider(this).get(NotesViewModel.class);
        notesViewModel.init(NotesActivity.this);
        myadapter=new NotesAdapter(notesViewModel.getNotes().getValue(),NotesActivity.this);
        recyclerView.setAdapter(myadapter);

//        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
//
//        Intent notificationIntent = new Intent(this, AlarmReceiver.class);
//        PendingIntent broadcast = PendingIntent.getBroadcast(this, 100, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
//
//        Calendar cal = Calendar.getInstance();
//        cal.add(Calendar.SECOND, 5);
//
//        alarmManager.setExact(AlarmManager.RTC_WAKEUP, cal.getTimeInMillis(), broadcast);

//        db=FirebaseFirestore.getInstance();
//        db.collection("notes").document(firebaseUser.getUid()).collection("myNotes").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
//            @Override
//            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
//                List<DocumentSnapshot> list =queryDocumentSnapshots.getDocuments();
//                for(DocumentSnapshot d:list){
//                    NotesModel obj=d.toObject(NotesModel.class);
//                    obj.setId(d.getId());
//                    datalist.add(obj);
//                }
//                myadapter.notifyDataSetChanged();
//            }
//        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(NotesActivity.this,UpdateActivity.class));
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.logout,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.logout:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Are you sure to logout?");
                builder.setMessage("logging out user...");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        auth.signOut();
                        Intent intent=new Intent(NotesActivity.this,LoginActivity.class);
                        startActivity(intent);
                    }
                });
                builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
                AlertDialog ad = builder.create();
                ad.show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void OnNotesLoaded() {
        notesViewModel.getNotes().observe(this, new Observer<ArrayList<NotesModel>>() {
            @Override
            public void onChanged(ArrayList<NotesModel> notesModels) {
                myadapter.notifyDataSetChanged();
            }
        });
    }
}