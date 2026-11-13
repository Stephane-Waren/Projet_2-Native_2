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
 * Responsable de l'interface sous l'onglet video
 */
public class VideoFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_video, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerVideo = view.findViewById(R.id.recyclerVideo);

        ChargeurMedias chargeurVideo = new ChargeurMedias(requireContext());
        ArrayList<Media> listeVideos = chargeurVideo.chargerVideos();

        MediaAdapter mediaAdapter = new MediaAdapter(listeVideos);
        recyclerVideo.setLayoutManager( new LinearLayoutManager(requireContext()));
        recyclerVideo.setAdapter(mediaAdapter);


    }
}

