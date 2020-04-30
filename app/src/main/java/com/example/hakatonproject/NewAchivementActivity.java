package com.example.hakatonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.Toast;

public class NewAchivementActivity extends AppCompatActivity implements View.OnClickListener {
    private Switch Imp, Ofc;
    private EditText AchiveET;
    private String Achive;
    private boolean ImpValue, OfcValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_achivement);
        Imp = findViewById(R.id.switch_importance);
        Ofc = findViewById(R.id.switch_official);
        AchiveET = findViewById(R.id.achievement);
    }

    @Override
    public void onClick(View v) {
        switch ( v.getId() ) {
            case R.id.accept_button_achievement:
                Achive = AchiveET.getText().toString();
                ImpValue = Imp.isChecked();
                OfcValue = Ofc.isChecked();
                if (Achive.length() == 0) {
                    Toast.makeText(getApplicationContext(), "Заплните поле достижения", Toast.LENGTH_SHORT).show();
                } else {
                    Intent i = new Intent(this, MyAchivementsActivity.class);
                    i.putExtra("Achive", Achive);
                    i.putExtra("Importance", ImpValue);
                    i.putExtra("Official", OfcValue);
                    startActivity(i);
                }
                break;
            case R.id.return_button:
                this.finish();
        }
    }
}
