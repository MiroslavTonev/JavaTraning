package javaApp.models;

public enum ContentType {	
	pdf(1), zip(2);
	
	private int value;
	
	private ContentType(int value) {
		this.value = value;
	}
	
}
