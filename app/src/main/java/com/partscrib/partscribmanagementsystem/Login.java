package com.partscrib.partscribmanagementsystem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }


    public void onLogin(View view){
        Intent intent = new Intent(this, MainActivity.class);
        EditText userNameField = (EditText) findViewById(R.id.email);
        String username = userNameField.getText().toString();

        if (username.equals("partscrib")){
            startActivity(intent);
        }
        else {
            Context context = getApplicationContext();
            CharSequence text = "Invalid username";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(context, text, duration);
            toast.show();
        }
    }

    public void startRegistration(View view){
        Intent intent = new Intent(this, SignUpActivity.class);
        startActivity(intent);
    }
}
