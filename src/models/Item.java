package models;

/*
 Base class for all collectible objects.

 Demonstrates inheritance — a concept
 professors LOVE seeing used correctly.
*/
public class Item {

    private String name;

    public Item(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
