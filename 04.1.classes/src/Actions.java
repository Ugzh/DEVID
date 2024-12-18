import java.util.Random;

public class Actions {

    void escape(Lion lion, Gazelle gazelle){
        System.out.println( gazelle.getName()+ " a eu de la chance et nargue "+ lion.getName() + " de la facon suivante : Je t'ai bien eu " + lion.getName() +" !");
    }

    void tryToEscape(String sentence, Lion lion, Gazelle gazelle){
        Random random;
        int chanceToEscape;

        random = new Random();
        chanceToEscape = random.nextInt(100);

        if(sentence.equalsIgnoreCase("Je t'ai bien eu !")){
            if(chanceToEscape >= 50 )
                escape(lion, gazelle);
            else{
                System.out.println(gazelle.getName() + " a pas eu de chance");
                die(gazelle);
            }
        } else
            die(gazelle);
    }

    void die(Gazelle gazelle){
        System.out.println("Les derniers mots de " + gazelle.getName() + " sont : Adieu monde cruel");
    }

    void whichSentence(String sentence, Gazelle gazelle){
        System.out.println(gazelle.getName() + " a prononcé la phrase : " + sentence);
        if(sentence.equalsIgnoreCase("Je t'ai bien eu !"))
            System.out.println(gazelle.getName() + " a 50% de chance de s'échapper");
        else
            System.out.println(gazelle.getName() + " a aucune chance de s'échapper");
    }

    void attack(Gazelle gazelle, Lion lion){
        System.out.println(lion.getName() + " attaque " + gazelle.getName() + " pour la manger");
    }

}
