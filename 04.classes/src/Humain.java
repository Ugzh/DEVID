public class Humain {
    // Variables d'instances
    private int age;
    private String nom; // instancie les objets
    private double taille; // initialise les primitives

    // Constructeurs
    public Humain(int age, String nom, double Taille){
        this.age = age;
        this.nom = nom;
        this.taille = taille;
    }
    public Humain(String nom){
        this.nom = nom;
    }

    //Méthodes
    void manger(String plat){
        System.out.println(nom + " a mangé " + plat);
    }

    void anniversaire(){
        age++;
        if(age < 18)
            taille += 0.15;
    }

    public void setName(String name){
        this.nom = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public void getAge() {
        System.out.println(age);
    }

    public String getNom() {
        return nom;
    }

    public void getTaille() {
        System.out.println(age);
    }
}
