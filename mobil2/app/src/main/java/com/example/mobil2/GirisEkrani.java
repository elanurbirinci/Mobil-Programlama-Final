package com.example.mobil2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class GirisEkrani extends AppCompatActivity {

    Button login_btn,signup_btn;

    private FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_giris_ekrani);

        login_btn=findViewById(R.id.login_btn);
        signup_btn=findViewById(R.id.singup_btn);

        FirebaseUser mUser=FirebaseAuth.getInstance().getCurrentUser();

        if(mUser !=null){
            startActivity(new Intent(this,MainActivity.class));
            finish();
        }


        login_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GirisEkrani.this,Login.class);
                startActivity(i);
            }
        });

        signup_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(GirisEkrani.this,Signup.class);
                startActivity(i);
            }
        });


    }


}