/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package guipractice;

import com.sun.webkit.BackForwardList;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author andre
 */
public class Deck {
//The code from the Card and Deck class were heavily inspired by the Poker game we made. 
    
    Card cards;
    public ArrayList blackJackDeck = new ArrayList();
    public Deck(Card cards) {
        for (int i = 0; i < 6; i++) {
            this.cards = cards;
            for (Card.Suit suit : Card.Suit.values()) {
                for (Card.Face face : Card.Face.values()) {
                    cards = new Card(face, suit);
                    blackJackDeck.add(cards);

                }
            }
        }
    }
        @Override
    public String toString() {
        return getRandomCard().toString();
    }
    
    public Card getRandomCard() {
        Random random = new Random();
        int randomCard = random.nextInt(blackJackDeck.size());
        Card chosenCard = (Card) blackJackDeck.get(randomCard);
        blackJackDeck.remove(randomCard);
        return chosenCard;
    }
}
