package Models;

public enum AgeRestriction {
	MINOR(1), TEEN(2), ADULT(3);
	
	private int value;

	private AgeRestriction(int restrictuion) {
		this.value = restrictuion;
		
	}
	
	
}
