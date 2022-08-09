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

    public static final Vector2 CARD_START_POSITION = new Vector2(1400, 700);
    public static final Vector2 PLAYER_CARD_END_POSITION = new Vector2(500, 650);
    public static final Vector2 BANKER_CARD_END_POSITION = new Vector2(800, 650);

    public static final List<Float> PLAYER_HAND_DELAY_TIMES = List.of(
            0.5f,
            1.5f,
            4.5f
    );
    public static final List<Float> BANKER_HAND_DELAY_TIMES = List.of(
            2.5f,
            3.5f,
            5.5f
    );

    private GameConfig() {
    }
}
