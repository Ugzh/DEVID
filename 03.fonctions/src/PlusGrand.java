import java.util.Scanner;

public class PlusGrand {

    void better(){
        Scanner scanner;
        int[] values;
        int sum;
        int maxValue;
        double average;
        String message;
        String showArray;

        scanner = new Scanner(System.in);
        values = new int[3];
        showArray = "";
        sum = 0;
        maxValue = Integer.MIN_VALUE;

        System.out.println("Entrer un nombre entier");
        values[0] = scanner.nextInt();
        System.out.println("Entrer votre 2eme nombre entier");
        values[1] = scanner.nextInt();
        System.out.println("Entrer votre 3eme nombre entier");
        values[2] = scanner.nextInt();

        for(int i = 0; i < values.length; i++){
            sum += values[i];
            showArray += values[i] + ", ";
            if(values[i] > maxValue)
                maxValue = values[i];
        }

        average = (double) sum / values.length;
        message = "Le tableau obtenu : " + showArray + "\n" + "La moyenne est : " + average + "\n" + "La plus grande valeur est : " + maxValue + "\n";
        System.out.println(message);
        scanner.close();
    }
}


