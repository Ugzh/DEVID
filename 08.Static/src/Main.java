public class Main {
    public static void main(String[] args) {

        System.out.println(TestInstanceStatique.occ);
        TestInstanceStatique test = new TestInstanceStatique("Ugo");
        System.out.println(TestInstanceStatique.occ);
        System.out.println(test);

        System.out.println(TestInstanceStatique.name);
        String myName = TestInstanceStatique.name;
        System.out.println(myName);

    }
}