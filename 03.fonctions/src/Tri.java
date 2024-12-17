import java.util.Scanner;

public class Tri {
    void tri(){
        Scanner scanner;
        int[] arr;
        int tmp;
        boolean isSorted;
        String showArray;
        String sortedArray;

        scanner = new Scanner(System.in);
        arr = new int[6];
        sortedArray = "";
        showArray = "";
        isSorted = false;

        System.out.println("Entrer un nombre entier");
        arr[0] = scanner.nextInt();
        System.out.println("Entrer un 2eme nombre entier");
        arr[1] = scanner.nextInt();
        System.out.println("Entrer un 3eme nombre entier");
        arr[2] = scanner.nextInt();
        System.out.println("Entrer un 4eme nombre entier");
        arr[3] = scanner.nextInt();
        System.out.println("Entrer un 5eme nombre entier");
        arr[4] = scanner.nextInt();
        System.out.println("Entrer un 6eme nombre entier");
        arr[5] = scanner.nextInt();

        for (int value : arr){
            showArray += value + ",";
        }

        System.out.println("Le tableau obtenu est : " + showArray);

        // Methode pas optimisée pour faire le tri par bulle
//        while(i < arr.length){
//            for (int j = 0; j < arr.length -1 ; j++ ){
//                if(arr[j] > arr[j +1]){
//                    tmp = arr[j]; // stock la valeur actuelle
//                    arr[j] = arr[j + 1]; // attribue à la valeur actuelle la valeur inférieure
//                    arr[j + 1] = tmp; // attribue la valeur supérieure au prochain afin de pouvoir effectuer la prochaine comparaison
//                }
//            }
//            i++;
//        }

        while (!isSorted){
            isSorted = true;
            for (int j = 0; j < arr.length -1 ; j++ ){
                if(arr[j] > arr[j +1]){
                    tmp = arr[j]; // stock la valeur actuelle
                    arr[j] = arr[j + 1]; // attribue à la valeur actuelle la valeur inférieure
                    arr[j + 1] = tmp; // attribue la valeur supérieure au prochain afin de pouvoir effectuer la prochaine comparaison
                    isSorted = false;
                }
            }

            /* for (int value : arr){
                sortedArray += value + ",";
            } */ // permet de printer les tableaux

            if(isSorted){
                break;
            }
        }

        for (int value : arr){
            sortedArray += value + ",";
        }

        System.out.println("Le tableau obtenu est : " + sortedArray);
    }
}
