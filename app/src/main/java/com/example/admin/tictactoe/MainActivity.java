package com.example.admin.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //for testing purposes
    //TextView btn;
    boolean easy;
    boolean hard;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //for testing purposes
        btn = findViewById(R.id.b00);

    }

    //for testing purposes
    /*public void makeMove(View v) {
        btn.setText("X");
    } */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options_menu, menu);
        menu.setGroupCheckable(1,true, true);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.easyLevel:
                easy = true;
                return true;
            case R.id.hardLevel:
                hard = true;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    Board board = new Board(State.O);
    TextView btn;

    public void makeMove0(View v) {
        board.move(0);
        btn = findViewById(R.id.b00);
        btn.setText(board.getString(0));
    }

    public void makeMove1(View v) {
        board.move(1);
        btn = findViewById(R.id.b01);
        btn.setText(board.getString(1));
    }

    public void makeMove2(View v) {
        board.move(2);
        btn = findViewById(R.id.b02);
        btn.setText(board.getString(2));
    }

    public void makeMove3(View v) {
        board.move(3);
        btn = findViewById(R.id.b10);
        btn.setText(board.getString(3));
    }

    public void makeMove4(View v) {
        board.move(4);
        btn = findViewById(R.id.b11);
        btn.setText(board.getString(4));
    }

    public void makeMove5(View v) {
        board.move(5);
        btn = findViewById(R.id.b12);
        btn.setText(board.getString(5));
    }

    public void makeMove6(View v) {
        board.move(6);
        btn = findViewById(R.id.b20);
        btn.setText(board.getString(6));
    }

    public void makeMove7(View v) {
        board.move(7);
        btn = findViewById(R.id.b21);
        btn.setText(board.getString(7));
    }

    public void makeMove8(View v) {
        board.move(8);
        btn = findViewById(R.id.b22);
        btn.setText(board.getString(8));
    }

}