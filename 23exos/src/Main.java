import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Exo 1
        //System.out.println(max(1,2,3));
        //System.out.println(maxWithTernary(1,2,12));

        //Exo 2
        //System.out.println(orderedWithoutCondition(1,3,2));
        //System.out.println(ordered(1,2,3));
        //System.out.println(orderedWithTernary(1,2,3));

        //Exo 3
        //System.out.println(entierFirst(1.0));
        //System.out.println(entierSecond(5.0000001));

        //Exo 4
        //System.out.println(fact(4));
        //System.out.println(factIteration(4));

        //Exo 5
        //System.out.println(maxtab(new int[]{}));

        //6
//        for(int value : reversed(new int[]{1, 2, 3, 4,5, 9, 10, 12 ,43})){
//            System.out.println(value);
//        }

        //7
        //cptab(new int[]{1,2,3,4});
        //cptabSystem(new int[]{1,2,3,4});
        //cptabClass(new int[]{1,2,3,4});
        //cptabArr(new int[]{1,2,3,4});

        //8
        //cptab2dim();
        //cptab2dimCpTab();

        //9
        //extrairePair();

        //10
        //System.out.println(contain("Brocoli", "COL"));

        //11
        //separe("Allez_les_bleus_!");

    }

    public static int max(int int1, int int2, int int3){
        if(int1 > int2 && int1 > int3)
            return int1;
        else if (int2 > int1 && int2 > int3)
            return int2;
        else
            return int3;
    }

    public static int maxWithTernary(int int1, int int2, int int3){
        return int1 > int2 && int1 > int3 ? int1 : int2 > int1 && int2 > int3 ? int2 : int3;
    }

    public static boolean ordered(int int1, int int2, int int3){
        if(int1 < int2 & int2 < int3)
            return true;
        else
            return false;
    }

    public static boolean orderedWithTernary(int int1, int int2, int int3){
        return int1 < int2 && int2 < int3 ? true : false;
    }

    public static boolean orderedWithoutCondition(int int1, int int2, int int3){
        return int1 < int2 && int2 < int3;
    }

    public static boolean entierFirst(double nb){
        return nb == (int) nb;
    }

    public static boolean entierSecond(double nb){
        return nb == (int) nb + 0.0000001;
    }

    public static int fact(int nb){
        if(nb <= 0) {
            return 1;
        }
        else if(nb > 12)
            return -2;
        else
            return nb * fact((nb - 1)) ;
    }

    public static int factIteration(int nb){
        if(nb <= 0) {
            return 1;
        }
        else if(nb > 12)
            return -2;

        int tpmNb = nb;
        for(int i = 0; i < tpmNb; i++){
            nb *= (--tpmNb);
        }
        return nb;
    }

    //exo 4 Faire sans Iteration et récursivité

    public static int maxtab(int[] arrInt){
        int maxValue;
        if(arrInt.length == 0){
            return 0;
        }
        maxValue = arrInt[0];
        for(int i = 0; i < arrInt.length; i++){
            if(maxValue < arrInt[i])
                maxValue = arrInt[i];
        }
        return maxValue;
    }

    public static int[] reversed(int[] arr){
        int tmp;
        int middleValue;
        middleValue = arr.length / 2;
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                tmp = arr[i];
                arr[i] = arr[arr.length - 1];
                arr[arr.length - 1] = tmp;
            } else if(i < middleValue){
                tmp = arr[i];
                arr[i] = arr[arr.length - (1+i)];
                arr[arr.length - (1+i)] = tmp;
            }
        }

        return arr;
    }

    public static void cptab(int[] arr){
        int[] arrCopy;
        arrCopy = arr;
        for(int i = 0; i < arr.length; i++){
            arrCopy[i] = arr[i];
        }

        for(int value : arrCopy){
            System.out.print(value);
        }
    }

    public static void cptabSystem(int[] arr){
        int[] arrCopy;
        arrCopy = new int[arr.length];
        System.arraycopy(arr, 0, arrCopy, 0, arr.length);
        for (int value : arrCopy){
            System.out.print(value);
        }
    }

    public static void cptabClass(int[] arr){
        int[] arrCopy;
        arrCopy = Arrays.copyOf(arr, arr.length);

        for (int value : arrCopy){
            System.out.print(value);
        }
    }

    public static void cptabArr(int[] arr){
        int[] arrCopy;
        arrCopy = arr.clone();
        for (int value : arrCopy){
            System.out.print(value);
        }
    }

    public static void cptab2dim(){
        int[][] matrice = new int[][]{{1,2,3},{4,5,6}};
        int [][] copieMatrice = new int [3][3];
        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
                copieMatrice[i][j] = matrice[i][j];
            }
        }

        for(int i = 0; i < copieMatrice.length; i++){
            System.out.println();
            for(int j = 0; j < matrice[i].length; j++){
                System.out.print(copieMatrice[i][j]);
            }
        }

    }

    public static void cptab2dimCpTab(){
        int[][] matrice = new int[][]{{6,9,103},{484,394,0}};
        int[][] copieMatrice = new int [3][3];

        for(int i =0; i<matrice.length; i++){
            copieMatrice = Arrays.copyOf(matrice, matrice.length);
        }

        for(int i = 0; i < copieMatrice.length; i++){
            System.out.println();
            for(int j = 0; j < matrice[i].length; j++){
                System.out.print(copieMatrice[i][j]+" ");
            }
        }
    }

    public static void extrairePair(){
        int[][] matrice = new int[][]{{5,-3,3,7},{9,-3,5,1}};
        int[] pair = new int[matrice[1].length * 2];
        int tmp;
        tmp = 0;
        String showPair;
        showPair = "";
        for(int i = 0; i < matrice.length; i++){
            for(int j = 0; j < matrice[i].length; j++){
                if (matrice[i][j] % 2 == 0) {
                    pair[tmp] = matrice[i][j];
                }
                tmp++;
            }
        }

        for(int value : pair){
            if(value != 0)
                System.out.println(value);
        }
    }

    public static boolean contain(String str1, String str2){
        return str1.toLowerCase().contains(str2.toLowerCase());
    }

    public static void separe(String str) {
        String[] strToArray = str.split("");
        String sentenceWithoutA= "";
        String sentence = "";
        for(int i = 0; i < strToArray.length; i++){
            if(strToArray[i].equalsIgnoreCase("i") || strToArray[i].equalsIgnoreCase("a") || strToArray[i].equalsIgnoreCase("e") || strToArray[i].equalsIgnoreCase("o") || strToArray[i].equalsIgnoreCase("u") || strToArray[i].equalsIgnoreCase("y"))
                sentenceWithoutA += strToArray[i];
            else if(!strToArray[i].equalsIgnoreCase(" ")){
                sentence += strToArray[i];
            }
        }

        System.out.println(sentenceWithoutA.toUpperCase()+sentence.toUpperCase());
    }
}