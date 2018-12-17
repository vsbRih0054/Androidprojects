package com.example.jana.arenalikegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SkillsActivity extends AppCompatActivity {

    Character player = new Character();
    private int points = 1;
    Button addStrBtn = (Button) findViewById(R.id.addStr);
    Button lowStrBtn = (Button) findViewById(R.id.lowStr);
    Button addDexBtn = (Button) findViewById(R.id.addDex);
    Button lowDexBtn = (Button) findViewById(R.id.lowDex);
    Button addVitBtn = (Button) findViewById(R.id.addVit);
    Button lowVitBtn = (Button) findViewById(R.id.lowVit);
    Button addWpBtn = (Button) findViewById(R.id.addWp);
    Button lowWpBtn = (Button) findViewById(R.id.lowWp);
    TextView strValText = findViewById(R.id.strVal);
    TextView dexValText = findViewById(R.id.dexVal);
    TextView vitValText = findViewById(R.id.vitVal);
    TextView wpValText = findViewById(R.id.wpVal);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skills);

        addStrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setStrenght(player.getStrenght()-1);
                strValText.setText(player.getStrenght());
                points--;
                if(points==0)
                    disablePointsAdding();
            }
        }
        );

        lowStrBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setStrenght(player.getStrenght()+1);
                strValText.setText(player.getStrenght());
                points++;
                if(points>0)
                   enablePointsAdding();
            }
        }
        );

        addDexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setDexterity(player.getDexterity()-1);
                dexValText.setText(player.getDexterity());
                points--;
                if(points==0)
                    disablePointsAdding();
                }
        }
        );

        lowDexBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setDexterity(player.getDexterity()+1);
                dexValText.setText(player.getDexterity());
                points++;
                if(points>0)
                    enablePointsAdding();
            }
        }
        );

        addVitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setVitality(player.getVitality()-1);
                vitValText.setText(player.getVitality());
                points--;
                if(points==0)
                    disablePointsAdding();
                }
        }
        );

        lowVitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setVitality(player.getVitality()+1);
                vitValText.setText(player.getVitality());
                points++;
                if(points>0)
                    enablePointsAdding();
                }
        }
        );

        addWpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setSilaVule(player.getSilaVule()-1);
                vitValText.setText(player.getSilaVule());
                points--;
                if(points==0)
                    disablePointsAdding();
                }
        }
        );

        lowWpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.setSilaVule(player.getSilaVule()-1);
                vitValText.setText(player.getSilaVule());
                points++;
                if(points>0)
                    enablePointsAdding();
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
