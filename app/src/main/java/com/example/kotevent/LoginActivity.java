package com.example.kotevent;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText TextEmail;
    private EditText TextPassword;
    private Button botonIngresar;

    private String email ="";
    private String password = "";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_ingreso);

        mAuth = FirebaseAuth.getInstance();

        TextEmail = (EditText) findViewById(R.id.txtUser);
        TextPassword = (EditText) findViewById(R.id.txtPassword);
        botonIngresar = (Button) findViewById(R.id.btnLogin);

        botonIngresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               email = TextEmail.getText().toString();
               password = TextPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()) {
                    loginUser();
                }else{
                    Toast.makeText(LoginActivity.this,"Debe completar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this,new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                    finish();
                }else{
                    Toast.makeText(LoginActivity.this,"No se pudo iniciar sesión, compruebe los datos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onClickSig(View view){
        startActivity(new Intent("com.example.SignupActivity"));
    }
   /*public void onClickMain(View view){
        startActivity(new Intent("com.example.MainActivity"));
    }*/
}
