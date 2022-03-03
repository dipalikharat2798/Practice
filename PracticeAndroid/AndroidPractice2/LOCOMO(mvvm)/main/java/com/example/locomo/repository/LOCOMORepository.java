package com.example.locomo.repository;

import androidx.annotation.NonNull;

import com.example.locomo.model.LOCOMOModel;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.HashMap;
import java.util.List;

public class LOCOMORepository {
    private FirebaseFirestore firebaseFirestore;
    private String quizId;
    private HashMap<String , String> resultMap= new HashMap<>();
    private OnQuestionLoad onQuestionLoad;
    private OnResultAdded onResultAdded;
    private String currentUserId = "VAM 5166";
    private OnResultLoad onResultLoad;


    public void getResults(){
        firebaseFirestore.collection("LOCOMO").document(currentUserId)
                .get().addOnCompleteListener(new OnCompleteListener<DocumentSnapshot>() {
            @Override
            public void onComplete(@NonNull Task<DocumentSnapshot> task) {
                if (task.isSuccessful()){
                    resultMap.put("dayEndTime" , task.getResult().getString("dayEndTime"));
                    resultMap.put("dayStartTime" , task.getResult().getString("dayStartTime"));
                    onResultLoad.onResultLoad(resultMap);
                }else{
                    onResultLoad.onError(task.getException());
                }
            }
        });
    }
    public interface OnResultLoad{
        void onResultLoad(HashMap<String , String> resultMap);
        void onError(Exception e);
    }

    public interface OnQuestionLoad{
        void onLoad(List<LOCOMOModel> questionModels);
        void onError(Exception e);
    }
    public interface OnResultAdded{
        boolean onSubmit();
        void onError(Exception e);
    }
}

