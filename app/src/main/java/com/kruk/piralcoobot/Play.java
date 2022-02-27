package com.kruk.piralcoobot;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Space;

import com.kruk.piralcoobot.playerType.PlayerTypeData;
import com.kruk.piralcoobot.playerType.PlayerTypeLayoutInformation;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Play extends Fragment {

    private ArrayList<String> players = new ArrayList<String>();

    private PlayerTypeData pirateType;
    private PlayerTypeData mousseType;
    private PlayerTypeData guestType;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.play_page, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        retrievePlayerTypeData();

        view.findViewById(R.id.button_add_pirate).setOnClickListener(getClickListener(pirateType));
        view.findViewById(R.id.button_add_mousse).setOnClickListener(getClickListener(mousseType));
        view.findViewById(R.id.button_add_guest).setOnClickListener(getClickListener(guestType));
        view.findViewById(R.id.start_game_button).setOnClickListener(v -> {
            // Add players
            addPlayers((ViewGroup) getView());

            NavController navController = NavHostFragment.findNavController(Play.this);
            NavDestination destination = navController.getGraph().findNode(R.id.gameFragment);
            if (destination == null) {
                Log.d("DEBUG", "Could not find game fragment node.");
                return;
            }

            Bundle b = new Bundle();
            b.putStringArrayList("players", players);
            NavArgument arg = new NavArgument.Builder().setDefaultValue(b).build();
            destination.addArgument("players", arg);

            navController.navigate(R.id.action_playFragment_to_gameFragment);
        });
    }

    private void retrievePlayerTypeData() {
        File file = new File(this.getContext().getFilesDir(), getResources().getString(R.string.playerTypeDataFile));

        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<PlayerTypeData> playerTypeData = null;

        try {
            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);

            playerTypeData = (ArrayList<PlayerTypeData>) ois.readObject();
            for (PlayerTypeData p : playerTypeData) {
                Log.d("DEBUG", p.getName());
                if (p.getName().equals("Pirate")) this.pirateType = p;
                else if (p.getName().equals("Mousse")) this.mousseType = p;
                else if (p.getName().equals("Guest")) this.guestType = p;
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void addPlayers(ViewGroup viewGroup) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View viewChild = viewGroup.getChildAt(i);
            if (viewChild instanceof EditText) {
                EditText editText = (EditText) viewChild;
                String playerTypeName = "";
                if (editText.getContentDescription().toString().contains(pirateType.getName()))
                    playerTypeName = pirateType.getName();
                else if (editText.getContentDescription().toString().contains(mousseType.getName()))
                    playerTypeName = mousseType.getName();
                else if (editText.getContentDescription().toString().contains(guestType.getName()))
                    playerTypeName = guestType.getName();
                players.add(playerTypeName + ":" + editText.getText().toString());
            } else if (viewChild instanceof ViewGroup) addPlayers((ViewGroup) viewChild);
        }
    }

    private LinearLayout findLayout(View v, String layoutType) {
        ViewGroup viewGroup = (ViewGroup) v;
        LinearLayout found = null;

        View tmp;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            tmp = viewGroup.getChildAt(i);
            if (tmp instanceof LinearLayout) {
                CharSequence description = tmp.getContentDescription();
                if (description != null && description.toString().contains(layoutType))
                    return (LinearLayout) tmp;
            }
            if (tmp instanceof ViewGroup) {
                found = findLayout(tmp, layoutType);
                if (found != null) return found;
            }
        }
        return found;
    }

    private View.OnClickListener getClickListener(PlayerTypeData playerTypeData) {
        PlayerTypeLayoutInformation layoutInformation = playerTypeData.getLayoutInformation();
        return v -> {
            LinearLayout layout = findLayout(getView(), getResources().getString(layoutInformation.getListNameId()));
            if (layout == null) {
                Log.d("DEBUG", "Could not find " + playerTypeData.getName() + " list layout.");
                return;
            }

            // Add Space
            Space newSpace = new Space(getContext());
            newSpace.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 6));
            layout.addView(newSpace);

            // Add EditText
            EditText newEditText = new EditText(getContext());
            newEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            newEditText.setContentDescription(getResources().getString(layoutInformation.getNameId()));
            newEditText.setBackgroundColor(getResources().getColor(layoutInformation.getSecondaryColorId()));
            newEditText.setEms(10);
            newEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            newEditText.setText(getResources().getString(layoutInformation.getNameId()));
            newEditText.setTextColor(getResources().getColor(R.color.buttonTextColor));
            newEditText.setTextSize(25);
            layout.addView(newEditText);
        };
    }
}