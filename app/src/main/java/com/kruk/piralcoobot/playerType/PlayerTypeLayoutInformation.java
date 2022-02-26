package com.kruk.piralcoobot.playerType;

import androidx.annotation.ColorRes;
import androidx.annotation.StringRes;

public class PlayerTypeLayoutInformation {
    @StringRes
    private final int nameId;
    @StringRes
    private final int listNameId;
    @ColorRes
    private final int primaryColorId;
    @ColorRes
    private final int secondaryColorId;

    public PlayerTypeLayoutInformation(
            @StringRes int nameId,
            @StringRes int listNameId,
            @ColorRes int primaryColorId,
            @ColorRes int secondaryColorId
    ) {
        this.nameId = nameId;
        this.listNameId = listNameId;
        this.primaryColorId = primaryColorId;
        this.secondaryColorId = secondaryColorId;
    }

    @StringRes
    public int getNameId() {
        return this.nameId;
    }

    @StringRes
    public int getListNameId() {
        return this.listNameId;
    }

    @ColorRes
    public int getPrimaryColorId() {
        return this.primaryColorId;
    }

    @ColorRes
    public int getSecondaryColorId() {
        return this.secondaryColorId;
    }
}
