package com.example.rachel.hangdroid;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;


public class MultiPlayerActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_player);

    }

    public  void play(View view){
        EditText etWord = (EditText) findViewById(R.id.etWord);
        String wordToGuess = etWord.getText().toString();

        etWord.setText("");

        Intent intent = new Intent(this,GameMultiActivity.class);
        intent.putExtra("PLAYERS_WORD",wordToGuess);
        startActivity(intent);
    }


}
