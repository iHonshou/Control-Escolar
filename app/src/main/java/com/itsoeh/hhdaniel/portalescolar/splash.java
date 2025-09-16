package com.itsoeh.hhdaniel.portalescolar;

import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link splash#newInstance} factory method to
 * create an instance of this fragment.
 */
public class splash extends Fragment {

    MediaPlayer sonido;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public splash() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment splash.
     */
    // TODO: Rename and change types and number of parameters
    public static splash newInstance(String param1, String param2) {
        splash fragment = new splash();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        new Handler(Looper.getMainLooper()).postDelayed(() -> {
            if (isAdded()) {
                NavHostFragment.findNavController(splash.this)
                        .navigate(R.id.action_splash_to_menu);//fragmen destino
            }
        }, 3000); // 5000 milisegundos = 3 segundos
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        ImageView logo = view.findViewById(R.id.logoImage);
        sonido = MediaPlayer.create(getContext(), R.raw.startup);
        sonido.start();
        logo.startAnimation(AnimationUtils.loadAnimation(getContext(), R.anim.fadein));

    }
}