package br.edu.ifsp.arqweb1.ifitness.model;

public enum ActivityType {
	
	RACE("Race"),
    HIKE("Hike"),
    CYCLING("Cycling"),
    SWIM("Swim");
	
	private String description;
	
	ActivityType(String string) {
		this.description = string;
	}
	
	public String getDescription() {
		return description;
	}
}