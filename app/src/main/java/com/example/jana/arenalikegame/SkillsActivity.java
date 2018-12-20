package com.example.jana.arenalikegame;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SkillsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private int points = 20;

    private String charclas;
    private int str = 0;
    private int dex = 0;
    private int vit = 0;
    private int will = 0;

    private EditText charNameEdit;
    private Spinner charClassesSpinr;
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

        charNameEdit = (EditText) findViewById(R.id.charName);

        List<String> spinnerArray =  new ArrayList<String>();
        spinnerArray.add("Warrior");
        spinnerArray.add("Rogue");
        spinnerArray.add("Mage");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(
                this, android.R.layout.simple_spinner_item, spinnerArray);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        charClassesSpinr = (Spinner) findViewById(R.id.charClasses);
        charClassesSpinr.setAdapter(adapter);
        charClassesSpinr.setOnItemSelectedListener(this);


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
                                             str+=1;
                                             strValText.setText(Integer.toString(str));
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
                                             str -= 1;
                                             strValText.setText(Integer.toString(str));
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
                                             dex += 1;
                                             dexValText.setText(Integer.toString(dex));
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
                                             dex -= 1;
                                             dexValText.setText(Integer.toString(dex));
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
                                             vit += 1;
                                             vitValText.setText(Integer.toString(vit));
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
                                             vit -= 1;
                                             vitValText.setText(Integer.toString(vit));
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
                                            will += 1;
                                            wpValText.setText(Integer.toString(will));
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
                                            will -= 1;
                                            wpValText.setText(Integer.toString(will));
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
                                              Character player = new Character(charNameEdit.getText().toString(), charclas, "friendly",str, dex, vit, will, new Dice(12));
                                              try {
                                                  FileOutputStream fos = openFileOutput("data.txt", Context.MODE_PRIVATE);
                                                  ObjectOutputStream os = new ObjectOutputStream(fos);
                                                  os.writeObject(player);
                                                  os.close();
                                                  fos.close();
                                              }
                                              catch(IOException e1) {

                                              }

                                              Intent intent = new Intent(SkillsActivity.this, LevelsActivity.class);
                                              intent.putExtra("serialize_data",player);
                                              startActivity(intent);
                                          }
                                      }

        );
    }

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        // An item was selected. You can retrieve the selected item using
        //parent.getItemAtPosition(pos)
        charclas = charClassesSpinr.getSelectedItem().toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {
        // Another interface callback
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
