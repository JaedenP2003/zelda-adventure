package models;

/*
 Represents the user-controlled hero.

 Encapsulation protects internal state.
*/
public class Player {

    private String name;
    private int health;
    private Weapon weapon;

    public Player(String name, int health, Weapon weapon) {
        this.name = name;
        this.health = health;
        this.weapon = weapon;
    }

    public int attack() {
        return weapon.getDamage();
    }

    public void takeDamage(int damage) {
        health -= damage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int getHealth() {
        return health;
    }

    // Allows weapon replacement when enemies drop better gear
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public void printStats() {

        System.out.println("\n=== HERO ===");
        System.out.println("Name: " + name);
        System.out.println("Hearts: " + health);
        System.out.println("Weapon: " + weapon.getName());
        System.out.println("Damage: " + weapon.getDamage());
    }
}
