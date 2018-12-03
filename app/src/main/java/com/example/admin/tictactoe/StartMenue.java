package com.example.admin.tictactoe;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;

public class StartMenue extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final Button Two_Player_Button, CPU_Hard_Button, CPU_Easy_Button;
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.activity_start_menue);
        Two_Player_Button = (Button) this.findViewById(R.id.Two_Player_Button);
        CPU_Hard_Button = (Button) this.findViewById(R.id.CPU_Hard_Button);
        CPU_Easy_Button = (Button) this.findViewById(R.id.CPU_Easy_Button);

        Two_Player_Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
               if(view == Two_Player_Button) {


            Intent intent = new Intent(StartMenue.this, MainActivity.class);

            startActivity(intent);

        }
    }

        });
    }

}
