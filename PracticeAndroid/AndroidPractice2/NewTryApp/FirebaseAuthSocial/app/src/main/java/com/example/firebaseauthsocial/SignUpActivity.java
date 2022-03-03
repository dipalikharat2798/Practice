package com.example.firebaseauthsocial;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.textfield.TextInputEditText;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {
TextInputEditText username,pass,cpass;
TextView signup,signin;
String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
ProgressDialog progressDialog;
FirebaseAuth mAuth;
FirebaseUser mUSer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        signup=findViewById(R.id.signup);
        signin=findViewById(R.id.signin);
        username=(TextInputEditText)findViewById(R.id.username);
        pass=(TextInputEditText)findViewById(R.id.password);
        cpass=(TextInputEditText)findViewById(R.id.cpassword);
        progressDialog=new ProgressDialog(this);

        mAuth=FirebaseAuth.getInstance();
        mUSer=mAuth.getCurrentUser();

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SignUpActivity.this,MainActivity.class));
            }
        });
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               perForAuth();
            }
        });
    }

    private void perForAuth() {
        String email =username.getText().toString();
        String password=pass.getText().toString();
        String cpassword=cpass.getText().toString();

        if (!email.matches(emailPattern)){
            username.setError("Enetr Vallide Email");
        }else if (password.isEmpty() || password.length()<6){
            pass.setError("Enter Vallide Password");
        }else if (!password.equals(cpassword)){
            cpass.setError("Password Not Match both fields");
        }else {
            progressDialog.setMessage("Registering you Please wait...");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()){
                        progressDialog.dismiss();
                        sendToNext();
                        Toast.makeText(SignUpActivity.this, "Registration is successfull", Toast.LENGTH_SHORT).show();
                    }else {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "Registration is Unsuccessfull", Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }
    }

    private void sendToNext() {
        Intent intent=new Intent(SignUpActivity.this,HomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}