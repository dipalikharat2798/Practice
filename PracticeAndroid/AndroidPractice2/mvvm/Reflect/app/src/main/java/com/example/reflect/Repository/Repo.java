package com.example.reflect.Repository;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.reflect.DataLoadListener;
import com.example.reflect.Model.NotesModel;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class Repo{
        static  Repo instance;
        private ArrayList<NotesModel> notesModels = new ArrayList<>();
        static Context mContext;
        static DataLoadListener dataLoadListener;
        public  static  Repo getInstance(Context context){
            mContext = context;
            if(instance == null){
                instance=new Repo();
            }
            dataLoadListener =(DataLoadListener) mContext;
            return  instance;
        }
        public MutableLiveData<ArrayList<NotesModel>> getNotes(){
            loadNotes();
            MutableLiveData<ArrayList<NotesModel>> name = new MutableLiveData<>();
            name.setValue(notesModels);
            return name;
        }

        private  void  loadNotes(){
//            DatabaseReference reference= FirebaseDatabase.getInstance().getReference();
//            Query query=reference.child("Data");
//            query.addListenerForSingleValueEvent(new ValueEventListener() {
//                @Override
//                public void onDataChange(@NonNull DataSnapshot snapshot) {
//                    for(DataSnapshot snapshot1 : snapshot.getChildren()){
//                        notesModels.add(snapshot1.getValue(notesModels.class));
//                    }
//                    dataLoadListener.OnNameLoaded();
//                }
//
//                @Override
//                public void onCancelled(@NonNull DatabaseError error) {
//
//                }
//            });
            FirebaseUser firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
            FirebaseFirestore db= FirebaseFirestore.getInstance();
            db.collection("notes").document(firebaseUser.getUid()).collection("myNotes").get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                @Override
                public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                    List<DocumentSnapshot> list =queryDocumentSnapshots.getDocuments();
                    for(DocumentSnapshot d:list){
                        NotesModel obj=d.toObject(NotesModel.class);
                        obj.setId(d.getId());
                        notesModels.add(obj);
                    }
                   dataLoadListener.OnNotesLoaded();
                }
            });
        }
}
