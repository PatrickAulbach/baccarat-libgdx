package com.libgdx.baccarat.utils;

import com.libgdx.baccarat.controller.BaccaratController;
import com.libgdx.baccarat.entity.Deck;
import com.libgdx.baccarat.enums.Entity;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class TestBaccaratController {

    /*
    @Test
    public void TestRulesWithNatural9_ShouldReturnTie() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-4", "card-clubs-3", "card-clubs-5", "card-clubs-6");

        BaccaratController controller = new BaccaratController(deckMock);
        deckMock.buildDeck(game);

        Entity entity = controller.startGame();

        assertEquals(Entity.BOTH, entity);
    }

    @Test
    public void TestRulesWithNatural8_ShouldReturnTie() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-5", "card-clubs-6");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.BOTH, entity);
    }

    @Test
    public void TestRulesPlayerStand_PlayerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-4", "card-clubs-3", "card-clubs-1");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.PLAYER, entity);
    }

    @Test
    public void TestRulesPlayerStand_BankerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-4", "card-clubs-3", "card-clubs-3");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.BANKER, entity);
    }

    @Test
    public void TestRulesPlayerDraw_BankerStands_PlayerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-2", "card-clubs-4", "card-clubs-2");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.PLAYER, entity);
    }

    @Test
    public void TestRulesPlayerDraw_BankerStands_BankerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-2", "card-clubs-4", "card-clubs-11");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.BANKER, entity);
    }

    @Test
    public void TestRulesPlayerStands_BankerDraws_PlayerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-3", "card-clubs-3", "card-clubs-10");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.PLAYER, entity);
    }

    @Test
    public void TestRulesPlayerStands_BankerDraws_BankerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-3", "card-clubs-3", "card-clubs-2");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.BANKER, entity);
    }

    @Test
    public void TestRulesPlayerDraws_BankerDraws_PlayerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-3", "card-clubs-2", "card-clubs-3", "card-clubs-6", "card-clubs-4");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.PLAYER, entity);
    }

    @Test
    public void TestRulesPlayerDraws_BankerDraws_BankerShouldWin() {
        Deck deckMock = mock(Deck.class);

        when(deckMock.getNextCard()).thenReturn("card-clubs-3", "card-clubs-2", "card-clubs-2", "card-clubs-2", "card-clubs-2", "card-clubs-4");

        BaccaratController controller = new BaccaratController();
        controller.initGame(deckMock);

        Entity entity = controller.startGame();

        assertEquals(Entity.BANKER, entity);
    }


     */
}
