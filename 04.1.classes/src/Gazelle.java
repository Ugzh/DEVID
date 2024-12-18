import java.util.Random;

public class Gazelle {
    private String name;

    public Gazelle(String name){
        this.name = name;
    }



    void tryToEscape(String sentence, Lion lion){
        Random random;
        int chanceToEscape;

        random = new Random();
        chanceToEscape = random.nextInt(100);

        if(sentence.equalsIgnoreCase("Je t'ai bien eu !")){
            if(chanceToEscape >= 50 )
                escape(lion);
            else{
                System.out.println(name + " a pas eu de chance");
                die();
            }
        } else
            die();
    }

    void escape(Lion lion){
        System.out.println(name + " a eu de la chance et nargue "+ lion.getName() + " de la facon suivante : Je t'ai bien eu " + lion.getName() +" !");
    }

    void die(){
        System.out.println("Les derniers mots de " +name + " sont : Adieu monde cruel");
    }

    public String getName() {
        return name;
    }
}

