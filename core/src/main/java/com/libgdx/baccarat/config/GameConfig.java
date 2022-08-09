package com.libgdx.baccarat.config;

import com.badlogic.gdx.math.Vector2;

import java.util.List;

public class GameConfig {

    private static final float Y_OFFSET = 2;

    public static final float WIDTH = 1600f; // pixels
    public static final float HEIGHT = 900f; // pixels

    public static final float HUD_WIDTH = 1600f; // world units
    public static final float HUD_HEIGHT = 900f; // world units

    public static final float WORLD_WIDTH = 50f; // world units
    public static final float WORLD_HEIGHT = 28.125f; // world units

    public static final float WORLD_CENTER_X = WORLD_WIDTH / 2f; // world units
    public static final float WORLD_CENTER_Y = WORLD_HEIGHT / 2f; // world units

    public static final float CARD_HEIGHT = 4.5f; // world units
    public static final float CARD_WIDTH = 3f; // world units

    public static final float BUTTON_WIDTH = 478 / 2f; // world units
    public static final float BUTTON_HEIGHT = 146 / 2f; // world units

    public static final float MAX_Y = WORLD_HEIGHT - Y_OFFSET;

    public static final Vector2 playerHandStartPosition = new Vector2(700, 700);
    public static final Vector2 bankerHandStartPosition = new Vector2(700, 700);

    public static final List<Vector2> playerHandEndPosition = List.of(
            new Vector2(20, 20),
            new Vector2(20, 20),
            new Vector2(20, 20));
    public static final List<Vector2> bankerHandEndPosition = List.of(
            new Vector2(50, 50),
            new Vector2(20, 20),
            new Vector2(20, 20));
    public static final List<Float> playerHandDelayTimes = List.of(
            0.5f,
            1.5f,
            2.5f
    );
    public static final List<Float> bankerHandDelayTimes = List.of(
            2.5f,
            3.5f,
            4.5f
    );

    private GameConfig() {
    }
}
