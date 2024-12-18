public class Savannah {

    public void lionMeetGazelle(Lion lion, Gazelle gazelle){
        if(lion == null)
            lion = new Lion("Scar");
        if(gazelle == null)
            gazelle = new Gazelle("Gazou");

        String histoire = "";

        histoire += lion.getName() + " attaque " + gazelle.getName()+"\n";
        lion.attack(gazelle, 0.5);
        histoire += gazelle.isAlive() ? "Je t'ai bien eu " + lion.getName() + " !" : "Adieu monde cruel !";

        System.out.println(histoire);
    }
}
