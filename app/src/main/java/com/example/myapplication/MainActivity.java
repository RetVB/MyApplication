package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int counter = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText username = (EditText)findViewById(R.id.username);
        final EditText password = (EditText)findViewById((R.id.password));
        final Button loginbutton = (Button)findViewById(R.id.button_login);
        final Button deletebutton = (Button)findViewById(R.id.button_delete);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (username.getText().toString().equals("") && password.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(),"Redirecting...", Toast.LENGTH_LONG).show();

                    Intent activity2Intent = new Intent(getApplicationContext(), SecondActivity.class);
                    startActivity(activity2Intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Wrong Credentials", Toast.LENGTH_LONG).show();
                    counter --;
                    if (counter == 0)
                    {
                        loginbutton.setEnabled(false);
                    }
                }
            }
        });


    }



}
