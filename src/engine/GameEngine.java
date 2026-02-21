package engine;

import models.*;
import services.*;
import utils.ConsoleUtils;

/*
 Controls the high-level flow of the game.

 Responsibilities:
 - Creating the player
 - Running the game loop
 - Handling exploration
 - Determining win/lose states
*/
public class GameEngine {

    private Player player;
    private InputService input;
    private RandomService random;

    private int enemiesDefeated = 0;
    private final int WIN_CONDITION = 5;

    public GameEngine() {
        input = new InputService();
        random = new RandomService();
    }

    // Starts the game
    public void start() {

        ConsoleUtils.printTitle();

        System.out.print("Enter your hero's name: ");
        String name = input.nextLine();

        Weapon starter = new Weapon("Traveler's Blade", 5);
        player = new Player(name, 20, starter);

        gameLoop();
    }

    /*
     Main gameplay loop.
     Runs until player dies or achieves victory.
    */
    private void gameLoop() {

        while (player.isAlive()) {

            ConsoleUtils.printMenu();

            int choice = input.nextInt();

            switch (choice) {
                case 1 -> explore();
                case 2 -> player.printStats();
                case 3 -> {
                    System.out.println("You abandon the quest...");
                    return;
                }
                default -> System.out.println("Invalid option.");
            }

            if (enemiesDefeated >= WIN_CONDITION) {
                System.out.println("\nYou have cleansed the land of evil.");
                System.out.println("Your legend is eternal.");
                return;
            }
        }

        System.out.println("\nThe hero has fallen...");
    }

    /*
     Exploration may trigger combat.
     Randomness keeps the game from feeling scripted.
    */
    private void explore() {

        Location location = random.randomLocation();
        System.out.println("\nYou travel to the " + location.getName());

        if (random.chance(60)) {

            Enemy enemy = random.randomEnemy();

            boolean enemyDefeated =
                    CombatEngine.fight(player, enemy);

            if (enemyDefeated) {
                enemiesDefeated++;

                // Chance to drop a weapon
                if (random.chance(40)) {
                    Weapon drop = random.randomWeapon();
                    System.out.println("Enemy dropped: " + drop.getName());

                    player.setWeapon(drop);
                    System.out.println("You equipped the new weapon!");
                }
            }

        } else {
            System.out.println("The area is quiet...");
        }
    }
}
