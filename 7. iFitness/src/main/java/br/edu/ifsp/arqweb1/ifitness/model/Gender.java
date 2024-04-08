package br.edu.ifsp.arqweb1.ifitness.model;

public enum Gender {
    MALE("Male"),
    FEMALE("Female"),
    OTHER("Other"),
    IDK("Idk");

    private String description;

    Gender(String string) {
        this.description = string;
    }

    public String getDescription() {
        return description;
    }
}