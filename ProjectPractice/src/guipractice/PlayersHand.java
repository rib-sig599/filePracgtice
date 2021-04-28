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
public class PlayersHand {
    Card card;
    Deck deck;
    public int playersNumber;
    public int DealersNumber;
    public ArrayList PlayersHand = new ArrayList();
    public ArrayList DealerssDeck = new ArrayList();


    public PlayersHand(ArrayList PlayersHand) {
        PlayersHand.add(deck.getRandomCard());
        PlayersHand.add(deck.getRandomCard());

    }
    public void checkForAce(ArrayList hand){
        for (int i =0; i < hand.size(); i++){       
            if (hand.get(i) == "ACE"){
               // TODO make ace = 1 instead of 11 when player over 21.
               
            }
            else{
                
            }
        }
    }
}
