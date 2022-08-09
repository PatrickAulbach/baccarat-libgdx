package com.libgdx.baccarat.controller;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.libgdx.baccarat.config.GameConfig;
import com.libgdx.baccarat.entity.Card;
import com.libgdx.baccarat.entity.Deck;
import com.libgdx.baccarat.enums.Entity;
import com.libgdx.baccarat.utils.BaccaratRules;

import java.util.Random;

public class BaccaratController {

    private final BaccaratRules baccaratRules;

    private int playerScore;

    private int bankerScore;

    private final Deck deck;

    private final Stage stage;

    public BaccaratController(Deck deck, Stage stage) {
        this.baccaratRules = new BaccaratRules();
        this.deck = deck;
        this.stage = stage;
    }

    public Entity startGame() {
        deck.disposeHand();
        stage.clear();

        drawStartingHand();
        addStartingHandsToStage();
        computeResult();

        if (baccaratRules.isNatural(playerScore, bankerScore)) {
            if (playerScore == bankerScore) {
                return Entity.BOTH;
            }
            return playerScore < bankerScore ? Entity.BANKER : Entity.PLAYER;
        }

        if (baccaratRules.checkEntityDraw(playerScore)) {
            int cardValue = drawCard(Entity.PLAYER);
            addAdditionalCardToStage(Entity.PLAYER);
            if (baccaratRules.checkBankerDraw(bankerScore, cardValue)) {
                drawCard(Entity.BANKER);
                addAdditionalCardToStage(Entity.BANKER);
            }
        } else {
            if (baccaratRules.checkEntityDraw(bankerScore)) {
                drawCard(Entity.BANKER);
                addAdditionalCardToStage(Entity.BANKER);
            }
        }

        computeResult();
        if (playerScore == bankerScore) {
            return Entity.BOTH;
        }

        return playerScore < bankerScore ? Entity.BANKER : Entity.PLAYER;
    }

    private void addStartingHandsToStage() {

        for (int i = 0; i < 2; i++) {
            Image image = deck.getPlayerHand().get(i).getImage();
            image.setPosition(GameConfig.CARD_START_POSITION.x, GameConfig.CARD_START_POSITION.y);
            image.addAction(Actions.sequence(
                    Actions.hide(),
                    Actions.delay(GameConfig.PLAYER_HAND_DELAY_TIMES.get(i)),
                    Actions.show(),
                    Actions.rotateBy(new Random().nextInt(11)),
                    Actions.moveTo(GameConfig.PLAYER_CARD_END_POSITION.x + i * 60, GameConfig.PLAYER_CARD_END_POSITION.y, 1f)));
            stage.addActor(image);

            image = deck.getBankerHand().get(i).getImage();
            image.setPosition(GameConfig.CARD_START_POSITION.x, GameConfig.CARD_START_POSITION.y);
            image.addAction(Actions.sequence(
                    Actions.hide(),
                    Actions.delay(GameConfig.BANKER_HAND_DELAY_TIMES.get(i)),
                    Actions.show(),
                    Actions.rotateBy(new Random().nextInt(11)),
                    Actions.moveTo(GameConfig.BANKER_CARD_END_POSITION.x + i * 60, GameConfig.BANKER_CARD_END_POSITION.y, 1f)));
            stage.addActor(image);
        }
    }

    private void addAdditionalCardToStage(Entity entity) {

        if(Entity.PLAYER.equals(entity)) {
            Image image = deck.getPlayerHand().get(2).getImage();
            image.setPosition(GameConfig.CARD_START_POSITION.x, GameConfig.CARD_START_POSITION.y);
            image.addAction(Actions.sequence(
                    Actions.hide(),
                    Actions.delay(GameConfig.PLAYER_HAND_DELAY_TIMES.get(2)),
                    Actions.show(),
                    Actions.rotateBy(new Random().nextInt(11)),
                    Actions.moveTo(GameConfig.PLAYER_CARD_END_POSITION.x + 100, GameConfig.PLAYER_CARD_END_POSITION.y, 1f)));
            stage.addActor(image);
        } else if (Entity.BANKER.equals(entity)) {
            Image image = deck.getBankerHand().get(2).getImage();
            image.setPosition(GameConfig.CARD_START_POSITION.x, GameConfig.CARD_START_POSITION.y);
            image.addAction(Actions.sequence(
                    Actions.hide(),
                    Actions.delay(GameConfig.BANKER_HAND_DELAY_TIMES.get(2)),
                    Actions.show(),
                    Actions.rotateBy(new Random().nextInt(11)),
                    Actions.moveTo(GameConfig.BANKER_CARD_END_POSITION.x + 100, GameConfig.BANKER_CARD_END_POSITION.y, 1f)));
            stage.addActor(image);
        }
    }

    private void drawStartingHand() {
        deck.drawStartingHand();
    }

    private int drawCard(Entity entity) {

        return deck.addCard(entity).getValue();
    }

    private void computeResult() {
        playerScore = 0;
        bankerScore = 0;

        for (Card card : deck.getPlayerHand()) {
            playerScore += card.getValue();
        }

        for (Card card : deck.getBankerHand()) {
            bankerScore += card.getValue();
        }

        playerScore %= 10;
        bankerScore %= 10;
    }

}
