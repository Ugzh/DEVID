public class Main {
    public static void main(String[] args) {
        int i = 5;
        int j = 5;
        System.out.println("1. i = " + i );
        System.out.println("1. j = " + j );
        System.out.println("----------");
        i++;
        j--;
        System.out.println("2. i = " + i );
        System.out.println("2. j = " + j );
        System.out.println("----------");
        ++i;
        --j;
        System.out.println("3. i = " + i );
        System.out.println("3. j = " + j );
        System.out.println("----------");
        System.out.println("4. i = " + i++ );
        System.out.println("4. j = " + j-- );
        System.out.println("5. i = " + i );
        System.out.println("5. j = " + j );
        System.out.println("----------");
        System.out.println("6. i = " + ++i );
        System.out.println("6. j = " + --j );
        System.out.println("7. i = " + i );
        System.out.println("7. j = " + j );
        System.out.println("----------");

    }
}