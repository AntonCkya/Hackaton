package com.example.hakatonproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PageActivity extends AppCompatActivity implements View.OnClickListener {
    String FirstName, LastName, SchoolNum, IDString = "1";
    TextView NameText, SchoolText, IDText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
        Bundle arguments = getIntent().getExtras();
        assert arguments != null;
        FirstName = arguments.getString("FirstName");
        LastName = arguments.getString("LastName");
        SchoolNum = arguments.getString("SchoolNum");
        NameText = findViewById(R.id.name_text);
        SchoolText = findViewById(R.id.school_text);
        IDText = findViewById(R.id.id_text);
        UpdateText();
    }
    private void UpdateText(){
        NameText.setText(FirstName + " " + LastName);
        SchoolText.setText("Школа:" + SchoolNum);
        IDText.setText("#ID:" + IDString);
    }

    @Override
    public void onClick(View v) {
        Intent i;
        switch ( v.getId() ){
            case R.id.achivements_new:
                i = new Intent(this, NewAchivementActivity.class);
                startActivity(i);
                break;
            case R.id.achivements_check:
                i = new Intent(this, MyAchivementsActivity.class);
                i.putExtra("Achive", (String)null);
                i.putExtra("Importance", false);
                i.putExtra("Official", false);
                startActivity(i);
                break;
        }
    }
    public void onBackPressed() {
        Intent i = new Intent(Intent.ACTION_MAIN);
        i.addCategory(Intent.CATEGORY_HOME);
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }
}
