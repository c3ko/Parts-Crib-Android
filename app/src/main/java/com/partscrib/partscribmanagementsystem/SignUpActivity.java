package com.partscrib.partscribmanagementsystem;

import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.partscrib.partscribmanagementsystem.model.UserDataModel;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private EditText firstName, studentNumber, email, password, password2;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTheme(R.style.AppTheme_NoActionBar);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mAuth = FirebaseAuth.getInstance();

        findViewsFromLayout();



    }

    /*
    * Should only be run after initial successful creation of user
    *
    * */

    private void writeNewUserData(){
        String uid = mAuth.getUid();
        database = FirebaseDatabase.getInstance();
        String path = "userdata/" + uid;


        UserDataModel userData = buildUser(mAuth.getUid(), email.getText(),
                studentNumber.getText(), firstName.getText());

        myRef = database.getReference(path);
        myRef.setValue(userData);
                /*
        myRef.push().setValue(userData).addOnSuccessListener(new OnSuccessListener<Void>(){

            @Override
            public void onSuccess(Void aVoid) {
                Log.d("UserData", "Added new user: " + mAuth.getUid());
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d("UserData", "Writing to userdata failed");
            }
        });

                 */
    }

    private void findViewsFromLayout(){

        firstName = findViewById(R.id.firstName);
        studentNumber = findViewById(R.id.studentNumber);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        password2 = findViewById(R.id.password2);
        registerButton = findViewById(R.id.login);
    }

    private UserDataModel buildUser(String userID, Editable email, Editable studentNumber, Editable firstName){

        return new UserDataModel(userID,
                String.valueOf(email),
                String.valueOf(firstName),
                String.valueOf(studentNumber),
                null
                );
    }
    public void beginRegistration(View v){


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



        mAuth.createUserWithEmailAndPassword(newEmail, newPassword1)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()){
                                FirebaseUser user = mAuth.getCurrentUser();
                                Toast.makeText(getApplicationContext(), "Account Successfully created.",
                                        Toast.LENGTH_LONG).show();
                                Log.d("Register", "User registration was successful");

                                writeNewUserData();
                                finish();
                            } else {
                                Toast.makeText(getApplicationContext(), "Registration Failed",
                                        Toast.LENGTH_LONG).show();
                                Log.w("Register", "User registration failed");
                            }
                    }
                });
    }
}
