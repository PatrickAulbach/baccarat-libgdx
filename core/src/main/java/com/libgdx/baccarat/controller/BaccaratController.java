package com.libgdx.baccarat.controller;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.libgdx.baccarat.BaccaratGame;
import com.libgdx.baccarat.entity.Card;
import com.libgdx.baccarat.entity.Deck;
import com.libgdx.baccarat.enums.Entity;
import com.libgdx.baccarat.utils.BaccaratRules;

public class BaccaratController {

    private final BaccaratRules baccaratRules;

    private int playerScore;

    private int bankerScore;

    private final Deck deck;

    private Stage stage;

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
            if (baccaratRules.checkBankerDraw(bankerScore, cardValue)) {
                drawCard(Entity.BANKER);
            }
        } else {
            if (baccaratRules.checkEntityDraw(bankerScore)) {
                drawCard(Entity.BANKER);
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
            image.setPosition(1400, 700);
            image.addAction(Actions.sequence(
                    Actions.hide(),
                    Actions.delay((i * 2 + 1) / 2f),
                    Actions.show(),
                    Actions.moveTo(700 + i * 100, 650, 1f)));
            stage.addActor(image);

            image = deck.getBankerHand().get(i).getImage();
            image.setPosition(1400, 700);
            image.addAction(Actions.sequence(
                    Actions.hide(),
                    Actions.delay((i * 2 + 5) / 2f),
                    Actions.show(),
                    Actions.moveTo(700 + i * 100, 250, 1f)));
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
