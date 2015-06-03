package com.example.rachel.hangdroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


public class GameMultiActivity extends ActionBarActivity {

    String nWord;
    int nfailedCounter = 0;
    int nGuessedLetters = 0;
    int points = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_game);

        nWord = getIntent().getStringExtra("PLAYERS_WORD").toUpperCase();

        Log.d("MYLOG", nWord);

        createTextViews();
    }


    /**
     * Retrieving the letter introduced on the editText
     *
     * @param view (button clicked)
     */
    public void introduceLetter(View view){

        EditText myEditText =(EditText)findViewById(R.id.etInsertedLetter);

        String letter = myEditText.getText().toString();
        myEditText.setText("");

        Log.d("MYLOG", "The letter introduced is " + letter);
        if(letter.length() == 1){
            checkLetter(letter.toUpperCase());
        }else {
            Toast.makeText(this, "Enter a letter", Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * checking if the letter entered matches any letter of the word to guess
     *
     * @param introduceLetter, letter enterd by the user
     */
    public void checkLetter(String introduceLetter){

        char charIntroduced = introduceLetter.charAt(0);
        boolean letterGuessed = false;

        for(int i = 0; i < nWord.length(); i++){

            char charFromTheWord =nWord.charAt(i);

            if(charFromTheWord == charIntroduced){
                Log.d("MYLOG", "There was one match");

                letterGuessed = true;

                showLettersAtIndex(i,charIntroduced);

                nGuessedLetters++;
            }
        }
        if(letterGuessed == false){
            displayFailedLetter(introduceLetter);
            letterFailed();

        }

        if(nGuessedLetters == nWord.length()){
            TextView tvCorrectWord = (TextView) findViewById(R.id.tvCorrectWord);
            tvCorrectWord.setText(nWord);
           finish();

        }

    }

    public void createTextViews(){
        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);

        for(int i = 0; i < nWord.length(); i++){
            TextView textView = (TextView) getLayoutInflater().inflate(R.layout.textview, null);

            layoutLetters.addView(textView);

        }
    }



    public  void clearScreen(){
        TextView tvIncorrectLetters = (TextView) findViewById(R.id.tvIncorrectLetters);
        tvIncorrectLetters.setText("");

        LinearLayout layoutLetters = (LinearLayout) findViewById(R.id.layoutLetters);
        for(int i = 0; i < layoutLetters.getChildCount(); i++){
            TextView currentTextView = (TextView) layoutLetters.getChildAt(i);
            currentTextView.setText("_");
        }

        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.hangdroid_0);

        nGuessedLetters =0;
        nfailedCounter =0;

    }

    public void letterFailed(){
        nfailedCounter++;
        ImageView imageView = (ImageView) findViewById(R.id.imageView);

        if(nfailedCounter == 1){
            imageView.setImageResource(R.drawable.hangdroid_1);
        }else if(nfailedCounter == 2){
            imageView.setImageResource(R.drawable.hangdroid_2);
        }else  if(nfailedCounter == 3){
            imageView.setImageResource(R.drawable.hangdroid_3);
        }else if(nfailedCounter == 4){
            imageView.setImageResource(R.drawable.hangdroid_4);
        }else  if(nfailedCounter == 5){
            imageView.setImageResource(R.drawable.hangdroid_5);
        }else if(nfailedCounter == 6){
            Intent gameOverIntent = new Intent(this,GameOverActivity.class);
            gameOverIntent.putExtra("POINTS_IDENTIFIER",points);
            gameOverIntent.putExtra("CORRECT_WORD",nWord);
            startActivity(gameOverIntent);
            finish();
     }
    }

    public void displayFailedLetter(String introduceLetter){

        TextView tvIncorrectLetters = (TextView) findViewById(R.id.tvIncorrectLetters);

        String incorrectLetters = tvIncorrectLetters.getText().toString();

        boolean isGuessed = false;
        for (int i = 0; i < incorrectLetters.length(); i++){
            if(incorrectLetters.charAt(i) == introduceLetter.charAt(0)) {
                --nfailedCounter;
                isGuessed = true;
                Toast.makeText(this, "You already guessed this letter! Try another  letter", Toast.LENGTH_SHORT).show();

            }
        }

        if(isGuessed == false) {
            tvIncorrectLetters.setText(incorrectLetters + " " + introduceLetter);
        }
    }

    /**
     * Displaying a letter passed by the user
     * @param position of the letter
     * @param letterGuessed
     */
    public  void showLettersAtIndex(int position, char letterGuessed){

        LinearLayout layoutLetter = (LinearLayout) findViewById(R.id.layoutLetters);

        TextView textView = (TextView) layoutLetter.getChildAt(position);

        textView.setText(Character.toString(letterGuessed));
    }


}
