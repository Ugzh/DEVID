import java.util.Scanner;

public class Majeur {
    void majeur(){
        Scanner scanner = new Scanner(System.in);
        String firstname;
        byte age;
        String minAge;

        System.out.println("Comment vous appelez-vous ? ");
        firstname = scanner.next();
        System.out.println("Quel âge avez-vous ? ");
        age = scanner.nextByte();

        minAge = age >= 18 ? "majeur" : "mineur";

        System.out.println("Bonjour " + firstname + ", vous êtes " + minAge);
        scanner.close();
    }
}
