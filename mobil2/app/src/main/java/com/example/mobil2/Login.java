package com.example.mobil2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Button login,signup;
    private EditText editEmail, editPassword;
    private FirebaseAuth mAuth;
    private String email,password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login=findViewById(R.id.login);
        signup=findViewById(R.id.signup);
        editEmail=findViewById(R.id.editEmail);
        editPassword=findViewById(R.id.editPassword);

        FirebaseAuth mAuth=FirebaseAuth.getInstance();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email=editEmail.getText().toString();
                password=editPassword.getText().toString();
                
                if(email.isEmpty() || password.isEmpty()){
                    Toast.makeText(Login.this, "Lütfen email veya şifre giriniz!", Toast.LENGTH_SHORT).show();
                    return;
                }
                mAuth.signInWithEmailAndPassword(email,password)
                        .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(Login.this, "Giriş başarılı", Toast.LENGTH_SHORT).show();
                                    Intent i=new Intent(Login.this,MainActivity.class);
                                    startActivity(i);
                                }
                                else{
                                    Toast.makeText(Login.this, "giriş başarısız", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });

            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Login.this,Signup.class);
                startActivity(i);
            }
        });
    }
}