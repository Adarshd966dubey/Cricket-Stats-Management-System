package com.cricket;

import com.cricket.dao.*;
import com.cricket.Entity.*;
import java.util.*;

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
                case 1: managePlayers(scanner);
                    break;
                case 2: manageBatters(scanner);
                    break;
                case 3: manageBowlers(scanner);
                    break;
                case 4: manageUmpires(scanner);
                    break;
                case 5: System.out.println("Exiting the application. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (mainChoice != 5);

        scanner.close();
    }
    
    //manage players 
    private static void managePlayers(Scanner scanner) {
        PlayerDAO playerDAO = new PlayerDAO();
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
                case 1: // Add Player
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
                    break;

                case 2: // View All Players
                    System.out.println("------- All Players -------");
                    List<Player> players = playerDAO.findAll(Player.class);
                    if (players.isEmpty()) {
                        System.out.println("No players found.");
                    } else {
                        for (Player p : players) {
                            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Role: " + p.getRole() + ", Team: " + p.getTeam());
                        }
                    }
                    break;

                case 3: // Update Player
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
                    break;

                case 4: // Delete Player
                	System.out.print("Enter Player ID to delete: ");
                    int id = scanner.nextInt();
                    playerDAO.delete(id);  
                    break;

                case 5:
                    return; 

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

   

 // Manage Batters
    private static void manageBatters(Scanner scanner) {
        BatterDAO batterDAO = new BatterDAO();
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
                case 1: // Add Batter
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
                    System.out.print("Enter Highest Score: ");
                    batter.setHighestScore(scanner.nextInt());

                    batterDAO.save(batter);
                    System.out.println("Batter saved successfully!");
                    break;

                case 2: // View All Batters
                    System.out.println("=== All Batters ===");
                    List<Batter> batters = batterDAO.findAll(Batter.class);
                    if (batters.isEmpty()) {
                        System.out.println("No batters found.");
                    } else {
                        for (Batter b : batters) {
                            System.out.println("ID: " + b.getId() + ", Player ID: " + b.getPlayer().getId() + ", Matches: " + b.getMatches() + ", Runs: " + b.getRuns() + ", Highest Score: " + b.getHighestScore());
                        }
                    }
                    break;

                case 3: // Update Batter
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
                    break;

                case 4: // Delete Batter
                	 System.out.print("Enter Batter ID to delete: ");
                     int id = scanner.nextInt();
                     batterDAO.delete(id); 
                     break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    // manage Bowlers 
    private static void manageBowlers(Scanner scanner) {
        BowlerDAO bowlerDAO = new BowlerDAO();
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
                case 1: // Add Bowler
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
                    break;

                case 2: // View All Bowlers
                    System.out.println("--------- All Bowlers ---------");
                    List<Bowler> bowlers = bowlerDAO.findAll(Bowler.class);
                    if (bowlers.isEmpty()) {
                        System.out.println("No bowlers found.");
                    } else {
                        for (Bowler b : bowlers) {
                            System.out.println("ID: " + b.getId() + ", Player ID: " + b.getPlayer().getId() + ", Wickets: " + b.getWickets() + ", Economy: " + b.getEconomy());
                        }
                    }
                    break;

                case 3: // Update Bowler
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
                    break;

                case 4: // delete Bowler
                    System.out.print("Enter Bowler ID to delete: ");
                    int bowlerIdToDelete = scanner.nextInt();
                    bowlerDAO.delete(Bowler.class, bowlerIdToDelete);
                    System.out.println("Bowler deleted successfully!");
                    break;

                case 5:
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    // Manage Umpires
    private static void manageUmpires(Scanner scanner) {
        UmpireDAO umpireDAO = new UmpireDAO();
        int choice;

        do {
            System.out.println("\n--------- Manage Umpires ---------");
            System.out.println("1. Add Umpire");
            System.out.println("2. View All Umpires");
            System.out.println("3. Update Umpire");
            System.out.println("4. Delete Umpire");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    scanner.nextLine(); // Consume newline
                    Umpire umpire = new Umpire();

                    System.out.print("Enter Umpire Name: ");
                    umpire.setName(scanner.nextLine());

                    System.out.print("Enter Umpire Experience (in years): ");
                    umpire.setExperience(scanner.nextInt());

                    umpireDAO.save(umpire);
                    System.out.println("Umpire saved successfully!");
                    break;

                case 2:
                    System.out.println("--------- All Umpires ---------");
                    List<Umpire> umpires = umpireDAO.findAll(Umpire.class);
                    if (umpires.isEmpty()) {
                        System.out.println("No umpires found.");
                    } else {
                        for (Umpire u : umpires) {
                            System.out.println("Umpire ID: " + u.getId() +
                                    ", Name: " + u.getName() +
                                    ", Experience: " + u.getExperience() + " years");
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Umpire ID to update: ");
                    int umpireIdToUpdate = scanner.nextInt();
                    Umpire umpireToUpdate = umpireDAO.findById(Umpire.class, umpireIdToUpdate);

                    if (umpireToUpdate != null) {
                        scanner.nextLine();
                        System.out.print("Enter new Umpire Name: ");
                        umpireToUpdate.setName(scanner.nextLine());
                        System.out.print("Enter new Experience (years): ");
                        umpireToUpdate.setExperience(scanner.nextInt());

                        umpireDAO.update(umpireToUpdate);
                        System.out.println("Umpire updated successfully!");
                    } else {
                        System.out.println("Umpire not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Umpire ID to delete: ");
                    int umpireIdToDelete = scanner.nextInt();
                    umpireDAO.delete(Umpire.class, umpireIdToDelete);
                    System.out.println("Umpire deleted successfully!");
                    break;

                case 5:
                    return; 

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }
}

