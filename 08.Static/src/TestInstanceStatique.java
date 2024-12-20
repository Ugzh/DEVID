public class TestInstanceStatique {
    public static int occ = 0; // variable de classe
    public static String name;
    private String nom; // variable d'instance a

    public TestInstanceStatique(String nom){
        this.nom = nom;
        occ++;
        TestInstanceStatique.name = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString(){
        return nom;
    }

}
