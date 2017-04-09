package HandsOfCardsEnumVersion;

 public enum Power {
	J(11), Q(12), K(13), A(14);
	
	private int value;
	
	 private Power(int value){
		 this.value = value;
	 }
	 
	 public int getValue(){
		 return this.value;
	 }
	 
}
