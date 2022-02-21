package com.manush.animeapp;

import android.content.Context;
import android.icu.text.Transliterator;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AnimeAdapter extends RecyclerView.Adapter<AnimeAdapter.AnimeRowHolder>{

    ArrayList<Anime> animeData;
    Context context;
    MyCLickInterface  myCLickInterface;

    public AnimeAdapter(ArrayList<Anime> animeData,Context context, MyCLickInterface myCLickInterface){
        this.context = context;
        this.animeData = animeData;
        this.myCLickInterface = myCLickInterface;
    }

    @NonNull
    @Override
    public AnimeRowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.anime_row,parent,false);
        return new AnimeRowHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimeRowHolder holder, int position) {
        holder.txtAnimeName.setText(animeData.get(position).getName());
        holder.imgAnime.setImageResource(animeData.get(position).getImage());

    }

    @Override
    public int getItemCount() {
        return animeData.size();
    }

    class AnimeRowHolder extends RecyclerView.ViewHolder{

        TextView txtAnimeName;
        ImageView imgAnime;
        public AnimeRowHolder(@NonNull View itemView) {
            super(itemView);

            txtAnimeName = itemView.findViewById(R.id.txt_anime_name);
            imgAnime = itemView.findViewById(R.id.img_anime);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    myCLickInterface.onItemClick(getAdapterPosition());
                }
            });
        }
    }

    interface MyCLickInterface{
        void onItemClick(int positionOfTheAnime);
    }

}
