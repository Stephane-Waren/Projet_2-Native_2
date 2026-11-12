package com.example.projet_2;

import android.net.Uri;

public class Audio extends Media {
    private String nomArtiste;
    private String titre;

    public Audio(String nom, long duree, Uri uri, String nomArtiste, String titre) {
        super(nom, duree, uri);
        this.nomArtiste = nomArtiste;
        this.titre = titre;
    }

    public String getNomArtiste() {
        return nomArtiste;
    }

    public String getTitre() {
        return titre;
    }
}
