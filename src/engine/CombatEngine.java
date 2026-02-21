package engine;

import models.*;

/*
 Handles turn-based combat.

 Separated from GameEngine to follow
 the Single Responsibility Principle.
*/
public class CombatEngine {

    public static boolean fight(Player player, Enemy enemy) {

        System.out.println("A " + enemy.getName() + " approaches!");

        while (player.isAlive() && enemy.isAlive()) {

            // Player attacks first for fairness
            int playerDamage = player.attack();
            enemy.takeDamage(playerDamage);

            System.out.println("You deal " + playerDamage + " damage.");

            if (!enemy.isAlive()) {
                System.out.println("Enemy defeated!");
                return true;
            }

            int enemyDamage = enemy.attack();
            player.takeDamage(enemyDamage);

            System.out.println(enemy.getName()
                    + " hits you for " + enemyDamage);
            System.out.println("Hearts remaining: "
                    + player.getHealth());
        }

        return false;
    }
}
