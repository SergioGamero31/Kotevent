package com.example.kotevent;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
//Renzo Cuadros Salazar
//Sergio Gamero Calle
//Gricel Ramos Ramos
public class SignupActivity extends AppCompatActivity {

    private EditText TextName;
    private EditText TextLastname;
    private EditText TextEmail;
    private EditText TextPassword;
    private EditText TextRepeatpass;
    private Button btnRegistrar;

    //Datos a registrar :v
    private String name, lastname, email, password, rpassword;

    private FirebaseAuth mAuth;
    DatabaseReference mDatabase;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_registro);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        TextName = (EditText) findViewById(R.id.txtUser);
        TextLastname = (EditText) findViewById(R.id.txtLastName);
        TextEmail = (EditText) findViewById(R.id.txtEmail);
        TextPassword = (EditText) findViewById(R.id.txtPassword);
        TextRepeatpass = (EditText) findViewById(R.id.txtRepeatPassword);

        btnRegistrar = (Button) findViewById(R.id.btnSignup);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name = TextName.getText().toString();
                lastname = TextLastname.getText().toString();
                email = TextEmail.getText().toString();
                password = TextPassword.getText().toString();
                rpassword = TextRepeatpass.getText().toString();

                if(!name.isEmpty() && !lastname.isEmpty() && !email.isEmpty()
                        && !password.isEmpty() && !rpassword.isEmpty()){
                    if(password.length() >=6){
                        if(password.equals(rpassword)){
                            registerUser();
                        }else{
                            Toast.makeText(SignupActivity.this,"Las contraseñas no coindicen", Toast.LENGTH_LONG).show();
                        }
                    }else{
                        Toast.makeText(SignupActivity.this,"La contraseña debe tener al menos 6 caracteres", Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(SignupActivity.this,"Debe completar los campos", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    public void onClickLogin(View view){
        finish();
    }
    private void registerUser(){
        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()) {
                    Map<String, Object> map = new HashMap<>();
                    map.put("name",name);
                    map.put("lastname",lastname);
                    map.put("email",email);
                    map.put("password",password);

                    String id = mAuth.getCurrentUser().getUid();

                    mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                        @Override
                        public void onComplete(@NonNull Task<Void> task2) {
                            if(task2.isSuccessful()){
                                startActivity(new Intent(SignupActivity.this, LoginActivity.class));
                                finish();
                            }else{
                                Toast.makeText(SignupActivity.this,"No se pudieron crear los datos correctamente", Toast.LENGTH_LONG).show();
                            }
                        }
                    });
                }else{
                    if(task.getException() instanceof FirebaseAuthUserCollisionException){
                        Toast.makeText(SignupActivity.this,"El correo ya se encuentra registrado", Toast.LENGTH_LONG).show();
                    }else {
                        Toast.makeText(SignupActivity.this, "No se pudo registrar este usuario", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
