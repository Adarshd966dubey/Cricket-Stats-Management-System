package com.cricket.dao.Imp;

import java.util.List;
import java.util.Scanner;
import com.cricket.Entity.Batter;
import com.cricket.Entity.Player;
import com.cricket.dao.BatterDAO;

public class BatterSubMenu {

    // Main menu for managing batters
    public static void manageBatters(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--------- Manage Batters ---------");
            System.out.println("1. Add Batter");
            System.out.println("2. View All Batters");
            System.out.println("3. Update Batter");
            System.out.println("4. Delete Batter");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addBatter(scanner);
                    break;
                case 2:
                    viewAllBatters();
                    break;
                case 3:
                    updateBatter(scanner);
                    break;
                case 4:
                    deleteBatter(scanner);
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    // Method for adding a batter
    private static void addBatter(Scanner scanner) {
        BatterDAO batterDAO = new BatterDAO();
        scanner.nextLine(); // Consume newline
        Batter batter = new Batter();

        System.out.print("Enter Player ID: ");
        int playerId = scanner.nextInt();
        batter.setPlayer(new Player());
        batter.getPlayer().setId(playerId);

        System.out.print("Enter Matches Played: ");
        batter.setMatches(scanner.nextInt());
        
        System.out.print("Enter Total Runs: ");
        batter.setRuns(scanner.nextInt());
        
        int highestScore;
        do {
            System.out.print("Enter Highest Score: ");
            highestScore = scanner.nextInt();

            if (highestScore > batter.getRuns()) {
                System.out.println("Highest Score cannot be greater than Total Runs. Please enter a valid score.");
            }
        } while (highestScore > batter.getRuns());
        batter.setHighestScore(highestScore);

        batterDAO.save(batter);
        System.out.println("Batter saved successfully!");
    }

    // Method for viewing all batters
    private static void viewAllBatters() {
        BatterDAO batterDAO = new BatterDAO();
        System.out.println("=== All Batters ===");
        List<Batter> batters = batterDAO.findAll(Batter.class);

        if (batters.isEmpty()) {
            System.out.println("No batters found.");
        } else {
            for (Batter b : batters) {
                System.out.println("ID: " + b.getId() + ", Player ID: " + b.getPlayer().getId() +
                        ", Matches: " + b.getMatches() + ", Runs: " + b.getRuns() +
                        ", Highest Score: " + b.getHighestScore());
            }
        }
    }

    // Method for updating a batter
    private static void updateBatter(Scanner scanner) {
        BatterDAO batterDAO = new BatterDAO();

        System.out.print("Enter Batter ID to update: ");
        int updateId = scanner.nextInt();
        Batter batterToUpdate = batterDAO.findById(Batter.class, updateId);

        if (batterToUpdate != null) {
            System.out.print("Enter New Matches Played: ");
            batterToUpdate.setMatches(scanner.nextInt());
            System.out.print("Enter New Total Runs: ");
            batterToUpdate.setRuns(scanner.nextInt());
            System.out.print("Enter New Highest Score: ");
            batterToUpdate.setHighestScore(scanner.nextInt());

            batterDAO.update(batterToUpdate);
            System.out.println("Batter updated successfully!");
        } else {
            System.out.println("Batter not found.");
        }
    }

    // Method for deleting a batter
    private static void deleteBatter(Scanner scanner) {
        BatterDAO batterDAO = new BatterDAO();

        System.out.print("Enter Batter ID to delete: ");
        int deleteId = scanner.nextInt();
        Batter batterToDelete = batterDAO.findById(Batter.class, deleteId);

        if (batterToDelete != null) {
            batterDAO.delete(deleteId);
            System.out.println("Batter deleted successfully!");
        } else {
            System.out.println("Batter not found.");
        }
    }
}

