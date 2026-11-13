package com.example.projet_2;

import android.content.ContentResolver;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Size;

import java.io.IOException;
import java.util.List;

public class MediaAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<Media> listeMedias;
    private static final int TYPE_VIDEO = 0;
    private static final int TYPE_AUDIO = 1;


    public MediaAdapter(List<Media> listeMedias) {
        this.listeMedias = listeMedias;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == TYPE_VIDEO) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_video, parent, false);
            return new VideoViewHolder(view);
        } else {
            View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_audio, parent, false);
            return new AudioViewHolder(view2);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Media media = listeMedias.get(position);
        if (media instanceof Audio) {
            AudioViewHolder holder1 = (AudioViewHolder) holder;
            holder1.titreAudio.setText(((Audio) media).getTitre());
            holder1.nomArtiste.setText(((Audio) media).getNomArtiste());
        } else {
            VideoViewHolder holder2 = (VideoViewHolder) holder;
            holder2.nomVideo.setText(media.getNom());
            holder2.dureeVideo.setText(String.valueOf(media.getDuree()));
            holder2.image.setImageResource(R.drawable.ic_launcher_foreground);

            try {
                ContentResolver guichet = holder.itemView.getContext().getContentResolver();
                Bitmap miniature = guichet.loadThumbnail(media.getUri(), new Size(320, 180), null);
                holder2.image.setImageBitmap(miniature);

            } catch (IOException e) {

            }
        }
    }

    @Override
    public int getItemViewType(int position) {
        Media media = listeMedias.get(position);
        if (media instanceof Audio) {
            return TYPE_AUDIO;
        }
        return TYPE_VIDEO;
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

    public static class AudioViewHolder extends RecyclerView.ViewHolder {
        ImageView icone;
        TextView titreAudio;
        TextView nomArtiste;

        public AudioViewHolder(@NonNull View itemView) {
            super(itemView);
            icone = itemView.findViewById(R.id.iconeAudio);
            titreAudio = itemView.findViewById(R.id.titreAudio);
            nomArtiste = itemView.findViewById(R.id.nomArtiste);

        }
    }

}
