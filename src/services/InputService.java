package services;

import java.util.Scanner;

/*
 Handles ALL console input.

 Using one Scanner avoids
 a classic Java bug.
*/
public class InputService {

    private Scanner scanner = new Scanner(System.in);

    public String nextLine() {
        return scanner.nextLine();
    }

    public int nextInt() {

        int value = scanner.nextInt();
        scanner.nextLine(); // clears buffer

        return value;
    }
}
