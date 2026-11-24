package com.example.projet_2;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;

public class LecteurActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lecteur);
        MaterialToolbar toolbar = findViewById(R.id.toolbarLecteur);
        toolbar.setTitle(getIntent().getStringExtra("nom"));
        toolbar.setNavigationOnClickListener(v -> finish());
    }
}
