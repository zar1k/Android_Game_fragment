package com.andreyzarazka.babygame.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.andreyzarazka.babygame.R;
import com.purplebrain.adbuddiz.sdk.AdBuddiz;

public class AnimalsFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Показ рекламмы
        AdBuddiz.showAd(getActivity());

        return inflater.inflate(R.layout.fragment_animals, container, false);
    }
}
