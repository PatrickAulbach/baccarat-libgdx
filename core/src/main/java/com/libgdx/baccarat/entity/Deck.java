package com.libgdx.baccarat.entity;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.libgdx.baccarat.BaccaratGame;
import com.libgdx.baccarat.enums.Entity;
import com.libgdx.baccarat.utils.CardMapper;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Deck {

    @Getter
    List<Card> deck;

    @Getter
    private List<Card> playerHand = new ArrayList<>();

    @Getter
    private List<Card> bankerHand = new ArrayList<>();

    private int count;

    public void buildDeck(BaccaratGame game) {
        TextureAtlas atlas = game.getAssetManager().get(new AssetDescriptor<>("cards/cards.atlas", TextureAtlas.class));

        List<String> suits = List.of("clubs", "diamonds", "hearts", "spades");

        deck = new ArrayList<>();

        for (int i = 1; i < 14; i++) {
            for (String suit : suits) {
                String cardName = "card-" + suit + "-" + i;
                TextureRegion textureRegion = atlas.findRegion(cardName);
                deck.add(new Card(new Image(textureRegion), CardMapper.getValue(cardName)));
            }
        }

    }

    public Card getNextCard() {
        count++;
        if (count >= deck.size()) {
            Collections.shuffle(deck);
            count = 0;
        }
        return deck.get(count);
    }

    public void drawStartingHand() {

        for (int i = 0; i < 2; i++) {
            playerHand.add(getNextCard());
            bankerHand.add(getNextCard());
        }
    }

    public void disposeHand() {
        playerHand = new ArrayList<>();
        bankerHand = new ArrayList<>();
    }

    public Card addCard(Entity entity) {
        Card card = getNextCard();

        if (Entity.PLAYER.equals(entity)) {
            playerHand.add(card);
        } else if (Entity.BANKER.equals(entity)) {
            bankerHand.add(card);
        }

        return card;
    }
}
