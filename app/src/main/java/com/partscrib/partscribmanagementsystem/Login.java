package com.partscrib.partscribmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login extends AppCompatActivity {
    public static final String USER_NAME_MESSAGE = "com.partscrib.partscribmanagementsystem.USER_NAME";
    private FirebaseAuth mAuth;
    private EditText emailField;
    private EditText passwordField;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

    }


    public void onLogin(View view){



        mAuth = FirebaseAuth.getInstance();

        final Intent intent = new Intent(this, MainActivity.class);
        emailField = (EditText) findViewById(R.id.email);
        String email = emailField.getText().toString();

        passwordField = (EditText) findViewById(R.id.login_password);
        String password = passwordField.getText().toString();

        if (email.length() == 0 || password.length() == 0){
            CharSequence text = "Email & Password can't be empty";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            return;
        } else if (!email.contains("@humbermail.ca") && !email.contains("@humber.ca")){
            CharSequence text = "Must be @humber.ca or @humbermail.ca email";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this, text, duration);
            toast.show();
            return;

        }

        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()){
                    FirebaseUser user = mAuth.getCurrentUser();
                    intent.putExtra(USER_NAME_MESSAGE, user.getUid());
                    //Log.d("Sign in User:", user);
                    startActivity(intent);

                }
                else {
                    Context context = getApplicationContext();
                    CharSequence text = "Invalid username/password";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();

                }
            }
        });


    }

    public void startRegistration(View view){
        Intent intent = new Intent(this, SignUpActivity.class);


        startActivity(intent);
    }


    public void startPasswordRecovery(View view){
        Intent intent = new Intent(this, ForgottenPasswordActivity.class);
        startActivity(intent);
    }
}
