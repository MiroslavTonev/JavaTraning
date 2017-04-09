package HandsOfCardsEnumVersion;

public enum Type {
	S(4), H(3), D(2), C(1);
	 
	private int value;
	
	private Type(int value){
		this.value = value;
	}
	
	public int getValue(){
		return this.value;
	}
}
