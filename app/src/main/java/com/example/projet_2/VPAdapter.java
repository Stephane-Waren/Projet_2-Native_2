package com.example.projet_2;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.ArrayList;

public class VPAdapter extends FragmentStateAdapter {

    private final ArrayList<String> fragmentTitreList = new ArrayList<>();

    public VPAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        fragmentTitreList.add("Recents");
        fragmentTitreList.add("Video");
        fragmentTitreList.add("Audio");
    }

    public String getTitre(int position) {
        return fragmentTitreList.get(position);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {

            case 1:
                return new VideoFragment();
            case 2:
                return new AudioFragment();
            default:
                return new RecentFragment();
        }

    }

    @Override
    public int getItemCount() {
        return fragmentTitreList.size();
    }
}