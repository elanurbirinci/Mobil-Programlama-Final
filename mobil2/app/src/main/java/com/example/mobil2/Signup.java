package com.example.mobil2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class Signup extends AppCompatActivity {

    private Button Login,Signup;
    private EditText Email_edt, Password_edt,lastname_edt,name_edt;
    private String txtEmail,txtPassword,txtname,txtlastname;
    private FirebaseAuth mAuth;
    private static final String TAG = "Signup";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        Login=findViewById(R.id.Login);
        Signup=findViewById(R.id.Signup);
        Email_edt=findViewById(R.id.Email_edt);
        Password_edt=findViewById(R.id.Password_edt);
        lastname_edt=findViewById(R.id.lastname_edt);
        name_edt=findViewById(R.id.name_edt);

        mAuth= FirebaseAuth.getInstance();


        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtEmail=Email_edt.getText().toString().trim();
                txtPassword=Password_edt.getText().toString().trim();
                txtname=name_edt.getText().toString().trim();
                txtlastname=lastname_edt.getText().toString().trim();

                if(txtEmail.isEmpty()){
                    Email_edt.setError("Email boş bırakılamaz");
                    return;
                }
                if(txtPassword.isEmpty()){
                    Password_edt.setError("Şifre boş bırakılamaz");
                    return;
                }
                if(txtname.isEmpty()){
                    name_edt.setError("İsim giriniz");
                    return;
                }
                if(txtlastname.isEmpty()){
                    lastname_edt.setError("Soyisim giriniz");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(txtEmail,txtPassword)
                        .addOnCompleteListener(Signup.this, task ->{
                            if(task.isSuccessful()){

                                Toast.makeText(Signup.this, "Kayıt Başarıyla gerçekleşti", Toast.LENGTH_SHORT).show();

                                    FirebaseFirestore db=FirebaseFirestore.getInstance();
                                    Map<String, Object> user =new HashMap<>();
                                    user.put("name", txtname);
                                    user.put("lastname", txtlastname);
                                    db.collection("users").document(mAuth.getUid())
                                            .set(user)
                                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void unused) {
                                                    Log.d(TAG,"Başarılı bir şekilde oluşturuldu");
                                                }
                                            });

                            }
                            else{
                                Exception e=task.getException();
                                if(e != null){
                                    Toast.makeText(Signup.this, "kayıt yapılırken hata oluştu", Toast.LENGTH_SHORT).show();
                                }
                            }
                        });


            }
        });

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(Signup.this,Login.class);
                startActivity(i);
            }
        });




    }



}