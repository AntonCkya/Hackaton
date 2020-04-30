package com.example.hakatonproject;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MyAchivementsActivity extends AppCompatActivity implements View.OnClickListener {
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
            Achivements += "•" + NewAchivement + "\n - " + ImpStr + ", " + OfcStr + "\n\n";
            editor.putString( "Achivements", Achivements );
            editor.apply();
        }
        Ach.setText( Achivements );
    }

    @Override
    public void onClick(View v) {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
    @Override
    public void onBackPressed() {
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}
