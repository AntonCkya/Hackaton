package com.example.hakatonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAchivementsActivity extends AppCompatActivity {
    private String NewAchivement, ImpStr, OfcStr;
    private boolean Imp, Ofc;
    TextView Ach;
    SharedPreferences SP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_achivements);
        SP = getSharedPreferences( "mysettings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = SP.edit();
        Ach = findViewById(R.id.ach);
        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        NewAchivement = arguments.getString("Achive", null);
        Imp = arguments.getBoolean("Importance", false);
        Ofc = arguments.getBoolean("Official", false);
        ImpStr = Imp ? "Важное" : "Неважное";
        OfcStr = Ofc ? "Оффициальное" : "Неофициальное";
        String Achivements = SP.getString("Achivements", "");
        if( NewAchivement != null){
            Achivements += "•" + NewAchivement + "\n - " + ImpStr + ", " + OfcStr + "\n";
            editor.putString( "Achivements", Achivements );
            editor.apply();
        }
        Ach.setText( Achivements );
    }
}
