package com.example.jana.arenalikegame;

import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Document;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class BattleActivity extends AppCompatActivity {

    private Character selectedAlly;
    private Character selectedEnemy;
    private Character player;
    private Character enemy1 = new Character("Enemy1", "Warrior", "hostile",4, 3, 4, 3, new Dice(12));
    private Character enemy2 = new Character("Enemy2", "Rogue", "hostile",3, 4, 3, 4, new Dice(12));
    private Character ally = new Character("Ally", "Warrior", "friendly",4, 3, 4, 3, new Dice(12));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);


        player = (Character) getIntent().getSerializableExtra("serialize_data");

        final TextView name0txt = (TextView) findViewById(R.id.name0);
        final TextView health0txt = (TextView) findViewById(R.id.health0);
        final TextView stamina0txt = (TextView) findViewById(R.id.stamina0);
        final TextView name1txt = (TextView) findViewById(R.id.name1);
        final TextView health1txt = (TextView) findViewById(R.id.health1);
        final TextView stamina1txt = (TextView) findViewById(R.id.stamina1);
        final TextView name2txt = (TextView) findViewById(R.id.name2);
        final TextView health2txt = (TextView) findViewById(R.id.health2);
        final TextView stamina2txt = (TextView) findViewById(R.id.stamina2);
        final TextView name3txt = (TextView) findViewById(R.id.name3);
        final TextView health3txt = (TextView) findViewById(R.id.health3);
        final TextView stamina3txt = (TextView) findViewById(R.id.stamina3);

        name0txt.setText(player.getName());
        health0txt.setText(player.getHealth()+"/"+player.getMaxZdravi());
        stamina0txt.setText(player.getVydrzMana()+"/" + player.getMaxVydrzMana());
        name1txt.setText(ally.getName());
        health1txt.setText(ally.getHealth()+"/"+ally.getMaxZdravi());
        stamina1txt.setText(ally.getVydrzMana()+"/"+ally.getMaxVydrzMana());
        name2txt.setText(enemy1.getName());
        health2txt.setText(enemy1.getHealth()+"/"+enemy1.getMaxZdravi());
        stamina2txt.setText(enemy1.getVydrzMana()+"/"+enemy1.getMaxVydrzMana());
        name3txt.setText(enemy2.getName());
        health3txt.setText(enemy2.getHealth()+"/"+enemy2.getMaxZdravi());
        stamina3txt.setText(enemy2.getVydrzMana()+"/"+enemy2.getMaxVydrzMana());

        selectedAlly = player;
        selectedEnemy = enemy1;

        Button attackbtn = (Button) findViewById(R.id.attackbtn);
        attackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAlly.attack(selectedEnemy);
                selectedEnemy.attack(selectedAlly);
                if(selectedEnemy.getName() == "Enemy1")
                    health2txt.setText(enemy1.getHealth()+"/"+enemy1.getMaxZdravi());
                else
                    health3txt.setText(enemy2.getHealth()+"/"+enemy2.getMaxZdravi());

                if( selectedAlly.getName() == "Ally")
                    health1txt.setText(ally.getHealth()+"/"+ally.getMaxZdravi());
                else
                    health0txt.setText(player.getHealth()+"/"+player.getMaxZdravi());
            }
        });

        final ImageView image0 = (ImageView) findViewById(R.id.image0);
        final ImageView image1 = (ImageView) findViewById(R.id.image1);
        final ImageView image2 = (ImageView) findViewById(R.id.image2);
        final ImageView image3 = (ImageView) findViewById(R.id.image3);
        final TextView selectallytxt = (TextView) findViewById(R.id.selectAlly);
        final TextView selectenemytxt = (TextView) findViewById(R.id.selectEnemy);
        selectallytxt.setText(selectedAlly.getName());
        selectenemytxt.setText(selectedEnemy.getName());

        image0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAlly=player;
                selectallytxt.setText(selectedAlly.getName());
            }
        });

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedAlly=ally;
                selectallytxt.setText(selectedAlly.getName());
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedEnemy=enemy1;
                selectenemytxt.setText(selectedEnemy.getName());
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                selectedEnemy=enemy2;
                selectenemytxt.setText(selectedEnemy.getName());
            }
        });

    }
}
