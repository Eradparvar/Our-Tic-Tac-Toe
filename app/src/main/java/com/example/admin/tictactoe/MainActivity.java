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
    Board board = new Board(State.X);
    TextView btn;

    public void makeMove(View v){
        if (v.getId() == R.id.b00 && board.getStateAt(0) == State.BLANK){
            board.move(0);
            btn = findViewById(R.id.b00);
            btn.setText(board.getString(0));
        } else if (v.getId() == R.id.b01 && board.getStateAt(1) == State.BLANK){
            board.move(1);
            btn = findViewById(R.id.b01);
            btn.setText(board.getString(1));
        } else if (v.getId() == R.id.b02 && board.getStateAt(2) == State.BLANK){
            board.move(2);
            btn = findViewById(R.id.b02);
            btn.setText(board.getString(2));
        } else if (v.getId() == R.id.b10 && board.getStateAt(3) == State.BLANK){
            board.move(3);
            btn = findViewById(R.id.b10);
            btn.setText(board.getString(3));
        } else if (v.getId() == R.id.b11 && board.getStateAt(4) == State.BLANK){
            board.move(4);
            btn = findViewById(R.id.b11);
            btn.setText(board.getString(4));
        } else if (v.getId() == R.id.b12 && board.getStateAt(5) == State.BLANK){
            board.move(5);
            btn = findViewById(R.id.b12);
            btn.setText(board.getString(5));
        } else if (v.getId() == R.id.b20 && board.getStateAt(6) == State.BLANK) {
            board.move(6);
            btn = findViewById(R.id.b20);
            btn.setText(board.getString(6));
        } else if (v.getId() == R.id.b21 && board.getStateAt(7) == State.BLANK) {
            board.move(7);
            btn = findViewById(R.id.b21);
            btn.setText(board.getString(7));
        } else if (v.getId() == R.id.b22 && board.getStateAt(8) == State.BLANK) {
            board.move(8);
            btn = findViewById(R.id.b22);
            btn.setText(board.getString(8));
        }
     }

}
