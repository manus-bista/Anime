package com.manush.animeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class AnimeInfo extends AppCompatActivity {

    ImageView img;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anime_info);

        img = findViewById(R.id.imgCircled);
        txt = findViewById(R.id.anime);

        Intent intent = getIntent();

        img.setImageResource(intent.getIntExtra("image",R.drawable.ic_launcher_foreground));
        txt.setText(intent.getStringExtra("name"));

    }
}