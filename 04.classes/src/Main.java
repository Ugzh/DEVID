public class Main {
    public static void main(String[] args) {

        Humain humain = new Humain(17,"Ugo",1.8);
        Humain amine = new Humain("Amine");
        amine.getAge();
        amine.getTaille();
        humain.manger("Couscous");
    }
}