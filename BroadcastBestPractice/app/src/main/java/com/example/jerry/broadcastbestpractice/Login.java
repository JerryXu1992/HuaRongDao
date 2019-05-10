package com.example.jerry.broadcastbestpractice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

public class Login extends AppCompatActivity {

    private EditText name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ImageButton picture = (ImageButton) findViewById(R.id.picture);
        name = (EditText) findViewById(R.id.name);
        Button reset = (Button) findViewById(R.id.reset);
        Button login = (Button) findViewById(R.id.login);

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name.setText("");
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Login.this,MainActivity.class);
                intent.putExtra("name",name.getText().toString());
                startActivity(intent);
            }
        });


    }
}
