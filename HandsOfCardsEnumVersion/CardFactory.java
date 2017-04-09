package HandsOfCardsEnumVersion;

import java.security.InvalidParameterException;
import java.util.ArrayList;

public  class CardFactory {
	
	public CardFactory(){}
	
	public Card MadeCard(String input) throws InvalidParameterException{
		char powerChar;
		char typeChar;
		Power powerEnum = null;
		Type typeEnum = null;
		int powerInt = 0;
		Card currCard;
				
		if(input.length() > 2){
			throw new InvalidParameterException("Wrong parameter");
		}		
		
		try{
			powerChar = VerifyPower(input.toLowerCase().charAt(0));
		}catch (InvalidParameterException e){
			throw e;
		}
		
		typeChar = input.toLowerCase().charAt(1);
		
		
								
		switch(powerChar){	
		case 'j':
			powerEnum = Power.J;
			break;
		case 'q': 
			powerEnum = Power.Q;
			break;			
		case 'k':
			powerEnum = Power.K;
			break;
		case 'a':
			powerEnum = Power.A;
			break;		
		default:
			powerInt = Character.getNumericValue(powerChar);							
			break;
		}								
		
		switch(typeChar){	
		case 's':
			typeEnum = Type.S;
			break;
		case 'h': 
			typeEnum = Type.H;
			break;			
		case 'd':
			typeEnum = Type.D;
			break;
		case 'c':
			typeEnum = Type.C;
			break;
		default:
			throw new InvalidParameterException("The type of the card must be [S,H,D,C]");
		}
		
		if(powerEnum != null){
			 currCard = new Card(powerEnum, typeEnum);
		}else{
			 currCard = new Card(powerInt, typeEnum);
		}			
									
		return currCard;
	}
	
	private char VerifyPower(char power) throws InvalidParameterException {
		boolean differentArg = false;
		ArrayList<Character> allowedPowers = new ArrayList<Character>();
		allowedPowers.add('j');
		allowedPowers.add('q');
		allowedPowers.add('k');
		allowedPowers.add('a');
		
		if(!allowedPowers.contains(power) && ((Character.getNumericValue(power) < 2) || (Character.getNumericValue(power) > 9))){
			differentArg = true;
		}
		
		if(differentArg){
			throw new InvalidParameterException("The power of the card must be [number between 2 to 9 or J,Q,K,A]");
		}else{
			return power;
		}					
	}
	
}
