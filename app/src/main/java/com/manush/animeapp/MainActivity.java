package com.manush.animeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AnimeAdapter.MyCLickInterface {

    RecyclerView recyclerView;
    ArrayList<Anime> anime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycle_view);

        anime = new ArrayList<>();

        anime.add(new Anime("Hunter X Hunter",R.drawable.hxh));
        anime.add(new Anime("My Hero Academia",R.drawable.mha));
        anime.add(new Anime("Attack On Titan",R.drawable.aott));
        anime.add(new Anime("DeathNote",R.drawable.dn));
        anime.add(new Anime("Sword Art Online",R.drawable.sao));
        anime.add(new Anime("Bleach",R.drawable.blch));
        anime.add(new Anime("Naruto",R.drawable.naru));
        anime.add(new Anime("One Piece",R.drawable.luffy));
        anime.add(new Anime("Your Name",R.drawable.yn));

        AnimeAdapter animeAdapter = new AnimeAdapter(anime,this,this);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(animeAdapter);
    }

    @Override
    public void onItemClick(int positionOfTheAnime) {
        Toast.makeText(this,"BOOM!"+ anime.get(positionOfTheAnime).getName(),Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this,AnimeInfo.class);
        intent.putExtra("image",anime.get(positionOfTheAnime).getImage());
        intent.putExtra("name",anime.get(positionOfTheAnime).getName());
        startActivity(intent);
    }
}