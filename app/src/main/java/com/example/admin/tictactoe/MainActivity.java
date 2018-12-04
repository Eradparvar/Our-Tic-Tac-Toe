package com.example.admin.tictactoe;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    boolean easy;
    boolean hard;
    boolean randomMethodsTurn = true; //Used in easy version
    boolean miseryVersion = false;
    Board board = new Board(State.X, this, this);
    TextView btn;
    TextView lastMove;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
       //use gameMode variable to select game mode type
        String gameMode = intent.getStringExtra("gameMode");
        Toast.makeText(getApplicationContext(), "You are in: " + gameMode, Toast.LENGTH_SHORT).show();
    }

    public void makeMove(View v) {
        if (miseryVersion){
            misereVersionMove(v);
        } else if (v.getId() == R.id.b00 && board.getStateAt(0) == State.BLANK) {
            board.move(0);
            btn = findViewById(R.id.b00);
            btn.setTextColor(Color.parseColor(board.getString(0) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(0));
            lastMove = btn;

        } else if (v.getId() == R.id.b01 && board.getStateAt(1) == State.BLANK) {
            board.move(1);
            btn = findViewById(R.id.b01);
            btn.setTextColor(Color.parseColor(board.getString(1) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(1));
            lastMove = btn;

        } else if (v.getId() == R.id.b02 && board.getStateAt(2) == State.BLANK) {
            board.move(2);
            btn = findViewById(R.id.b02);
            btn.setTextColor(Color.parseColor(board.getString(2) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(2));
            lastMove = btn;

        } else if (v.getId() == R.id.b10 && board.getStateAt(3) == State.BLANK) {
            board.move(3);
            btn = findViewById(R.id.b10);
            btn.setTextColor(Color.parseColor(board.getString(3) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(3));
            lastMove = btn;

        } else if (v.getId() == R.id.b11 && board.getStateAt(4) == State.BLANK) {
            board.move(4);
            btn = findViewById(R.id.b11);
            btn.setTextColor(Color.parseColor(board.getString(4) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(4));
            lastMove = btn;

        } else if (v.getId() == R.id.b12 && board.getStateAt(5) == State.BLANK) {
            board.move(5);
            btn = findViewById(R.id.b12);
            btn.setTextColor(Color.parseColor(board.getString(5) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(5));
            lastMove = btn;

        } else if (v.getId() == R.id.b20 && board.getStateAt(6) == State.BLANK) {
            board.move(6);
            btn = findViewById(R.id.b20);
            btn.setTextColor(Color.parseColor(board.getString(6) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(6));
            lastMove = btn;

        } else if (v.getId() == R.id.b21 && board.getStateAt(7) == State.BLANK) {
            board.move(7);
            btn = findViewById(R.id.b21);
            btn.setTextColor(Color.parseColor(board.getString(7) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(7));
            lastMove = btn;

        } else if (v.getId() == R.id.b22 && board.getStateAt(8) == State.BLANK) {
            board.move(8);
            btn = findViewById(R.id.b22);
            btn.setTextColor(Color.parseColor(board.getString(8) == "x" ? "#FFFF4081" : "#FF3F51B5"));
            btn.setText(board.getString(8));
            lastMove = btn;
        }
        //Gets random position:
       if (easy && randomMethodsTurn && !board.gameCompleted()){
           randomAgent();
       }
       randomMethodsTurn = true;

        if (board.gameCompleted()){
            board.newGame();
        }

    }
    public void undoMove(View v){
        board.undoMove();
        lastMove.setText("");
    }
    public void reset(View v){
        reset();
    }

    public void reset(){
        board.resetBoard();
        board.restGui();
    }



    public void randomAgent(){

        /*try {
            TimeUnit.SECONDS.sleep(1);
        }catch (InterruptedException e){
            
        }
        */
        randomMethodsTurn = false;
        Random rand = new Random();

        //This block keeps generating random positions until it gets a blank space:
        int randomizedMove;
        boolean unusedSpace = false;
        do {
            randomizedMove = rand.nextInt(9);
            if (board.getStateAt(randomizedMove) == State.BLANK){
                unusedSpace = true;
            }
        } while(!unusedSpace);
        //This block calls the makeMove method to put the "O" on the screen:
        if (randomizedMove == 0){
            makeMove(findViewById(R.id.b00));
        } else if (randomizedMove == 1){
            makeMove(findViewById(R.id.b01));
        } else if (randomizedMove == 2){
            makeMove(findViewById(R.id.b02));
        } else if (randomizedMove == 3){
            makeMove(findViewById(R.id.b10));
        } else if (randomizedMove == 4){
            makeMove(findViewById(R.id.b11));
        } else if (randomizedMove == 5){
            makeMove(findViewById(R.id.b12));
        } else if (randomizedMove == 6){
            makeMove(findViewById(R.id.b20));
        } else if (randomizedMove == 7){
            makeMove(findViewById(R.id.b21));
        } else if (randomizedMove == 8){
            makeMove(findViewById(R.id.b22));
        }
        randomMethodsTurn = false;
    }

    public void misereVersionMove(View v){
        if (v.getId() == R.id.b00 && board.getStateAt(0) == State.BLANK) {

            btn = findViewById(R.id.b00);
            btn.setText("X");
            lastMove = btn;
            board.move(0);
        } else if (v.getId() == R.id.b01 && board.getStateAt(1) == State.BLANK) {

            btn = findViewById(R.id.b01);
            btn.setText("X");
            lastMove = btn;
            board.move(1);
        } else if (v.getId() == R.id.b02 && board.getStateAt(2) == State.BLANK) {

            btn = findViewById(R.id.b02);
            btn.setText("X");
            lastMove = btn;
            board.move(2);
        } else if (v.getId() == R.id.b10 && board.getStateAt(3) == State.BLANK) {

            btn = findViewById(R.id.b10);
            btn.setText("X");
            lastMove = btn;
            board.move(3);
        } else if (v.getId() == R.id.b11 && board.getStateAt(4) == State.BLANK) {

            btn = findViewById(R.id.b11);
            btn.setText("X");
            lastMove = btn;
            board.move(4);
        } else if (v.getId() == R.id.b12 && board.getStateAt(5) == State.BLANK) {

            btn = findViewById(R.id.b12);
            btn.setText("X");
            lastMove = btn;
            board.move(5);
        } else if (v.getId() == R.id.b20 && board.getStateAt(6) == State.BLANK) {

            btn = findViewById(R.id.b20);
            btn.setText("X");
            lastMove = btn;
            board.move(6);
        } else if (v.getId() == R.id.b21 && board.getStateAt(7) == State.BLANK) {

            btn = findViewById(R.id.b21);
            btn.setText("X");
            lastMove = btn;
            board.move(7);
        } else if (v.getId() == R.id.b22 && board.getStateAt(8) == State.BLANK) {

            btn = findViewById(R.id.b22);
            btn.setText("X");
            lastMove = btn;
            board.move(8);
        }
    }


}