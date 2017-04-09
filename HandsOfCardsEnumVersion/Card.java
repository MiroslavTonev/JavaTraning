package HandsOfCardsEnumVersion;


public class Card {
	private int value;
	private Power power;
	private Type type;
	private int powerInt;
	

	public Card(Power power, Type type){
		this.setPower(power);
		this.setType(type);
	}
	
	public Card(int powerInt, Type type){
		this.setPowerInt(powerInt);
		this.setType(type);
	}

	public int getValue() {
		this.DefineTheValue();
		return value;
	}
	

	public Power getPower() {
		return power;
	}

	public void setPower(Power power) {
		this.power = power;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public int getPowerInt() {	
		return powerInt;
	}

	public void setPowerInt(int powerInt) {
		this.powerInt = powerInt;
	}



	private void DefineTheValue(){	
		int currentPower = 0;
		int typeAsInt = 0; 
					
		
		if(this.power != null){
			switch(this.power){	
				case J:
					currentPower = Power.J.getValue();
					break;
				case Q: 
					currentPower = Power.Q.getValue();
					break;			
				case K:
					currentPower = Power.K.getValue();
					break;
				case A:
					currentPower = Power.A.getValue();
					break;					
			}		
		}else{
			currentPower = this.powerInt;			
		}
						
			
			switch(this.type){	
			case S:
				typeAsInt = Type.S.getValue();
				break;
			case H: 
				typeAsInt = Type.H.getValue();
				break;			
			case D:
				typeAsInt = Type.D.getValue();
				break;
			case C:
				typeAsInt = Type.C.getValue();
				break;										
		}						
			this.value = currentPower * typeAsInt;
	}
}
