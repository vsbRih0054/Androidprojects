package com.example.jana.arenalikegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button newGameBtn = (Button) findViewById(R.id.newGame);
        Button exitGamebtn = (Button) findViewById(R.id.exitGame);

        newGameBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(new Intent(MenuActivity.this, SkillsActivity.class));
                }
            }
        );

        exitGamebtn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              finish();
                                              System.exit(0);
                                          }
                                      }
        );
    }

}
