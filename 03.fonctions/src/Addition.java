import java.util.Scanner;

public class Addition {

    void addition() {
        Scanner scanner;
        String choice;
        int nb1, nb2;

        scanner = new Scanner(System.in);

        do {
            System.out.println("Entrer un nombre entier : ");
            nb1 = scanner.nextInt();
            System.out.println("Entrer un 2eme nombre entier : ");
            nb2 = scanner.nextInt();
            System.out.println(nb1 + " + " + nb2 + " = " + (nb1 + nb2));
            System.out.println("Voulez-vous recommencer ?");
            choice = scanner.next();
        } while (choice.equals("oui") || choice.equalsIgnoreCase("o") || choice.equals("Oui"));

        System.out.println("Terminé");
        scanner.close();
    }
}
