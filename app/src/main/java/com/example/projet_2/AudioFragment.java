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
 * Responsable de l'interface sous l'onglet audio
 */
public class AudioFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_audio, container, false);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RecyclerView recyclerAudio = view.findViewById(R.id.recyclerAudio);
        ChargeurMedias chargeurMedias = new ChargeurMedias(requireContext());
        ArrayList<Media> listeAudio = chargeurMedias.chargerAudios();

        MediaAdapter adapterAudio = new MediaAdapter(listeAudio);
        recyclerAudio.setLayoutManager(new LinearLayoutManager(requireContext()));
        recyclerAudio.setAdapter(adapterAudio);
    }
}
