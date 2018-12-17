package com.example.jana.arenalikegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SkillsActivity extends AppCompatActivity {

    private Character player = new Character();
    private int points = 5;
    private TextView pointsText;
    private Button addStrBtn;
    private Button lowStrBtn;
    private Button addDexBtn;
    private Button lowDexBtn;
    private Button addVitBtn;
    private Button lowVitBtn;
    private Button addWpBtn;
    private Button lowWpBtn;
    private TextView strValText;
    private TextView dexValText;
    private TextView vitValText;
    private TextView wpValText;
    private Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        pointsText = (TextView) findViewById(R.id.pointsVal);
        addStrBtn = (Button) findViewById(R.id.addStr);
        lowStrBtn = (Button) findViewById(R.id.lowStr);
        addDexBtn = (Button) findViewById(R.id.addDex);
        lowDexBtn = (Button) findViewById(R.id.lowDex);
        addVitBtn = (Button) findViewById(R.id.addVit);
        lowVitBtn = (Button) findViewById(R.id.lowVit);
        addWpBtn = (Button) findViewById(R.id.addWp);
        lowWpBtn = (Button) findViewById(R.id.lowWp);
        strValText = (TextView) findViewById(R.id.strVal);
        dexValText = (TextView) findViewById(R.id.dexVal);
        vitValText = (TextView) findViewById(R.id.vitVal);
        wpValText = (TextView) findViewById(R.id.wpVal);
        confirmBtn = (Button) findViewById(R.id.confirm);

        pointsText.setText(Integer.toString(points));

        addStrBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             player.setStrenght(player.getStrenght()+1);
                                             strValText.setText(Integer.toString(player.getStrenght()));
                                             points--;
                                             pointsText.setText(Integer.toString(points));
                                             if(points==0)
                                                 disablePointsAdding();
                                         }
                                     }
        );

        lowStrBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             player.setStrenght(player.getStrenght()-1);
                                             strValText.setText(Integer.toString(player.getStrenght()));
                                             points++;
                                             pointsText.setText(Integer.toString(points));
                                             if(points>0)
                                                 enablePointsAdding();
                                         }
                                     }
        );

        addDexBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             player.setDexterity(player.getDexterity()+1);
                                             dexValText.setText(Integer.toString(player.getDexterity()));
                                             points--;
                                             pointsText.setText(Integer.toString(points));
                                             if(points==0)
                                                 disablePointsAdding();
                                         }
                                     }
        );

        lowDexBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             player.setDexterity(player.getDexterity()-1);
                                             dexValText.setText(Integer.toString(player.getDexterity()));
                                             points++;
                                             pointsText.setText(Integer.toString(points));
                                             if(points>0)
                                                 enablePointsAdding();
                                         }
                                     }
        );

        addVitBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             player.setVitality(player.getVitality()+1);
                                             vitValText.setText(Integer.toString(player.getVitality()));
                                             points--;
                                             pointsText.setText(Integer.toString(points));
                                             if(points==0)
                                                 disablePointsAdding();
                                         }
                                     }
        );

        lowVitBtn.setOnClickListener(new View.OnClickListener() {
                                         @Override
                                         public void onClick(View v) {
                                             player.setVitality(player.getVitality()-1);
                                             vitValText.setText(Integer.toString(player.getVitality()));
                                             points++;
                                             pointsText.setText(Integer.toString(points));
                                             if(points>0)
                                                 enablePointsAdding();
                                         }
                                     }
        );

        addWpBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            player.setSilaVule(player.getSilaVule()+1);
                                            wpValText.setText(Integer.toString(player.getSilaVule()));
                                            points--;
                                            pointsText.setText(Integer.toString(points));
                                            if(points==0)
                                                disablePointsAdding();
                                        }
                                    }
        );

        lowWpBtn.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {
                                            player.setSilaVule(player.getSilaVule()-1);
                                            wpValText.setText(Integer.toString(player.getSilaVule()));
                                            points++;
                                            pointsText.setText(Integer.toString(points));
                                            if(points>0)
                                                enablePointsAdding();
                                        }
                                    }
        );

        confirmBtn.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              startActivity(new Intent(SkillsActivity.this, LevelsActivity.class));
                                          }
                                      }

        );
    }

    private void disablePointsAdding() {
        addStrBtn.setEnabled(false);
        addDexBtn.setEnabled(false);
        addVitBtn.setEnabled(false);
        addWpBtn.setEnabled(false);
    }

    private void enablePointsAdding() {
        addStrBtn.setEnabled(true);
        addDexBtn.setEnabled(true);
        addVitBtn.setEnabled(true);
        addWpBtn.setEnabled(true);
    }
}
