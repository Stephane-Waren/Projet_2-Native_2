package com.example.projet_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<MediaAdapter.VideoViewHolder> {

    private List<Media> listeMedias;

    public MediaAdapter(List<Media> listeMedias) {
        this.listeMedias = listeMedias;
    }

    @NonNull
    @Override
    public VideoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);

        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VideoViewHolder holder, int position) {
        Media media = listeMedias.get(position);
        holder.nomVideo.setText(media.getNom());
        holder.dureeVideo.setText(String.valueOf(media.getDuree()));
    }

    @Override
    public int getItemCount() {
        return listeMedias.size();
    }

    public static class VideoViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView nomVideo;
        TextView dureeVideo;

        public VideoViewHolder(@NonNull View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.imageVideo);
            nomVideo = itemView.findViewById(R.id.nomVideo);
            dureeVideo = itemView.findViewById(R.id.dureeVideo);
        }
    }
}
