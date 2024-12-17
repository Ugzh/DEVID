public class Lion {
    private String name;

    public Lion(String name){
        this.name = name;
    }

    void attack(Gazelle gazelle){
        System.out.println(name + " attaque " + gazelle.getName() + " pour la manger");
    }

    public String getName() {
        return name;
    }
}
