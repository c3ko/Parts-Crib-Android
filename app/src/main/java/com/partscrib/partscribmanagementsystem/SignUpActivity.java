package com.partscrib.partscribmanagementsystem;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private EditText password;
    private EditText password2;
    private EditText email;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    private void findViewsFromLayout(){


        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);

    }

    public void beginRegistration(View view){


        String newEmail = String.valueOf(email.getText());
        String newPassword1 = String.valueOf(password.getText());
        String newPassword2 = String.valueOf(password2.getText());

        if (newEmail.length() == 0 || newPassword1.length() == 0 || newPassword2.length() == 0){
            Toast.makeText(getApplicationContext(), "The email and/or password cannot be empty",
                    Toast.LENGTH_LONG).show();
            return; // do nothing if empty.
        }
        else if (!newPassword1.equals(newPassword2))
        {
            Toast.makeText(getApplicationContext(), "The password does't match, cannot continue",
                    Toast.LENGTH_LONG).show();
        }

        mAuth = FirebaseAuth.getInstance();

        mAuth.createUserWithEmailAndPassword(newEmail, newPassword1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "Account Successfully created.",
                                        Toast.LENGTH_LONG).show();
                                Log.d("Login", "User registration was succesful");
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Registration Failed",
                                        Toast.LENGTH_LONG).show();
                                Log.w("Login", "User registration failed");
                            }
                    }
                });
    }
}
