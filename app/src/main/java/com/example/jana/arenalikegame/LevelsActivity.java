package com.example.jana.arenalikegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LevelsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        Character character = (Character) getIntent().getSerializableExtra("serialize_data");

        TextView nameText = (TextView) findViewById(R.id.Name);
        nameText.setText(character.getName());
    }
}
