import java.util.Scanner;


public class Multiplication {
    void multiple(){
        Scanner scanner = new Scanner(System.in);
        int nb;
        String sentence;
        sentence = "";

        System.out.println("Entrez un nombre pour voir sa table de multiplication");
        nb = scanner.nextInt();

        for(int i = 1; i < 11; i++){
            sentence += nb + " x " + i + " = " + (i * nb)+"\n";
        }

        System.out.println(sentence);
        scanner.close();
    }
}
