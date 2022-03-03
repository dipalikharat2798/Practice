package com.example.equivalent.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.equivalent.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

public class OTPActivity extends AppCompatActivity {
    private Button mVerifyCodeBtn;
    private EditText otpEdit;
    private String OTP;
    private ProgressBar mOtpProgress;
    private FirebaseAuth firebaseAuth;
    private TextView mOtpFeedback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);

        mVerifyCodeBtn = findViewById(R.id.verify_btn);
        otpEdit = findViewById(R.id.otp_text_view);
        mOtpProgress = findViewById(R.id.otp_progress_bar);
        mOtpFeedback=findViewById(R.id.otp_form_feedback);

        firebaseAuth = FirebaseAuth.getInstance();

        OTP = getIntent().getStringExtra("auth");
        mVerifyCodeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String verification_code = otpEdit.getText().toString();
                if(!verification_code.isEmpty()){
                    mOtpProgress.setVisibility(View.VISIBLE);
                    mVerifyCodeBtn.setEnabled(false);
                    PhoneAuthCredential credential = PhoneAuthProvider.getCredential(OTP , verification_code);
                    signIn(credential);
                }else{
                    mOtpFeedback.setText("Please Enter OTP");
                }
            }
        });
    }
    private void signIn(PhoneAuthCredential credential){
        firebaseAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    sendToMain();
                } else {
                    if (task.getException() instanceof FirebaseAuthInvalidCredentialsException) {
                        // The verification code entered was invalid
                        mOtpFeedback.setVisibility(View.VISIBLE);
                        mOtpFeedback.setText("There was an error verifying OTP");
                    }
                }
                mOtpProgress.setVisibility(View.INVISIBLE);
                mVerifyCodeBtn.setEnabled(true);
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser currentUser = firebaseAuth.getCurrentUser();
        if (currentUser !=null){
            sendToMain();
        }
    }

    private void sendToMain(){
        startActivity(new Intent(OTPActivity.this , MainActivity.class));
        finish();
    }
}