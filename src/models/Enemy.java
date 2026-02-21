package models;

/*
 Represents hostile creatures encountered
 during exploration.
*/
public class Enemy {

    private String name;
    private int health;
    private int damage;

    public Enemy(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public int attack() {
        return damage;
    }

    public void takeDamage(int amount) {
        health -= amount;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public String getName() {
        return name;
    }
}
