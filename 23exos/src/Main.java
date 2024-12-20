import java.util.InputMismatchException;
import java.util.Scanner;

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

//    public static int[] reversed(int[] arr){
//        int tmp;
//
//    }
}