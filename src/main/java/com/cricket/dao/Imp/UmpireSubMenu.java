package com.cricket.dao.Imp;

import java.util.List;
import java.util.Scanner;

import com.cricket.Entity.Umpire;
import com.cricket.dao.UmpireDAO;

public class UmpireSubMenu {

    // Main menu for managing umpires
    public static void manageUmpires(Scanner scanner) {
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
                case 1: addUmpire(scanner);
                    break;
                case 2: viewAllUmpires();
                    break;
                case 3: updateUmpire(scanner);
                    break;
                case 4: deleteUmpire(scanner);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);
    }

    // Method to add an umpire
    private static void addUmpire(Scanner scanner) {
        UmpireDAO umpireDAO = new UmpireDAO();
        scanner.nextLine(); 
        Umpire umpire = new Umpire();

        System.out.print("Enter Umpire Name: ");
        umpire.setName(scanner.nextLine());
        System.out.print("Enter Umpire Experience (in years): ");
        int experience;
        do {
            experience = scanner.nextInt();
            if (experience < 2) {
                System.out.println("Umpire must have at least 2 years of experience. Please re-enter.");
            }
        } while (experience < 2);
        umpire.setExperience(experience);


        umpireDAO.save(umpire);
        System.out.println("Umpire saved successfully!");
    }

    // Method to view all umpires
    private static void viewAllUmpires() {
        UmpireDAO umpireDAO = new UmpireDAO();
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
    }

    // Method to update an umpire
    private static void updateUmpire(Scanner scanner) {
        UmpireDAO umpireDAO = new UmpireDAO();

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
    }

    // Method to delete an umpire
    private static void deleteUmpire(Scanner scanner) {
        UmpireDAO umpireDAO = new UmpireDAO();

        System.out.print("Enter Umpire ID to delete: ");
        int umpireIdToDelete = scanner.nextInt();
        Umpire umpireToDelete = umpireDAO.findById(Umpire.class, umpireIdToDelete);

        if (umpireToDelete != null) {
            umpireDAO.delete(Umpire.class, umpireIdToDelete);
            System.out.println("Umpire deleted successfully!");
        } else {
            System.out.println("Umpire not found.");
        }
    }
}
