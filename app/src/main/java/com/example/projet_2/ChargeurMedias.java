package com.example.projet_2;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;

import java.util.ArrayList;

public class ChargeurMedias {
    private final Context contexte;

    public ChargeurMedias(Context contexte) {
        this.contexte = contexte;
    }

    public ArrayList<Media> chargerVideos() {
        Uri uriTab = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        ArrayList<Media> listeVideos = new ArrayList<>();
        String[] colonnes = new String[3];

        colonnes[0] = MediaStore.Video.Media._ID;
        colonnes[1] = MediaStore.Video.Media.DISPLAY_NAME;
        colonnes[2] = MediaStore.Video.Media.DURATION;
        String tri = MediaStore.Video.Media.DISPLAY_NAME + " ASC";

        ContentResolver guichet = contexte.getContentResolver();
        try (Cursor curseur = guichet.query(uriTab, colonnes, null, null, tri)) {
            if (curseur == null) {
                return listeVideos;
            }
            int colonneNom = curseur.getColumnIndexOrThrow(MediaStore.Video.Media.DISPLAY_NAME);
            int colonneID = curseur.getColumnIndexOrThrow(MediaStore.Video.Media._ID);
            int colonneDuree = curseur.getColumnIndexOrThrow(MediaStore.Video.Media.DURATION);
            while (curseur.moveToNext()) {
                long id = curseur.getLong(colonneID);
                String nom = curseur.getString(colonneNom);
                long duree = curseur.getLong(colonneDuree);
                Uri uri = ContentUris.withAppendedId(uriTab, id);
                listeVideos.add(new Video(nom, duree, uri));
            }

        }
        return listeVideos;
    }

    public ArrayList<Media> chargerAudios() {
        ArrayList<Media> listeAudios = new ArrayList<>();
        Uri uriTab = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        String parMusic = MediaStore.Audio.Media.IS_MUSIC + " != 0";

        String[] colonnes = new String[]{
                MediaStore.Audio.Media._ID,
                MediaStore.Audio.Media.DISPLAY_NAME,
                MediaStore.Audio.Media.DURATION,
                MediaStore.Audio.Media.TITLE,
                MediaStore.Audio.Media.ARTIST
        };
        String tri = MediaStore.Audio.Media.DISPLAY_NAME + " ASC";
        try (Cursor curseur = contexte.getContentResolver().query(uriTab, colonnes, parMusic, null, tri)) {
            if (curseur == null) {
                return listeAudios;
            }
            int colonneNom = curseur.getColumnIndexOrThrow(MediaStore.Audio.Media.DISPLAY_NAME);
            int colonneID = curseur.getColumnIndexOrThrow(MediaStore.Audio.Media._ID);
            int colonneDuree = curseur.getColumnIndexOrThrow(MediaStore.Audio.Media.DURATION);
            int colonneTitre = curseur.getColumnIndexOrThrow(MediaStore.Audio.Media.TITLE);
            int colonneArtiste = curseur.getColumnIndexOrThrow(MediaStore.Audio.Media.ARTIST);

            while (curseur.moveToNext()) {
                long id = curseur.getLong(colonneID);
                String nom = curseur.getString(colonneNom);
                long duree = curseur.getLong(colonneDuree);
                String titre = curseur.getString(colonneTitre);
                String artiste = curseur.getString(colonneArtiste);
                Uri uri = ContentUris.withAppendedId(uriTab, id);
                listeAudios.add(new Audio(nom, duree, uri, artiste, titre));

            }
        }
        return listeAudios;

    }
}
