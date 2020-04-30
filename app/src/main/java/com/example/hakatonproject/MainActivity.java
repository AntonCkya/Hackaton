package com.example.hakatonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText FirstName, LastName, SchoolNum;
    String FirstNameStr, LastNameStr, SchoolNumStr;
    boolean Reg = false;
    private SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FirstName = findViewById(R.id.first_name);
        LastName = findViewById(R.id.last_name);
        SchoolNum = findViewById(R.id.school_num);
        SP = getSharedPreferences( "mysettings", Context.MODE_PRIVATE);
        Reg = SP.getBoolean( "Reg", false);
        if(Reg){
            FirstNameStr = SP.getString("FirstName", null);
            LastNameStr = SP.getString("LastName", null);
            SchoolNumStr = SP.getString("SchoolNum", null);
            Intent i = new Intent(this, PageActivity.class);
            i.putExtra("FirstName", FirstNameStr);
            i.putExtra("LastName", LastNameStr);
            i.putExtra("SchoolNum", SchoolNumStr);
            startActivity(i);
        }
    }

    @Override
    public void onClick(View v) {
        SharedPreferences.Editor editor = SP.edit();
        FirstNameStr = FirstName.getText().toString();
        LastNameStr = LastName.getText().toString();
        SchoolNumStr = SchoolNum.getText().toString();
        if( FirstNameStr.length() == 0 || LastNameStr.length() == 0 || SchoolNumStr.length() == 0){
            Toast.makeText(getApplicationContext(), "Некоторые поля не заполнены\nПожалуйста, заполните все поля", Toast.LENGTH_SHORT).show();
        }else{
            editor.putBoolean("Reg", true);
            editor.putString("FirstName", FirstNameStr);
            editor.putString("LastName", LastNameStr);
            editor.putString("SchoolNum", SchoolNumStr);
            editor.apply();
            Intent i = new Intent(this, PageActivity.class);
            i.putExtra("FirstName", FirstNameStr);
            i.putExtra("LastName", LastNameStr);
            i.putExtra("SchoolNum", SchoolNumStr);
            startActivity(i);
        }
    }
}
