public class Main {
    public static void main(String[] args) {
        int[] arr = {5,8,1,3};
        int[] arr2 = new int[arr.length + 1];

        // à optimiser, faire boucle simple + ajouter la dernière valeur à la main
//        for(int i = 0; i < arr2.length; i++){
//            while( i < arr.length){
//                arr2[i] = arr[i];
//                System.out.println(arr2[i]);
//                i++;
//            }
//            arr2[i] = 4;
//            System.out.println(arr2[i]);
//        }

        for(int i = 0; i < arr.length; i++){
            arr2[i] = arr[i];
        }

        arr2[arr2.length - 1] = 4;

        for(int value: arr2){
            System.out.println(value);
        }
    }
}
