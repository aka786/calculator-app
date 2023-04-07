package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import  org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
TextView result_tv,solution_tv;
MaterialButton button_c,open_bracket,close_bracket;
MaterialButton divide,bm,bs,ba,be;
MaterialButton b0,b1,b2,b3,b4,b5,b6,b7,b8,b9;
MaterialButton bd,bA;
    public void openactivity(View view){
        Toast.makeText(this, " this is a toast button", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,scientific.class);
       startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result_tv=findViewById(R.id.result_tv);
        solution_tv=findViewById(R.id.solution_tv);
        assingId(button_c,R.id.button_c);
        assingId(open_bracket,R.id.open_bracket);
        assingId(close_bracket,R.id.close_bracket);
        assingId(ba,R.id.ba);
        assingId(divide,R.id.divide);
        assingId(bm,R.id.bm);
        assingId(bs,R.id.bs);
        assingId(be,R.id.be);
        assingId(b0,R.id.b0);
        assingId(b1,R.id.b1);
        assingId(b2,R.id.b2);
        assingId(b3,R.id.b3);
        assingId(b4,R.id.b4);
        assingId(b5,R.id.b5);
        assingId(b6,R.id.b6);
        assingId(b7,R.id.b7);
        assingId(b8,R.id.b8);
        assingId(b9,R.id.b9);

        assingId(bd,R.id.bd);
        assingId(bA,R.id.bA);




    }
    void assingId(MaterialButton btn,int id){
        btn=findViewById(id);
        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        MaterialButton button=(MaterialButton) view;
        String buttonText=button.getText().toString();
        String dataTocalculate=solution_tv.getText().toString();
        if(buttonText.equals("AC")){
            solution_tv.setText("");
            result_tv.setText("");
            return;

        }
        if(buttonText.equals("=")){
            solution_tv.setText(result_tv.getText());
            return;

        }
        if (buttonText.equals("C")){
            dataTocalculate=dataTocalculate.substring(0,dataTocalculate.length()-1);

        }
        else {
            dataTocalculate=dataTocalculate+buttonText;
        }

        solution_tv.setText(dataTocalculate);
String finalresult=getresult(dataTocalculate);
if(!finalresult.equals("Error")){
    result_tv.setText(finalresult);
}

    }
    String getresult(String data){
        try{
            Context context=Context.enter();
            context.setOptimizationLevel(-1);
            Scriptable scriptable=context.initStandardObjects();
         String finalresult= context.evaluateString(scriptable,data,"javascript",1,null).toString();
         if (finalresult.endsWith(".0")){
             finalresult=finalresult.replace(".0","");

         }

            return finalresult;

        }catch (Exception e){
             return  "Error";
        }
    }
}