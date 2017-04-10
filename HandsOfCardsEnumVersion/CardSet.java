
package HandsOfCardsEnumVersion;

import java.util.ArrayList;

import Interfaces.ICardsHoldable;


public class CardSet implements ICardsHoldable{
	private ArrayList<Card> cards;
	private int cardSetValue;
	
	public CardSet(){
		this.cards =  new ArrayList<Card>();
	}

	public ArrayList<Card> getCards() {
		return cards;
	}

	public void setCards(Card card) {
		boolean found = false;
		
		if(cards.size() == 0){
			this.cards.add(card);
		}else{
			for(Card currCard : this.cards){
				if((card.getPower() == currCard.getPower()) && (card.getType() == currCard.getType()) && (card.getPowerInt() == currCard.getPowerInt())){
					found = true;
					return;
				}		
			}
			
			if(!found){
				this.cards.add(card);
			}
		}				
	}	
	
	public int GetCardsetValue(){
		this.setCardSetValue();
		return cardSetValue;
	}
	
	private void setCardSetValue(){
		int sum = 0;
		for(Card card : cards){			
			sum += card.getValue();	
		}
		
		cardSetValue = sum;
	}	
	
}
