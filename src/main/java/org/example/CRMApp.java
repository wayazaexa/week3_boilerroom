package org.example;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CRMApp {
    private final Map<String, Customer> database = new HashMap<>();
    private final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CRMApp().run();
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
            int userChoice = -1;
            try {
                userChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {}
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

    private void addEmail() {
        System.out.print("Mata in kund-ID för den kund du vill lägga till e-post för: ");
        String id = scanner.nextLine();
        if (database.containsKey(id)) {
            Customer customer = database.get(id);
            System.out.print("Mata in kundens e-postadress: ");
            String email = scanner.nextLine();
            if (customer.addEmail(email)) {
                database.replace(id, customer);
                System.out.println("E-postadressen har lagts till.\n");
            }
            else {
                System.out.println("E-postadressen fanns redan registrerad för kunden.\n");
            }
        }
        else {
            System.out.println("Detta kund-ID finns inte i databasen.\n");
        }
    }

    private void removeEmail() {
        System.out.print("Mata in kund-ID för den kund du vill ta bort e-post för: ");
        String id = scanner.nextLine();
        if (database.containsKey(id)) {
            Customer customer = database.get(id);
            System.out.print("Mata in den e-postadress: ");
            String email = scanner.nextLine();
            if (customer.removeEmail(email)) {
                database.replace(id, customer);
                System.out.println("E-postadressen har tagits bort.\n");
            }
            else {
                System.out.println("Kunden har inte denna e-postadress registrerad.\n");
            }
        }
        else {
            System.out.println("Detta kund-ID finns inte i databasen.\n");
        }
    }

    private void addTag() {
        System.out.print("Mata in kund-ID för den kund du vill lägga till tag för: ");
        String id = scanner.nextLine();
        if (database.containsKey(id)) {
            Customer customer = database.get(id);
            System.out.print("Mata in den nya taggen: ");
            String tag = scanner.nextLine();
            if (customer.addTag(tag)) {
                database.replace(id, customer);
                System.out.println("Taggen har lagts till.\n");
            }
            else {
                System.out.println("Taggen fanns redan registrerad för kunden.\n");
            }
        }
        else {
            System.out.println("Detta kund-ID finns inte i databasen.\n");
        }
    }

    private void addNote() {
        System.out.print("Mata in kund-ID för den kund du vill lägga till anteckning för: ");
        String id = scanner.nextLine();
        if (database.containsKey(id)) {
            Customer customer = database.get(id);
            System.out.print("Mata in den nya anteckningen: ");
            String note = scanner.nextLine();
            if (customer.addNote(note)) {
                database.replace(id, customer);
                System.out.println("Anteckningen har lagts till.\n");
            }
            else {
                System.out.println("Anteckningen fanns redan registrerad för kunden.\n");
            }
        }
        else {
            System.out.println("Detta kund-ID finns inte i databasen.\n");
        }
    }

    private void searchCustomer() {
        System.out.print("Mata in kund-ID för den kund du vill se information för: ");
        String id = scanner.nextLine();
        if (database.containsKey(id)) {
            System.out.println(database.get(id) + "\n");
        }
        else {
            System.out.println("Detta kund-ID finns inte i databasen.\n");
        }
    }

    private void listCustomers() {
        System.out.println("Samtliga kunder: ");
        for (Customer customer : database.values()) {
            System.out.println(customer.condensedInfo());
        }
        System.out.println();
    }
}
