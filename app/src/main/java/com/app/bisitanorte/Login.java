package com.app.bisitanorte;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class Login extends AppCompatActivity {

    TextView textView;
    Button button;
    String Username, Password, getUname, getPass;
    EditText Uname, Pass;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        Uname = findViewById(R.id.username);
        Pass = findViewById(R.id.password);
        textView = findViewById(R.id.create_acc);
        textView.setPaintFlags(textView.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        textView.setText("Create Account");

        getUname = Uname.getText().toString().trim();
        getPass = Pass.getText().toString().trim();
        Username = getIntent().getStringExtra("Username");
        Password = getIntent().getStringExtra("Password");

        textView.setOnClickListener(view -> {
            Intent intent=new Intent(Login.this,Create_Acc.class);
            startActivity(intent);

            Toast.makeText(Login.this, "You can make your account now", Toast.LENGTH_LONG).show();
        });

        button = findViewById(R.id.logButton);
        button.setOnClickListener(view -> {

            if (getUname.equals(Username) && getPass.equals(Password)){
                Intent intent=new Intent(Login.this,Loading.class);
                startActivity(intent);
            }
            else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(Login.this);
                dialog.setTitle("Warning");
                dialog.setMessage("Incorrect Password or Email");
                dialog.setNegativeButton("Back", (dialogInterface, i) -> dialogInterface.dismiss()).create();
                dialog.show();
            }
        });
    }
}