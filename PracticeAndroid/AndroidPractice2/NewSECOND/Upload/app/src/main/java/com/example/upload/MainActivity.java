package com.example.upload;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

public class MainActivity extends AppCompatActivity {
Button selectfile,upload;
TextView notification;
FirebaseStorage storage;
FirebaseDatabase database;
Uri pdfUri;
ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        storage=FirebaseStorage.getInstance();
        database=FirebaseDatabase.getInstance();

        selectfile=findViewById(R.id.selectfile);
        upload=findViewById(R.id.upload);
        notification=findViewById(R.id.notification);

        selectfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)== PackageManager.PERMISSION_GRANTED){
                    selectPdf();
                }else{
                    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},9);
                }
            }
        });
        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(pdfUri!=null) {
                    uploadFile(pdfUri);
                }else {
                    Toast.makeText(MainActivity.this, "select file", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void uploadFile(Uri pdfUri) {
        progressDialog=new ProgressDialog(this);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progressDialog.setTitle("Upload File..");
        progressDialog.setProgress(0);
        progressDialog.show();

        StorageReference storageReference=storage.getReference();
        String filename = System.currentTimeMillis()+"";
        StorageReference reference=storageReference.child("Uploads").child(filename);
         reference.putFile(pdfUri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                 reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                     @Override
                     public void onSuccess(Uri uri) {
                         String url = uri.toString();
                         DatabaseReference databaseReference = database.getReference();
                         databaseReference.child(filename).setValue(url).addOnCompleteListener(new OnCompleteListener<Void>() {
                             @Override
                             public void onComplete(@NonNull Task<Void> task) {
                                 if (task.isSuccessful()){
                                     progressDialog.dismiss();
                                     Toast.makeText(MainActivity.this, "File Uploaded Successfully", Toast.LENGTH_SHORT).show();
                                 }else {
                                     progressDialog.dismiss();
                                     Toast.makeText(MainActivity.this, "Failed to upload your file", Toast.LENGTH_SHORT).show();
                                 }
                             }
                         });
                     }
                 });
             }
         }).addOnFailureListener(new OnFailureListener() {
             @Override
             public void onFailure(@NonNull Exception e) {
                 progressDialog.dismiss();
                 Toast.makeText(MainActivity.this, "Failed to upload your file", Toast.LENGTH_SHORT).show();
             }
         }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
             @Override
             public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
                 int currentProgress=(int)(100*snapshot.getBytesTransferred()/snapshot.getTotalByteCount());
                 progressDialog.setProgress(currentProgress);
             }
         });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 9 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            selectPdf();
        } else {
            Toast.makeText(this, "Please provide permission...", Toast.LENGTH_SHORT).show();
        }
    }

    private void selectPdf() {
        Intent intent=new Intent();
        intent.setType("application/pdf");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,86);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==86 && resultCode==RESULT_OK && data!=null){
            pdfUri=data.getData();
            notification.setText("A file is selected : "+data.getData().getLastPathSegment());
        }else {
            Toast.makeText(this, "Please select the file", Toast.LENGTH_SHORT).show();
        }
    }
}