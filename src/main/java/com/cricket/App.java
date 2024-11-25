package com.cricket;

import com.cricket.dao.*;
import com.cricket.Entity.*;

import java.util.List;
import java.util.Scanner;

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
            System.out.println("5. Manage Venues");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1: managePlayers(scanner);
                    break;
                case 2: manageBatters(scanner);
                    break;
                case 3: manageBowlers(scanner);
                    break;
                case 4: manageUmpires(scanner);
                    break;
                case 5: manageVenues(scanner);
                    break;
                case 6: System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 6);

        scanner.close();
    }

    // Manage Players
   /* private static void managePlayers(Scanner scanner) {
    	PlayerDAO playerDAO = new PlayerDAO();

        int choice;

        do {
            System.out.println("\n=== Manage Players ===");
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    Player player = new Player();
                    System.out.print("Enter Player Name: ");
                    player.setName(scanner.nextLine());
                    System.out.print("Enter Player Role (Batter/Bowler/All-rounder): ");
                    player.setRole(scanner.nextLine());
                    System.out.print("Enter Player Team: ");
                    player.setTeam(scanner.nextLine());

                    playerDAO.save(player);
                    System.out.println("Player saved successfully!");
                    break;
                case 2:
                    System.out.println("=== All Players ===");
                    // Fetch and display all players (mocked here)
                    // Add functionality to fetch from DB if needed
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
    */
    
    private static void managePlayers(Scanner scanner) {
        PlayerDAO playerDAO = new PlayerDAO();
        int choice;

        do {
            System.out.println("\n=== Manage Players ===");
            System.out.println("1. Add Player");
            System.out.println("2. View All Players");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    Player player = new Player();
                    System.out.print("Enter Player Name: ");
                    player.setName(scanner.nextLine());
                    System.out.print("Enter Player Role (Batter/Bowler/All-rounder): ");
                    player.setRole(scanner.nextLine());
                    System.out.print("Enter Player Team: ");
                    player.setTeam(scanner.nextLine());

                    playerDAO.save(player);
                    System.out.println("Player saved successfully!");
                    break;

                case 2:
                    System.out.println("=== All Players ===");
                    List<Player> players = playerDAO.findAll(Player.class);
                    if (players.isEmpty()) {
                        System.out.println("No players found.");
                    } else {
                        for (Player p : players) {
                            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Role: " + p.getRole() + ", Team: " + p.getTeam());
                        }
                    }
                    break;

                case 3:
                    return; // Back to main menu

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }


    // Manage Batters
    private static void manageBatters(Scanner scanner) {
    	BatterDAO batterDAO = new BatterDAO();
        int choice;

        do {
            System.out.println("\n=== Manage Batters ===");
            System.out.println("1. Add Batter");
            System.out.println("2. View All Batters");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    Batter batter = new Batter();
                    System.out.print("Enter Player ID: ");
                    int playerId = scanner.nextInt();
                    batter.setPlayer(new Player()); // Assume Player already exists
                    batter.getPlayer().setId(playerId);

                    System.out.print("Enter Matches Played: ");
                    batter.setMatches(scanner.nextInt());
                    System.out.print("Enter Total Runs: ");
                    batter.setRuns(scanner.nextInt());
                    System.out.print("Enter Highest Score: ");
                    batter.setHighestScore(scanner.nextInt());

                    batterDAO.save(batter);
                    System.out.println("Batter saved successfully!");
                    break;
                case 2:
                    System.out.println("=== All Batters ===");
                    // Fetch and display all batters (mocked here)
                    // Add functionality to fetch from DB if needed
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    // Manage Bowlers
    private static void manageBowlers(Scanner scanner) {
    	BowlerDAO bowlerDAO = new BowlerDAO();
        int choice;

        do {
            System.out.println("\n=== Manage Bowlers ===");
            System.out.println("1. Add Bowler");
            System.out.println("2. View All Bowlers");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
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
                    break;
                case 2:
                    System.out.println("=== All Bowlers ===");
                    // Fetch and display all bowlers
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    // Manage Umpires
    private static void manageUmpires(Scanner scanner) {
    	UmpireDAO umpireDAO = new UmpireDAO();
        int choice;

        do {
            System.out.println("\n=== Manage Umpires ===");
            System.out.println("1. Add Umpire");
            System.out.println("2. View All Umpires");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    Umpire umpire = new Umpire();
                    System.out.print("Enter Umpire Name: ");
                    umpire.setName(scanner.nextLine());
                    System.out.print("Enter Matches Officiated: ");
                    umpire.setMatchesOfficiated(scanner.nextInt());

                    umpireDAO.save(umpire);
                    System.out.println("Umpire saved successfully!");
                    break;
                case 2:
                    System.out.println("=== All Umpires ===");
                    // Fetch and display all umpires
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }

    // Manage Venues
    private static void manageVenues(Scanner scanner) {
    	VenueDAO venueDAO = new VenueDAO();
        int choice;

        do {
            System.out.println("\n=== Manage Venues ===");
            System.out.println("1. Add Venue");
            System.out.println("2. View All Venues");
            System.out.println("3. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    Venue venue = new Venue();
                    System.out.print("Enter Venue Name: ");
                    venue.setName(scanner.nextLine());
                    System.out.print("Enter Venue City: ");
                    venue.setCity(scanner.nextLine());
                    System.out.print("Enter Venue Capacity: ");
                    venue.setCapacity(scanner.nextInt());

                    venueDAO.save(venue);
                    System.out.println("Venue saved successfully!");
                    break;
                case 2:
                    System.out.println("=== All Venues ===");
                    // Fetch and display all venues
                    break;
                case 3:
                    return; // Back to main menu
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);
    }
}

