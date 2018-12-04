package com.example.admin.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.time.chrono.Chronology;

public class StartMenue extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Button Two_Player_Button, CPU_Hard_Button, CPU_Easy_Button;
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_start_menue);
        Two_Player_Button = (Button) this.findViewById(R.id.Two_Player_Button);
        CPU_Hard_Button = (Button) this.findViewById(R.id.CPU_Hard_Button);
        CPU_Easy_Button = (Button) this.findViewById(R.id.CPU_Easy_Button);
    }

    public void onClickGameModeSelector(View view){
       //for debuging
        // Toast.makeText(getApplicationContext(), "Buttone Clicked", Toast.LENGTH_SHORT).show();

        Intent intent = new Intent(StartMenue.this, MainActivity.class);
        intent.putExtra("gameMode",getResources().getResourceEntryName(view.getId()));
        startActivity(intent);
    }



    }
