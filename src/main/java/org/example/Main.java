package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private final Map<String, Customer> database = new HashMap<>();
    Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {
        while (true) {
            System.out.println("Välkommen till vårat CRM-system");
            System.out.println("1. Lägg till ny kund");
            System.out.println("2. Lägg till e-post för kund");
            System.out.println("3. Ta bort e-post från kund");
            System.out.println("4. Lägg till tag för kund");
            System.out.println("5. Lägg till anteckningar");
            System.out.println("6. Sök kund");
            System.out.println("7. Lista all kunder");
            System.out.println("8. Avsluta");
            System.out.print("Val: ");
            int userChoice = Integer.parseInt(scanner.nextLine()); // Assumes "nice" input, should be try/catch
            switch (userChoice) {
                case 1 -> addCustomer();
                case 2 -> addEmail();
                case 3 -> removeEmail();
                case 4 -> addTag();
                case 5 -> addNote();
                case 6 -> searchCustomer();
                case 7 -> listCustomers();
                case 8 -> { return; }
                default -> System.out.println("Ogiltigt val\n");
            }
        }
    }

    private void addCustomer() {
        System.out.print("Mata in kund-ID: ");
        String id = scanner.nextLine();
        System.out.print("Mata in kundens namn: ");
        String name = scanner.nextLine();
        database.put(id, new Customer(id, name));
        System.out.println("Kunden har lagts till.\n");
    }

    private void addEmail() {}

    private void removeEmail() {}

    private void addTag() {}

    private void addNote() {}

    private void searchCustomer() {}

    private void listCustomers() {
        System.out.println("Samtliga kunder: ");
        for (Customer customer : database.values()) {
            System.out.println(customer);
        }
    }
}
