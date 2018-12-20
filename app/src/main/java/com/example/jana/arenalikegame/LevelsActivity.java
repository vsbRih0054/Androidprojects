package com.example.jana.arenalikegame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class LevelsActivity extends AppCompatActivity {

    private Character player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_levels);

        player = (Character) getIntent().getSerializableExtra("serialize_data");

        TextView nameText = (TextView) findViewById(R.id.Name);
        nameText.setText(player .getName());

        Button level1btn = (Button) findViewById(R.id.level1btn);
        level1btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LevelsActivity.this, BattleActivity.class);
                intent.putExtra("serialize_data",player);
                startActivity(intent);
            }
        });
    }
}
