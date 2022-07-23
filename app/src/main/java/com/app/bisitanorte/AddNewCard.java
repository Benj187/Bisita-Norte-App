package com.app.bisitanorte;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class AddNewCard extends AppCompatActivity {

    EditText CreditCard, ValidDate, CW;
    Button back, addCard;
    CheckBox checkBox;
    String check, creditCard, validDate, cw;
    String agree = "agree";
    TextView textAgree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_card);

        CreditCard = findViewById(R.id.Creditcard);
        ValidDate = findViewById(R.id.Valid);
        CW = findViewById(R.id.CW);
        addCard = findViewById(R.id.AddCard);
        back = findViewById(R.id.backButton);
        checkBox = findViewById(R.id.checkBox);
        textAgree = findViewById(R.id.agree);

        checkBox.setOnCheckedChangeListener((compoundButton, isChecked) -> {
            if (isChecked){
                check = "agree";
                textAgree.setTextColor(Color.parseColor("#00A511"));
            }
            else {
                check ="unagree";
            }
        });

        back.setOnClickListener(view -> {
            Intent intent = new Intent(AddNewCard.this, HomeIntro.class);
            startActivity(intent);
        });
        addCard.setOnClickListener(view -> {
            if(check.equals(agree)){
                creditCard = CreditCard.getText().toString().trim();
                validDate = ValidDate.getText().toString().trim();
                cw = CW.getText().toString().trim();
                Toast.makeText(AddNewCard.this, "Card Added to your Account", Toast.LENGTH_LONG).show();
            }
            else {
                AlertDialog.Builder dialog = new AlertDialog.Builder(AddNewCard.this);
                dialog.setTitle("Reminder");
                dialog.setMessage("You need to check the box to add your card on your account");
                dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
                dialog.show();
            }
        });

        NavigationBarView bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.more);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.home) {
                goHome();
                return true;
            }
            else if (item.getItemId() == R.id.save) {
                goSave();
                return true;
            }
            else if (item.getItemId() == R.id.bookings) {
                goBooking();
                return true;
            }
            else if (item.getItemId() == R.id.message) {
                goMessage();
                return true;
            }
            else if (item.getItemId() == R.id.more) {
                goMore();
                return true;
            }
            else {
                return false;
            }
        });
    }

    public void goHome (){
        Intent intent = new Intent(AddNewCard.this, HomeIntro.class);
        startActivity(intent);
        finish();
    }
    public void goSave (){
        Intent intent = new Intent(AddNewCard.this, Save.class);
        startActivity(intent);
        finish();
    }
    public void goBooking (){
        Intent intent = new Intent(AddNewCard.this, Booking.class);
        startActivity(intent);
        finish();
    }
    public void goMessage (){
        Intent intent = new Intent(AddNewCard.this, Messages.class);
        startActivity(intent);
        finish();
    }
    public void goMore (){
        Intent intent = new Intent(AddNewCard.this, More.class);
        startActivity(intent);
        finish();
    }
}