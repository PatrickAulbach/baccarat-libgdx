package com.libgdx.baccarat.entity;

import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.libgdx.baccarat.enums.CardValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Card {

    @Getter
    private final Image image;

    private final CardValue value;

    public int getValue() {
        return value.getValue();
    }

}
