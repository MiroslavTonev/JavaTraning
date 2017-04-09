package HandsOfCardsEnumVersion;

import java.security.InvalidParameterException;

public class HandsOfCardsMainProgram {

	public static void main(String[] args) {
		Player gosho = new Player("Gosho");		
		CardFactory cardFactory = new CardFactory();
		
	
		System.out.println(gosho.getSetOfCards().GetCardsetValue());
	
		 			
		//2C, 4H, 9H, AS, QS, JD, JD
		try{
			Card a = cardFactory.MadeCard("2c");
			Card b = cardFactory.MadeCard("4H");
			Card c = cardFactory.MadeCard("9H");
			Card d = cardFactory.MadeCard("AS");
			Card e = cardFactory.MadeCard("QS");
			Card f = cardFactory.MadeCard("JD");
//			Card g = cardFactory.MadeCard("JD");
			
			gosho.TakeCard(a);
			gosho.TakeCard(b);
			gosho.TakeCard(c);
			gosho.TakeCard(d);
			gosho.TakeCard(e);
			gosho.TakeCard(f);
//			gosho.TakeCard(g);
		}catch (InvalidParameterException e){
			System.out.println(e.getMessage());
		}
		
		    
		System.out.println(gosho.getSetOfCards().GetCardsetValue());

	}

}
