package com.libgdx.baccarat.screen;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.*;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Disposable;
import com.libgdx.baccarat.config.GameConfig;
import com.libgdx.baccarat.entity.Deck;
import com.libgdx.baccarat.utils.Bankroll;
import lombok.Getter;

public class BaccaratRenderer implements Disposable {

    @Getter
    private final Stage stage;

    private Skin skin;

    private Bankroll bankroll;

    private Deck deck;

    public BaccaratRenderer(Deck deck) {
        this.stage = new Stage();
        this.deck = deck;
    }

    public void show() {

    }

    public void render() {

    }



    @Override
    public void dispose() {
        stage.dispose();
    }
}
