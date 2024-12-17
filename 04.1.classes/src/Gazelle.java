import java.util.Random;

public class Gazelle {
    private String name;

    public Gazelle(String name){
        this.name = name;
    }

    void whichSentence(String sentence){
        System.out.println(name + " a prononcé la phrase : " + sentence);
        if(sentence.equalsIgnoreCase("Je t'ai bien eu !"))
            System.out.println(name + " a 50% de chance de s'échapper");
        else
            System.out.println(name + " a aucune chance de s'échapper");
    }

    void tryToEscape(String sentence, Lion lion){
        Random r;
        int chanceToEscape;

        r = new Random();
        chanceToEscape = r.nextInt(100);

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
