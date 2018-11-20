package com.example.admin.tictactoe;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //for testing purposes
    //TextView btn;
    boolean easy;
    boolean hard;
    Board board = new Board(State.X, this, this);
    TextView btn;
    TextView lastMove;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        menu.setGroupCheckable(1, true, true);
        menu.setGroupCheckable(0, true, true);
        menu.getItem(1).setChecked(true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.easyLevel:
                easy = true;
                item.setChecked(true);
                return true;
            case R.id.hardLevel:
                hard = true;
                item.setChecked(true);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void makeMove(View v) {
        if (v.getId() == R.id.b00 && board.getStateAt(0) == State.BLANK) {
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
    }
    public void undoMove(View v){
        board.undoMove();
        lastMove.setText("");
    }
    public void reset(View v){
        board.resetBoard();
        board.restGui();
    }
}