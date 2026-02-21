package models;

/*
 Represents areas the player can explore.

 Currently lightweight —
 intentionally designed for expansion.
*/
public class Location {

    private String name;

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
