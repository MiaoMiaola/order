package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int amount = 1;
    int basePrice = 5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);

        Button btnMinus = findViewById(R.id.btn_minus);
        Button btnPlus = findViewById(R.id.btn_plus);
        final TextView tvAmount = findViewById(R.id.amount);
        final CheckBox checkboxCream = findViewById(R.id.cb_cream);
        final CheckBox checkboxchip = findViewById(R.id.cb_chip);
        final CheckBox checkboxVanilla = findViewById(R.id.cb_vanilla);
        Button btnOrder = findViewById(R.id.btn_order);
        final TextView tvTY=findViewById(R.id.thankyou);


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Do stuff
                if(amount >=1) {
                    amount--;
                    tvAmount.setText(Integer.toString(amount));
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    amount++;
                    tvAmount.setText(Integer.toString(amount));

            }
        });

        btnOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int finalPrice=basePrice;
                if(checkboxCream.isChecked()){
                    finalPrice +=1;
                }
                if(checkboxchip.isChecked()){
                    finalPrice +=2;
                }
                if(checkboxVanilla.isChecked()){
                    finalPrice +=3;
                }
                finalPrice *=amount;

              Log.d("Final Price ",Integer.toString(finalPrice));

              tvTY.setText("Thank you for your order. \n The total price is " + Integer.toString(finalPrice));
                          }
        });


    }
}
