package com.example.admin.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class StartMenu extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_start_menu);
    }

    public void onClickGameModeSelector(View view){
       //for debuging
        // Toast.makeText(getApplicationContext(), "Button Clicked", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(StartMenu.this, MainActivity.class);
        intent.putExtra("gameMode",getResources().getResourceEntryName(view.getId()));
        startActivity(intent);

        switch (view.getId()) {
            case R.id.CPU_Hard:
                //Not implemented yet
                break;
            case R.id.CPU_Easy:
                MainActivity.miseryVersion = false;
                MainActivity.easy = true;
                MainActivity.hard = false;
                break;
            case R.id.Two_Player:
                MainActivity.miseryVersion = false;
                MainActivity.easy = false;
                MainActivity.hard = false;
                break;
            case R.id.Two_Player_Misery:
                MainActivity.miseryVersion = true;
                MainActivity.easy = false;
                MainActivity.hard = false;
                break;
            case R.id.CPU_Misery:
                //Not implemented yet
                break;
        }
    }



    }
