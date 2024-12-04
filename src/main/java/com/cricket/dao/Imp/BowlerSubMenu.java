package com.cricket.dao.Imp;

import java.util.List;
import java.util.Scanner;
import com.cricket.Entity.Bowler;
import com.cricket.Entity.Player;
import com.cricket.dao.BowlerDAO;

public class BowlerSubMenu {

    // Main menu for managing bowlers
    public static void manageBowlers(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--------- Manage Bowlers ---------");
            System.out.println("1. Add Bowler");
            System.out.println("2. View All Bowlers");
            System.out.println("3. Update Bowler");
            System.out.println("4. Delete Bowler");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addBowler(scanner);
                    break;
                case 2: viewAllBowlers();
                    break;
                case 3: updateBowler(scanner);
                    break;
                case 4: deleteBowler(scanner);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    // Method for adding a bowler
    private static void addBowler(Scanner scanner) {
        BowlerDAO bowlerDAO = new BowlerDAO();
        scanner.nextLine(); 
        Bowler bowler = new Bowler();

        System.out.print("Enter Player ID: ");
        int playerId = scanner.nextInt();
        bowler.setPlayer(new Player());
        bowler.getPlayer().setId(playerId);

        System.out.print("Enter Wickets Taken: ");
        bowler.setWickets(scanner.nextInt());
        System.out.print("Enter Bowling Economy: ");
        bowler.setEconomy(scanner.nextDouble());

        bowlerDAO.save(bowler);
        System.out.println("Bowler saved successfully!");
    }

    // Method for viewing all bowlers
    private static void viewAllBowlers() {
        BowlerDAO bowlerDAO = new BowlerDAO();
        System.out.println("--------- All Bowlers ---------");
        List<Bowler> bowlers = bowlerDAO.findAll(Bowler.class);

        if (bowlers.isEmpty()) {
            System.out.println("No bowlers found.");
        } else {
            for (Bowler b : bowlers) {
                System.out.println("ID: " + b.getId() + ", Player ID: " + b.getPlayer().getId() +
                        ", Wickets: " + b.getWickets() + ", Economy: " + b.getEconomy());
            }
        }
    }

    // Method for updating a bowler
    private static void updateBowler(Scanner scanner) {
        BowlerDAO bowlerDAO = new BowlerDAO();

        System.out.print("Enter Bowler ID to update: ");
        int bowlerIdToUpdate = scanner.nextInt();
        Bowler bowlerToUpdate = bowlerDAO.findById(Bowler.class, bowlerIdToUpdate);

        if (bowlerToUpdate != null) {
            System.out.print("Enter new Wickets Taken: ");
            bowlerToUpdate.setWickets(scanner.nextInt());
            System.out.print("Enter new Bowling Economy: ");
            bowlerToUpdate.setEconomy(scanner.nextDouble());

            bowlerDAO.update(bowlerToUpdate);
            System.out.println("Bowler updated successfully!");
        } else {
            System.out.println("Bowler not found.");
        }
    }

    // Method for deleting a bowler
    private static void deleteBowler(Scanner scanner) {
        BowlerDAO bowlerDAO = new BowlerDAO();

        System.out.print("Enter Bowler ID to delete: ");
        int bowlerIdToDelete = scanner.nextInt();
        Bowler bowlerToDelete = bowlerDAO.findById(Bowler.class, bowlerIdToDelete);

        if (bowlerToDelete != null) {
            bowlerDAO.delete(Bowler.class, bowlerIdToDelete);
            System.out.println("Bowler deleted successfully!");
        } else {
            System.out.println("Bowler not found.");
        }
    }
}

