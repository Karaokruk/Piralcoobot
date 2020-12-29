package com.kruk.piralcoobot;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

public class Play extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.play_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_add_pirate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(Play.this)
                        .navigate(R.id.action_playFragment_to_homeFragment);
            }
        });

        view.findViewById(R.id.start_game_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add players
                EditText editText = getView().findViewById(R.id.PirateName1);
                String player = editText.getText().toString();

                NavController navController = NavHostFragment.findNavController(Play.this);
                NavDestination destination = navController.getGraph().findNode(R.id.gameFragment);

                Bundle b = new Bundle();
                b.putString("players", player);
                NavArgument arg = new NavArgument.Builder().setDefaultValue(b).build();
                destination.addArgument("players", arg);

                navController.navigate(R.id.action_playFragment_to_gameFragment);
            }
        });
    }
}