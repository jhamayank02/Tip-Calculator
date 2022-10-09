package com.example.tipcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText billAmnt;
    EditText tipPercent;
    EditText splitBet;
    TextView tipAmnt;
    TextView billPerPerson;
    Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        billAmnt = findViewById(R.id.billAmnt);
        tipPercent = findViewById(R.id.tipPercent);
        splitBet = findViewById(R.id.splitBet);
        tipAmnt = findViewById(R.id.tipAmnt);
        billPerPerson = findViewById(R.id.billPerPerson);
        calculateBtn = findViewById(R.id.calculateBtn);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("calculate", "Clicked");

                if(!billAmnt.getText().toString().equals("") && !tipPercent.getText().toString().equals("") && !splitBet.getText().toString().equals("")) {
                    double bill_amount = Double.parseDouble(billAmnt.getText().toString());
                    double tip_percent = Double.parseDouble(tipPercent.getText().toString());
                    double split_between = Double.parseDouble(splitBet.getText().toString());

                    double tip_amount = (bill_amount * tip_percent)/100;
                    double bill_per_person = (bill_amount + tip_amount)/split_between;
                    Log.d("calculateAns", String.valueOf(tip_amount + bill_per_person));

                    tipAmnt.setText(String.valueOf(tip_amount));
                    billPerPerson.setText(String.valueOf(bill_per_person));
                }
                else{
                    Toast.makeText(MainActivity.this, "Please fill all the fields!!!", Toast.LENGTH_SHORT).show();
                }
            }

        });
    }
}