package HandsOfCardsEnumVersion;


public class Player {
	private CardSet setOfCards;
	private String name;
	
	public Player(String name){
		this.name = name;
		this.setOfCards = new CardSet();
	}

	public CardSet getSetOfCards() {
		return setOfCards;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void TakeCard(Card card){
		this.setOfCards.setCards(card);
	}
	
}
