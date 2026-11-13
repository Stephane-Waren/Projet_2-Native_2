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
}
