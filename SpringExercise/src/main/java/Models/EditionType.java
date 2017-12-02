package Models;

public enum EditionType {
	NORMAL(1), PROMO(2), GOLD(3);
	
	private int value;
	
	private EditionType(int type){
		this.value = type;
		
	}
}
