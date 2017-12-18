package javaApp.models;

public enum ResourceType {	
	Video(1), Presentation(2), Document(3), Other(4);
	
	private int value;
	
	private ResourceType(int value) {
		this.value = value;
	}
}
