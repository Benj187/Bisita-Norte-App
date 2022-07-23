package com.app.bisitanorte;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

public class Payment extends AppCompatActivity {

    EditText Fname, Lname, Creditcard, CW;
    Button Submit;
    ImageButton xbtn;
    String Checkin, Checkout;
    SharedPreferences sp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);

        Fname = findViewById(R.id.Fname);
        Lname = findViewById(R.id.Lname);
        Creditcard = findViewById(R.id.Creditcard);
        CW = findViewById(R.id.CW);

        sp = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);

        Submit = findViewById(R.id.SubPayment);
        xbtn = findViewById(R.id.x_btn);
        //X Button
        xbtn.setOnClickListener(view -> {
            Intent intent = new Intent(Payment.this, Hotels.class);
            startActivity(intent);
        });
        //Submit Payment
        Submit.setOnClickListener(view -> {
            String fname, lname, creditCard, dateValid, cw;

            fname = Fname.getText().toString().trim();
            lname = Lname.getText().toString().trim();
            creditCard = Creditcard.getText().toString().trim();
            cw = CW.getText().toString().trim();
            String Pay = "Payed";

            AlertDialog.Builder dialog = new AlertDialog.Builder(Payment.this);
            dialog.setTitle("Confirmation");
            dialog.setMessage("Press Ok To Confirm Your Payment And Cancel To Discard Your Payment");
            dialog.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("Paid", Pay);
                    editor.commit();

                    Intent intent = new Intent(getApplicationContext(), Hotels.class);
                    intent.putExtra("CheckIn", Checkin);
                    intent.putExtra("CheckOut", Checkout);
                    intent.putExtra("Pay", Pay);
                    intent.putExtra("Fname", fname);
                    intent.putExtra("Lname", lname);
                    intent.putExtra("CreditCard", creditCard);
                    intent.putExtra("CW", cw);
                    Toast.makeText(getApplicationContext(), "You Successfully Paid", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(getApplicationContext(), Hotels.class));
                }
            }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    dialog.setCancelable(true);
                }
            });
            dialog.create();
            dialog.show();

        });
    }
}