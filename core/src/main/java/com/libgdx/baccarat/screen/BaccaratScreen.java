package com.libgdx.baccarat.screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.ScreenAdapter;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Button;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.libgdx.baccarat.BaccaratGame;
import com.libgdx.baccarat.config.GameConfig;
import com.libgdx.baccarat.controller.BaccaratController;
import com.libgdx.baccarat.entity.Deck;
import lombok.SneakyThrows;

public class BaccaratScreen extends ScreenAdapter {

    private final BaccaratGame baccaratGame;

    private SpriteBatch batch;
    private Skin skin;

    private BaccaratController baccaratController;
    private final Deck deck;

    private Viewport viewport;
    private Viewport hudViewport;

    private Stage stage;
    private Stage cardStage;

    private OrthographicCamera camera;

    public BaccaratScreen(BaccaratGame baccaratGame) {
        this.baccaratGame = baccaratGame;
        this.deck = new Deck();
    }

    @SneakyThrows
    @Override
    public void show() {

        deck.buildDeck(baccaratGame);

        skin = new Skin(Gdx.files.internal("buttons/buttons.json"));

        camera = new OrthographicCamera();
        batch = new SpriteBatch();

        viewport = new FitViewport(GameConfig.WORLD_WIDTH, GameConfig.WORLD_HEIGHT, camera);
        hudViewport = new FitViewport(GameConfig.HUD_WIDTH, GameConfig.HUD_HEIGHT);

        stage = new Stage(hudViewport, batch);
        cardStage = new Stage(hudViewport, batch);

        baccaratController = new BaccaratController(deck, cardStage);

        Gdx.input.setInputProcessor(stage);
        createButtons();

    }

    public void resize(int width, int height) {
        viewport.update(width, height, true);
    }


    @Override
    public void render(float delta) {
        ScreenUtils.clear(0, 0, 0, 1);
        viewport.apply();
        batch.setProjectionMatrix(camera.combined);
        batch.begin();

        batch.end();

        hudViewport.apply();
        batch.setProjectionMatrix(hudViewport.getCamera().combined);

        stage.act();
        stage.draw();
        cardStage.act();
        cardStage.draw();
    }

    public void createButtons() {

        Label winnerLabel = new Label("", new Label.LabelStyle(new BitmapFont(), Color.WHITE));
        winnerLabel.setPosition(900, 450);

        Button playButton = new TextButton("Play", skin, "default");

        playButton.setSize(GameConfig.BUTTON_WIDTH, GameConfig.BUTTON_HEIGHT);
        playButton.setPosition(100f, 700);
        playButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                deck.buildDeck(baccaratGame);
                winnerLabel.setText(baccaratController.startGame().name());
            }
        });

        stage.addActor(playButton);
        stage.addActor(winnerLabel);
    }

    @Override
    public void dispose() {
        batch.dispose();
    }

}
