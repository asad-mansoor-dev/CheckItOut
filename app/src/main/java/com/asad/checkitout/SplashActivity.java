package com.asad.checkitout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        firebaseAuth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_splash);
        SystemClock.sleep(3000);
    }

    @Override
    protected void onStart() {
        super.onStart();

        FirebaseUser currentUser  = firebaseAuth.getCurrentUser();

        if(currentUser == null){
            Intent registerIntent = new Intent(SplashActivity.this, RegisterActivity.class);
            startActivity(registerIntent);
            finish();
        }else{
            Intent loginIntent = new Intent(SplashActivity.this,MainActivity.class);
            startActivity(loginIntent);
            finish();
        }
    }
}
