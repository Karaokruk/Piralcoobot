package com.kruk.piralcoobot;

import android.os.Bundle;

import com.kruk.piralcoobot.playerType.*;
import com.kruk.piralcoobot.rules.*;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        storeAppData();
        setContentView(R.layout.home_skeleton);
    }

    private void storeAppData() {
        storeDataFile(getResources().getString(R.string.playerTypeDataFile), createPlayerTypeData());
        storeDataFile(getResources().getString(R.string.ruleSetDataFile), createRuleSetData());
    }

    private Serializable createRuleSetData() {
        // Common player type sets
        ArrayList<PlayerType> soloAny = new ArrayList<>(Collections.singletonList(PlayerType.ANY));
        ArrayList<PlayerType> duoAny = new ArrayList<>(Arrays.asList(PlayerType.ANY, PlayerType.ANY));
        ArrayList<PlayerType> soloPirate = new ArrayList<>(Collections.singletonList(PlayerType.PIRATE));
        ArrayList<PlayerType> duoPirate = new ArrayList<>(Arrays.asList(PlayerType.PIRATE, PlayerType.PIRATE));
        ArrayList<PlayerType> duoMoussePirate = new ArrayList<>(Arrays.asList(PlayerType.MOUSSE, PlayerType.PIRATE));

        // Death rules
        DeathRule culSecRule = new DeathRule("CulSec", "Cul sec pour <NAME> !", "helpText", 1, false, soloAny);
        DeathRule navireHorizonRule = new DeathRule("NavireHorizon", "Navire à l'horizon : finissez vos verres moussaillons, à l'abordage !", "helpText", 0, false);
        DeathRule shifumiRule = new DeathRule("Shifumi", "<NAME1> & <NAME2>, faites un Shi-fu-mi cul sec.", "helpText", 2, false, duoAny);

        // Drink rules
        DrinkRule auCachotRule = new DrinkRule("AuCachot", "AU CACHOT ! <NAME> rentre au cachot, privé d'alcool (esquive la prochaine buvance).", "helpText", 1, false, soloAny);
        DrinkRule classicRule = new DrinkRule("Classic", "<NAME>, tu bois <GULPS> gorgées.", "helpText", 1, true, soloAny);
        DrinkRule distanceMousseRule = new DrinkRule("DistanceMousse", "<NAME>, tu bois autant de gorgées qu'il y a de personnes entre toi et le premier mousse à ta <DIRECTION>.", "helpText", 1, false, soloAny);
        DrinkRule fontaineRule = new DrinkRule("Fontaine", "Fontaine : <NAME> tu commences, sens vers la <DIRECTION>.", "helpText", 1, false, soloAny);
        DrinkRule mousseVengeanceRule = new DrinkRule("MousseVengeance", "<NAME1>, finis le verre de <NAME2> puis remplis-le avec ce que tu veux (le verre, pas le pirate).", "helpText", 2, false, duoMoussePirate);
        DrinkRule mutinerieRule = new DrinkRule("Mutinerie", "MUTINERIE ! Les matelots se retournent contre le capitaine. Chaque matelot donne <GULPS> gorgées au capitaine et les boit avec lui.", "helpText", 0, true);
        DrinkRule partageTonBreuvageRule = new DrinkRule("PartageTonBreuvage", "<NAME1>, verse un peu de la boisson la plus proche dans le verre de <NAME2> (les verres comptent comme une boisson).", "helpText", 2, true, duoAny);
        DrinkRule capitainePafTentativesRule = new DrinkRule("CapitainePafTentatives", "<NAME>, bois autant de gorgées que de tentatives que tu as passées au Capitaine Paf", "helpText", 1, false, soloPirate);
        DrinkRule auxRequinsRule = new DrinkRule("AuxRequins", "AUX REQUINS ! Désignez une personne en même temps, elle boit <GULPS> gorgées.", "helpText", 0, true);
        DrinkRule bandeDeRequinsRule = new DrinkRule("BandeDeRequins", "AUX REQUINS ! Désignez une personne en même temps, elle fait boire <GULPS> gorgées à tous ceux qui l'ont désignée.", "helpText", 0, true);
        DrinkRule troisProchainesRule = new DrinkRule("TroisProchaines", "<NAME>, pour étancher ta soif, accompagne les victimes des trois prochaines règles.", "helpText", 1, false, soloAny);
        DrinkRule tuBoisRule = new DrinkRule("TuBois", "<NAME>, tu bois.", "Le joueur boit.", 1, false, soloAny);

        // Game rules
        GameRule batailleDeMousseRule = new GameRule("BatailleDeMousse", "BATAILLE DE MOUSSES ! Les mousses jettent un dé, le mousse qui fait le plus haut score est épargné, les autres boivent <GULPS>", "S'il n'y a pas de dés, ils boivent tous.", 0, true);
        GameRule choisisLeBonRule = new GameRule("ChoisisLeBon", "Choisis le bon ! <NAME1> et <NAME2> choisissent leur mousse respectif et misent des gorgées dessus. Les mousses choisissent une carte face cachée puis la retourne ensemble. La plus grande gagne (mais l'as perd).", "helpText", 2, false, duoPirate);
        GameRule clapRule = new GameRule("Clap", "Clap, <NAME> commence, sens vers la <DIRECTION>.\n <GULPS> gorgées pour le perdant.", "helpText", 1, true, soloAny);
        GameRule dansMonTonneauRule = new GameRule("DansMonTonneau", "Dans mon tonneau, <NAME> commence, sens vers la <DIRECTION>. \n Le perdant boit le nombre d'objets dans mon tonneau.", "helpText", 1, false, soloAny);
        GameRule devineLaDirectionRule = new GameRule("DevineLaDirection", "DEVINE LA DIRECTION !\n Tout le monde se tourne vers un de ses voisins. Si c'est le bon voisin, il boit, sinon, c'est l'autre qui boit. <GULPS> gorgées sont en jeu. Et le bon voisin était... Celui à votre <DIRECTION> !", "Le lecteur de la règle ne joue pas.", 0, true);
        GameRule onSeFaitAttaquerRule = new GameRule("OnSeFaitAttaquer", "ON SE FAIT ATTAQUER ! Nous avons <GULPS> gorgées à essorer, répartissez-vous les gorgées comme vous le souhaitez.", "helpText", 0, true);
        GameRule ouilleRule = new GameRule("Ouille", "Chacun son tour, une rime en -ouille ! <NAME> commence, sens vers la <DIRECTION>. PRÊÊÊÊTS ?!\nC'est moiiiiii le plus grand pirate de l'îîîîîîîîle !\nJe trucide et j'écrabouille, et je m'en mets plein les -", "helpText", 1, false, soloAny);
        GameRule pagayeRule = new GameRule("Pagaye", "À 3, tout le monde pagaye d'un côté. Ceux qui pagayent du côté le plus choisi boivent <GULPS> gorgées (en cas d'égalité, tout le monde boit).\n 1... 2... 3 !", "helpText", 0, true);
        GameRule pasBourreRule = new GameRule("PasBourre", "T'ES PAS BOURRÉ ! Laissez la Poule Pirate choisir qui n'a pas encore assez bu, <GULPS> gorgées !", "helpText", 0, true);
        GameRule pouetRule = new GameRule("Pouet", "Pouet, <NAME> commence, sens vers la <DIRECTION>.\n <GULPS> gorgées pour le perdant.", "helpText", 1, true, soloAny);
        GameRule themeRule = new GameRule("Theme", "Thème, <NAME> commence, sens vers la <DIRECTION>.\n Le perdant boit en gorgées le nombre de réponses au thème.", "helpText", 1, false, soloAny);

        // Role rules
        RoleRule clownRule = new RoleRule("Clown", "<NAME>, à partir de maintenant, si tu fais rire quelqu'un, la victime boit.", "MOI J'SUIS UN CLOWN ?", 1, false, soloAny);

        ArrayList<Rule> rules = new ArrayList<>();
        rules.add(culSecRule);
        rules.add(navireHorizonRule);
        rules.add(shifumiRule);
        rules.add(auCachotRule);
        rules.add(classicRule);
        rules.add(distanceMousseRule);
        rules.add(fontaineRule);
        rules.add(mousseVengeanceRule);
        rules.add(mutinerieRule);
        rules.add(partageTonBreuvageRule);
        rules.add(capitainePafTentativesRule);
        rules.add(auxRequinsRule);
        rules.add(bandeDeRequinsRule);
        rules.add(troisProchainesRule);
        rules.add(tuBoisRule);
        rules.add(batailleDeMousseRule);
        rules.add(choisisLeBonRule);
        rules.add(clapRule);
        rules.add(dansMonTonneauRule);
        rules.add(devineLaDirectionRule);
        rules.add(onSeFaitAttaquerRule);
        rules.add(ouilleRule);
        rules.add(pagayeRule);
        rules.add(pasBourreRule);
        rules.add(pouetRule);
        rules.add(themeRule);
        rules.add(clownRule);

        return rules;
    }

    private Serializable createPlayerTypeData() {
        PlayerTypeData pirateSerializable = new PlayerTypeData(
                PlayerType.MOUSSE, "Pirate", new PlayerTypeLayoutInformation(R.string.pirate, R.string.pirateList, R.color.piratePrimary, R.color.pirateSecondary)
        );
        PlayerTypeData mousseSerializable = new PlayerTypeData(
                PlayerType.MOUSSE, "Mousse", new PlayerTypeLayoutInformation(R.string.mousse, R.string.mousseList, R.color.moussePrimary, R.color.mousseSecondary)
        );
        PlayerTypeData guestSerializable = new PlayerTypeData(
                PlayerType.GUEST, "Guest", new PlayerTypeLayoutInformation(R.string.guest, R.string.guestList, R.color.guestPrimary, R.color.guestSecondary)
        );
        ArrayList<PlayerTypeData> playerTypes = new ArrayList<>();
        playerTypes.add(pirateSerializable);
        playerTypes.add(mousseSerializable);
        playerTypes.add(guestSerializable);

        return playerTypes;
    }

    private void storeDataFile(String fileName, Serializable dataSet) {
        File file = new File(getFilesDir(), fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(dataSet);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.flush();
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (oos != null) {
                try {
                    oos.flush();
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}