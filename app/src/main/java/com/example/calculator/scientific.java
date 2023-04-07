package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

public class scientific extends AppCompatActivity implements View.OnClickListener {
    TextView result_tv,solution_tv;
    MaterialButton button_c,open_bracket,close_bracket;
    MaterialButton divide,bm,bs,ba,be;
    MaterialButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
    MaterialButton bd,bA,tan,cos,bS,deg,square,sqrt,fact,up,bpi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scientific);
    }

    @Override
    public void onClick(View v) {

    }
}