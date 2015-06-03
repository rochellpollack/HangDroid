package com.example.rachel.hangdroid;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GameOverActivity extends ActionBarActivity {

    int nPoints;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);

        nPoints = getIntent().getIntExtra("POINTS_IDENTIFIER",0);

        TextView tvPoints = (TextView) findViewById(R.id.tvPoints);
        tvPoints.setText(String.valueOf(nPoints));

        String randomWord = getIntent().getStringExtra("CORRECT_WORD");
        Toast.makeText(this,"The correct word is " + randomWord,Toast.LENGTH_LONG).show();
    }

    public void saveScores(View view){
        SharedPreferences preferences = getSharedPreferences("MYPREFRENCES", Context.MODE_PRIVATE);

        EditText etName = (EditText) findViewById(R.id.etName);
        String name = etName.getText().toString();
        SharedPreferences.Editor editor = preferences.edit();

        String previousScores = preferences.getString("SCORES", "");

        editor.putString("SCORES",name + " " + nPoints + " POINT(S)\n" + previousScores );
        editor.commit();

        finish();
    }


}
