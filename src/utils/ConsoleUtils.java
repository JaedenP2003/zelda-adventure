package utils;

/*
 Utility class for console formatting.

 Keeps UI text out of the engine,
 making code cleaner.
*/
public class ConsoleUtils {

    public static void printTitle() {

        System.out.println("=================================");
        System.out.println("      LEGENDS OF THE CONSOLE     ");
        System.out.println("=================================");
    }

    public static void printMenu() {

        System.out.println("\nChoose an action:");
        System.out.println("1. Explore");
        System.out.println("2. View Hero");
        System.out.println("3. Quit");
    }
}
