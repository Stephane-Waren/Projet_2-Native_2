package com.example.projet_2;

import android.net.Uri;

public abstract class Media {
    private final String nom;
    private final long duree;
    private final Uri uri;

    public Media(String nom, long duree, Uri uri) {
        this.nom = nom;
        this.duree = duree;
        this.uri = uri;
    }

    public String getNom() {
        return nom;
    }

    public long getDuree() {
        return duree;
    }

    public Uri getUri() {
        return uri;
    }

}
