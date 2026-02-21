package services;

import models.*;

import java.util.Random;

/*
 Centralizes randomness.

 Prevents scattered Random objects
 across the codebase.
*/
public class RandomService {

    private Random random = new Random();

    public boolean chance(int percent) {
        return random.nextInt(100) < percent;
    }

    public Enemy randomEnemy() {

        String[] names = {
                "Moblin",
                "Shadow Bat",
                "Stone Talus"
        };

        String name = names[random.nextInt(names.length)];

        int health = 10 + random.nextInt(6);
        int damage = 3 + random.nextInt(4);

        return new Enemy(name, health, damage);
    }

    public Weapon randomWeapon() {

        String[] weapons = {
                "Knight Sword",
                "Forest Spear",
                "Ancient Blade"
        };

        int damage = 6 + random.nextInt(5);

        return new Weapon(
                weapons[random.nextInt(weapons.length)],
                damage
        );
    }

    public Location randomLocation() {

        String[] locations = {
                "Lost Woods",
                "Gerudo Desert",
                "Lanayru Wetlands"
        };

        return new Location(
                locations[random.nextInt(locations.length)]
        );
    }
}
