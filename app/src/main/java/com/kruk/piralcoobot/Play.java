package com.kruk.piralcoobot;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.NavGraph;
import androidx.navigation.fragment.NavHostFragment;

import java.lang.reflect.Array;
import java.util.ArrayList;

import static com.kruk.piralcoobot.R.*;

public class Play extends Fragment {

    ArrayList<String> players = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.play_page, container, false);
    }

    private static String addPlayerTypeToPlayerName(PlayerType type, String playerName) {
        String tmp = "";
        if (type == PlayerType.PIRATE) tmp = "pirate";
        if (type == PlayerType.MOUSSE) tmp = "mousse";
        if (type == PlayerType.GUEST) tmp = "guest";
        tmp = tmp.concat(":");
        tmp = tmp.concat(playerName);
        return tmp;
    }

    private void addPlayers(View v) {
        ViewGroup viewGroup = (ViewGroup) v;

        PlayerType playerType = PlayerType.GUEST;
        View tmp;
        for (int i = 0 ; i < viewGroup.getChildCount() ; i++) {
            tmp = viewGroup.getChildAt(i);
            if (tmp instanceof EditText) {
                EditText editText = (EditText) tmp;
                if (editText.getContentDescription().toString().contains("Pirate")) playerType = PlayerType.PIRATE;
                if (editText.getContentDescription().toString().contains("Mousse")) playerType = PlayerType.MOUSSE;
                if (editText.getContentDescription().toString().contains("Guest")) playerType = PlayerType.GUEST;
                players.add(addPlayerTypeToPlayerName(playerType, editText.getText().toString()));
            }
            if (tmp instanceof ViewGroup) addPlayers(tmp);
        }
    }

    private LinearLayout findLayout(View v, String layoutType) {
        ViewGroup viewGroup = (ViewGroup) v;
        LinearLayout found = null;

        View tmp;
        for (int i = 0 ; i < viewGroup.getChildCount() ; i++) {
            tmp = viewGroup.getChildAt(i);
            if (tmp instanceof LinearLayout) {
                CharSequence description = tmp.getContentDescription();
                if (description != null && description.toString().contains(layoutType)) return (LinearLayout) tmp;
            }
            if (tmp instanceof ViewGroup) {
                found = findLayout(tmp, layoutType);
                if (found != null) return found;
            }
        }
        return found;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // TODO factorize buttons listeners

        view.findViewById(R.id.button_add_pirate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = findLayout(getView(), getResources().getString(R.string.pirateList));
                if (layout == null) return;
                Log.d("DEBUG", "Pirate List layout found.");

                // Add Space
                Space newSpace = new Space(getContext());
                newSpace.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 6));
                layout.addView(newSpace);

                // Add EditText
                EditText newEditText = new EditText(getContext());
                newEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newEditText.setContentDescription(getResources().getString(R.string.pirate));
                newEditText.setBackgroundColor(getResources().getColor(R.color.pirateSecondary));
                newEditText.setEms(10);
                newEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                newEditText.setText(getResources().getString(R.string.pirate));
                newEditText.setTextColor(getResources().getColor(R.color.buttonTextColor));
                newEditText.setTextSize(25);
                layout.addView(newEditText);
            }
        });

        view.findViewById(R.id.button_add_mousse).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = findLayout(getView(), getResources().getString(R.string.mousseList));
                if (layout == null) return;
                Log.d("DEBUG", "Mousse List layout found.");

                // Add Space
                Space newSpace = new Space(getContext());
                newSpace.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 6));
                layout.addView(newSpace);

                // Add EditText
                EditText newEditText = new EditText(getContext());
                newEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newEditText.setContentDescription(getResources().getString(R.string.mousse));
                newEditText.setBackgroundColor(getResources().getColor(R.color.mousseSecondary));
                newEditText.setEms(10);
                newEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                newEditText.setText(getResources().getString(R.string.mousse));
                newEditText.setTextColor(getResources().getColor(R.color.buttonTextColor));
                newEditText.setTextSize(25);
                layout.addView(newEditText);
            }
        });

        view.findViewById(R.id.button_add_guest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LinearLayout layout = findLayout(getView(), getResources().getString(R.string.guestList));
                if (layout == null) return;
                Log.d("DEBUG", "Guest List layout found.");

                // Add Space
                Space newSpace = new Space(getContext());
                newSpace.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 6));
                layout.addView(newSpace);

                // Add EditText
                EditText newEditText = new EditText(getContext());
                newEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                newEditText.setContentDescription(getResources().getString(R.string.guest));
                newEditText.setBackgroundColor(getResources().getColor(R.color.guestSecondary));
                newEditText.setEms(10);
                newEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
                newEditText.setText(getResources().getString(R.string.guest));
                newEditText.setTextColor(getResources().getColor(R.color.buttonTextColor));
                newEditText.setTextSize(25);
                layout.addView(newEditText);
            }
        });

        view.findViewById(R.id.start_game_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Add players
                addPlayers(getView());

                NavController navController = NavHostFragment.findNavController(Play.this);
                NavDestination destination = navController.getGraph().findNode(R.id.gameFragment);

                Bundle b = new Bundle();
                b.putStringArrayList("players", players);
                NavArgument arg = new NavArgument.Builder().setDefaultValue(b).build();
                destination.addArgument("players", arg);

                navController.navigate(R.id.action_playFragment_to_gameFragment);
            }
        });
    }
}