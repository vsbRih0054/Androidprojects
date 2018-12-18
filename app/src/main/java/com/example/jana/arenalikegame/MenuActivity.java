package com.example.jana.arenalikegame;

import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ConstraintLayout layout = findViewById(R.id.consLayout);
        Button continueBtn = (Button) findViewById(R.id.contBtn);
        Button newGameBtn = (Button) findViewById(R.id.newGame);
        Button exitGamebtn = (Button) findViewById(R.id.exitGame);

        continueBtn.setOnClickListener(new View.OnClickListener() {
                                           @Override
                                           public void onClick(View v) {
                                               try {
                                                   FileInputStream fis = openFileInput("data.txt");
                                                   ObjectInputStream is = new ObjectInputStream(fis);
                                                   Character character = (Character) is.readObject();
                                                   is.close();
                                                   fis.close();
                                                   Intent intent = new Intent(MenuActivity.this, LevelsActivity.class);
                                                   intent.putExtra("serialize_data", character);
                                                   startActivity(intent);
                                               } catch (IOException e1) {
                                               } catch (ClassNotFoundException e) {
                                                   e.printStackTrace();
                                               }
                                           }
                                       }
        );

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
