package com.cricket.dao.Imp;

import java.util.List;
import java.util.Scanner;

import com.cricket.Entity.Player;
import com.cricket.dao.PlayerDAO;

public class PlayerSubMenu {

    // Main menu for managing players
    public static void managePlayers(Scanner scanner) {
        int choice;
        do {
            System.out.println("\n--------- Manage Players ---------");
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Update Player");
            System.out.println("4. Delete Player");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1: addPlayer(scanner);
                    break;
                case 2: viewAllPlayers();
                    break;
                case 3: updatePlayer(scanner);
                    break;
                case 4: deletePlayer(scanner);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    // Method to add a player
    private static void addPlayer(Scanner scanner) {
        PlayerDAO playerDAO = new PlayerDAO();
        scanner.nextLine(); 
        Player player = new Player();

        System.out.print("Enter Player Name: ");
        player.setName(scanner.nextLine());
        System.out.print("Enter Player Role (Batter/Bowler/All-rounder): ");
        player.setRole(scanner.nextLine());
        System.out.print("Enter Player Team: ");
        player.setTeam(scanner.nextLine());

        playerDAO.save(player);
        System.out.println("Player saved successfully!");
    }

    // Method to view all players
    private static void viewAllPlayers() {
        PlayerDAO playerDAO = new PlayerDAO();
        System.out.println("---------- All Players -------------");
        List<Player> players = playerDAO.findAll(Player.class);

        if (players.isEmpty()) {
            System.out.println("No players found.");
        } else {
            for (Player p : players) {
                System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + 
                                   ", Role: " + p.getRole() + ", Team: " + p.getTeam());
            }
        }
    }

    // Method to update a player
    private static void updatePlayer(Scanner scanner) {
        PlayerDAO playerDAO = new PlayerDAO();

        System.out.print("Enter Player ID to update: ");
        int updateId = scanner.nextInt();
        scanner.nextLine(); 
        Player playerToUpdate = playerDAO.findById(Player.class, updateId);

        if (playerToUpdate != null) {
            System.out.print("Enter New Name: ");
            playerToUpdate.setName(scanner.nextLine());
            System.out.print("Enter New Role: ");
            playerToUpdate.setRole(scanner.nextLine());
            System.out.print("Enter New Team: ");
            playerToUpdate.setTeam(scanner.nextLine());

            playerDAO.update(playerToUpdate);
            System.out.println("Player updated successfully!");
        } else {
            System.out.println("Player not found.");
        }
    }

    // Method to delete a player
    private static void deletePlayer(Scanner scanner) {
        PlayerDAO playerDAO = new PlayerDAO();

        System.out.print("Enter Player ID to delete: ");
        int id = scanner.nextInt();
        Player playerToDelete = playerDAO.findById(Player.class, id);

        if (playerToDelete != null) {
            playerDAO.delete(id);
            System.out.println("Player deleted successfully!");
        } else {
            System.out.println("Player not found.");
        }
    }
}
