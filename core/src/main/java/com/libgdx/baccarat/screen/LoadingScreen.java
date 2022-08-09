package com.libgdx.baccarat.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.libgdx.baccarat.BaccaratGame;

public class LoadingScreen extends ScreenAdapter {

    private final BaccaratGame game;
    private final AssetManager assetManager;

    private float waitTime = 0.75f;
    private boolean changeScreen;

    public LoadingScreen(BaccaratGame game, AssetManager assetManager) {
        this.game = game;
        this.assetManager = assetManager;
    }

    @Override
    public void show() {

        assetManager.load(new AssetDescriptor<>("ui/ui.json", Skin.class));
        assetManager.load(new AssetDescriptor<>("buttons/buttons.json", Skin.class));
        assetManager.load(new AssetDescriptor<>("cards/cards.atlas", TextureAtlas.class));
        assetManager.load(new AssetDescriptor<>("buttons/buttons.atlas", TextureAtlas.class));
    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(Color.BLACK.r, Color.BLACK.g, Color.BLACK.b, Color.BLACK.a);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        update(delta);

        if (changeScreen) {
            game.setScreen(new BaccaratScreen(game));
        }
    }

    private void update(float delta) {

        if (assetManager.update()) {
            waitTime -= delta;

            if (waitTime <= 0) {
                changeScreen = true;
            }
        }
    }
}
