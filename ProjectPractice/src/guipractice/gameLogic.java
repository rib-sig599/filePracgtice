/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipractice;

import java.util.ArrayList;

/**
 *
 * @author andre
 */
public class gameLogic {

    Card card;
    Deck deck;
    public boolean Win;
    public boolean Loss;
    public ArrayList PlayersHand = new ArrayList();
    public ArrayList DealersHand = new ArrayList();
    public ArrayList shuffledDeck = new ArrayList();
    PlayersHand playersHand;

    int PlayersScore;
    int DealerScore;
    int bet;
    int playerPot = 100;

    public void handHit(Card card) {
        card = deck.getRandomCard();
        PlayersHand.add(card);
        PlayersScore += card.cardValue;
        if (Loss = true) {
            isLoss(bet);
        } else {
            isWin(bet);
        }
    }

    public void handStand() {

    }

    public void handSplit() {

    }

    public void handDoubleDown(Card card) {
        bet = bet * 2;
        card = deck.getRandomCard();
        PlayersHand.add(card);
        PlayersScore += card.cardValue;
        overScore(card.getCardValue(card));
        if (Loss = true) {
            isLoss(bet);
        } else {
            isWin(bet);
        }
    }

    public int getPlayersBet(int bet) {
        this.bet = bet;
        return bet;
    }
    public String playersMoney(){  
        return String.valueOf(playerPot);
    }

    public void overScore(int score) {
        if (score > 21) {
            bet -= score;
        }
    }

    public boolean isWin(int bet) {
        playerPot += bet;
        PlayersScore = 0;
        DealerScore = 0;
        return Win;
    }

    public boolean isLoss(int bet) {
        playerPot -= bet;
        PlayersScore = 0;
        DealerScore = 0;
        if (playerPot <= 0) {
            gameOver();
        }
        return Loss;
    }

    public void generateCards(Card card) {
        for (int x = 0; x < 2; x++) {
            //players cards.
            card = deck.getRandomCard();
            PlayersHand.add(card);
            PlayersScore += card.cardValue;
            deck.blackJackDeck.remove(card);
        }
        for (int x = 0; x < 2; x++) {
            //dealers cards.
            card = deck.getRandomCard();
            DealersHand.add(card);
            DealerScore += card.cardValue;
            deck.blackJackDeck.remove(card);
        }
    }

    public void checkForReShuffle() {
        if (deck.blackJackDeck.size() < 30) {
            deck.blackJackDeck.clear();
            Deck newDeck = new Deck(card);
            deck.blackJackDeck = newDeck.blackJackDeck;
        }
    }

    public void gameOver() {
        
    }
}
