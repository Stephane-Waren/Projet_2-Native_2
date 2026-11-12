package com.example.projet_2;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

/**
 * Responsable de l'interface sous l'onglet recent
 */
public class RecentFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_recent, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerRecent = view.findViewById(R.id.recyclerRecent);
        ArrayList<Media> listeMedias = new ArrayList<>();
        listeMedias.add(new Audio("Audio1", 20000L, Uri.EMPTY, "Ninho", "Filon"));
        listeMedias.add(new Audio("Audio1", 20000L, Uri.EMPTY, "Ninho", "Filon"));
        listeMedias.add(new Audio("Audio1", 20000L, Uri.EMPTY, "Ninho", "Filon"));
        listeMedias.add(new Video("Batman vs Superman", 22000L, Uri.EMPTY));
        listeMedias.add(new Video("Batman vs Superman", 22000L, Uri.EMPTY));
        listeMedias.add(new Video("Batman vs Superman", 22000L, Uri.EMPTY));

        MediaAdapter mediaAdapter = new MediaAdapter(listeMedias);
        recyclerRecent.setLayoutManager( new LinearLayoutManager(requireContext()));
        recyclerRecent.setAdapter(mediaAdapter);
    }
}
