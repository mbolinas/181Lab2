package pkgPokerBLL;

import java.util.ArrayList;
import java.util.Collections;
import java.util.UUID;

import pkgPokerEnum.*;

public class Deck{

	private UUID DeckID;
	private ArrayList<Card> DeckCards = new ArrayList<Card>();
	
	public Deck(){
		
		for(eRank Rank : eRank.values()) {
			for(eSuit Suit : eSuit.values()){
				DeckCards.add(new Card(Rank, Suit));
			}
		}
		
		Collections.shuffle(DeckCards);
	}
	
	public Card DrawCard(){
		
		return DeckCards.remove(0);
	}
}
