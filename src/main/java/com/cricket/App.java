package com.cricket;

import java.util.Scanner;

import com.cricket.dao.Imp.BatterSubMenu;
import com.cricket.dao.Imp.BowlerSubMenu;
import com.cricket.dao.Imp.PlayerSubMenu;
import com.cricket.dao.Imp.UmpireSubMenu;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        do {
            // Main Menu
            System.out.println("\n------ Cricket Stats Menu -----");
            System.out.println("1. Manage Players");
            System.out.println("2. Manage Batters");
            System.out.println("3. Manage Bowlers");
            System.out.println("4. Manage Umpires");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1: PlayerSubMenu.managePlayers(scanner);
                    break;
                case 2: BatterSubMenu.manageBatters(scanner);
                    break;
                case 3: BowlerSubMenu.manageBowlers(scanner);
                    break;
                case 4: UmpireSubMenu.manageUmpires(scanner);
                    break;
                case 5: System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 5);

        scanner.close();
    }
}