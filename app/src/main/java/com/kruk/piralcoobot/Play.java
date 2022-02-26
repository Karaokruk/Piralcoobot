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

import com.kruk.piralcoobot.playerType.GuestType;
import com.kruk.piralcoobot.playerType.MousseType;
import com.kruk.piralcoobot.playerType.PirateType;
import com.kruk.piralcoobot.playerType.PlayerType;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavArgument;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;

import java.util.ArrayList;

public class Play extends Fragment {

    private ArrayList<String> players = new ArrayList<String>();

    private static final PlayerType pirateType = new PirateType();
    private static final PlayerType mousseType = new MousseType();
    private static final PlayerType guestType = new GuestType();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.play_page, container, false);
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

    private View.OnClickListener getClickListener(PlayerType playerType) {
        return v -> {
            LinearLayout layout = findLayout(getView(), getResources().getString(playerType.getLayoutInformation().getListNameId()));
            if (layout == null) {
                Log.d("DEBUG", "Could not find " + playerType.getName() + " list layout.");
                return;
            }

            // Add Space
            Space newSpace = new Space(getContext());
            newSpace.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 6));
            layout.addView(newSpace);

            // Add EditText
            EditText newEditText = new EditText(getContext());
            newEditText.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            newEditText.setContentDescription(getResources().getString(playerType.getLayoutInformation().getNameId()));
            newEditText.setBackgroundColor(getResources().getColor(playerType.getLayoutInformation().getSecondaryColorId()));
            newEditText.setEms(10);
            newEditText.setInputType(InputType.TYPE_TEXT_VARIATION_PERSON_NAME);
            newEditText.setText(getResources().getString(playerType.getLayoutInformation().getNameId()));
            newEditText.setTextColor(getResources().getColor(R.color.buttonTextColor));
            newEditText.setTextSize(25);
            layout.addView(newEditText);
        };
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

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
}