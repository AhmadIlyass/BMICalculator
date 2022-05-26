package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText edtWeight, edtHeightFt, edtHeightIn;
        TextView txtResult;
        Button btnCalculate;
        ConstraintLayout CLMain;

        edtWeight = findViewById(R.id.edtWeight);
        edtHeightFt = findViewById(R.id.edtHeightFt);
        edtHeightIn = findViewById(R.id.edtHeightIn);
        btnCalculate = findViewById(R.id.btnCalculate);
        txtResult = findViewById(R.id.txtResult);
        CLMain = findViewById(R.id.CLMain);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int wt= Integer.parseInt( edtWeight.getText().toString() );
                int ft= Integer.parseInt( edtHeightFt.getText().toString());
                int in = Integer.parseInt( edtHeightIn.getText().toString());

                int totalIn= ft*12 +in;

                double totalCm= totalIn*2.53;
                double totalM = totalCm/100;
                double bmi= wt/(totalM*totalM);

                if (bmi>25){
                    txtResult.setText("You're Overweight!");
                    CLMain.setBackgroundColor(getResources().getColor(R.color.colorOW));
                } else if (bmi <18){
                    txtResult.setText("You're Under weight!");
                    CLMain.setBackgroundColor(getResources().getColor(R.color.colorUW));
                }else{
                    txtResult.setText("You're Healthy!!");
                    CLMain.setBackgroundColor(getResources().getColor(R.color.colorH));
                }

            }
        });

    }
}

