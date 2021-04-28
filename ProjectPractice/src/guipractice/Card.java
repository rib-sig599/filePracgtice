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
public class Card {
//The code from the Card and Deck class were heavily inspired by the Poker game we made. 

    public int cardValue;

    enum Face {
        TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING, ACE
    }

    enum Suit {
        HEARTS, SPADES, DIAMONDS, CLUBS
    }
    private Face cardFace;
    private Suit cardSuit;

    public Card(Face cardFace, Suit cardSuit) {
        this.cardFace = cardFace;
        this.cardSuit = cardSuit;
    }

    // random card. generate int to the size of array. 
    // 6 decks. for i < 5... then loop the deck creation from poker. 
    // values... check string then assign an int cardValue
    public int getCardValue(Card card) {
        if (card.getCardFace().equals(Face.ACE)) {
            cardValue = 11;
        }
        if (card.getCardFace().equals(Face.KING) || card.getCardFace().equals(Face.QUEEN)
                || card.getCardFace().equals(cardFace.JACK) || card.getCardFace().equals(Face.TEN)) {
            cardValue = 10;
        }
        if (card.getCardFace().equals(Face.NINE)) {
            cardValue = 9;
        }
        if (card.getCardFace().equals(Face.EIGHT)) {
            cardValue = 8;
        }
        if (card.getCardFace().equals(Face.SEVEN)) {
            cardValue = 7;
        }
        if (card.getCardFace().equals(Face.SIX)) {
            cardValue = 6;
        }
        if (card.getCardFace().equals(Face.FIVE)) {
            cardValue = 5;
        }
        if (card.getCardFace().equals(Face.FOUR)) {
            cardValue = 4;
        }
        if (card.getCardFace().equals(Face.THREE)) {
            cardValue = 3;
        } 
        if (card.getCardFace().equals(Face.TWO)) {
            cardValue = 2;
        }
       return cardValue;
    }

    public Face getCardFace() {
        return cardFace;
    }

    public Suit getCardSuit() {
        return cardSuit;
    }


    

    @Override
    public String toString() {
        return (getCardFace().toString() + " of " + getCardSuit().toString() + "\n");
    }
}
