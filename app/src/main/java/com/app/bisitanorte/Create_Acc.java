package com.app.bisitanorte;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class Create_Acc extends AppCompatActivity {
    ImageButton exit_btn;
    Button createBtn;
    EditText userName, password, country, phoneNumber;
    String Uname, Pass, Country, Pnumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_acc);

        exit_btn = findViewById(R.id.x_btn);
        createBtn = findViewById(R.id.createButton);
        userName = findViewById(R.id.userName);
        password = findViewById(R.id.Password);
        country = findViewById(R.id.Country);
        phoneNumber = findViewById(R.id.PhoneNum);

        Uname = userName.getText().toString().trim();
        Pass = password.getText().toString().trim();
        Country = country.getText().toString().trim();
        Pnumber = phoneNumber.getText().toString().trim();

        createBtn.setOnClickListener(view -> {
            Intent intent = new Intent(Create_Acc.this, Login.class);
            intent.putExtra("Username", Uname);
            intent.putExtra("Password", Pass);
            startActivity(intent);
        });

        exit_btn.setOnClickListener(v -> {
            Intent intent = new Intent(Create_Acc.this,Login.class);
            startActivity(intent);

        });
    }
}