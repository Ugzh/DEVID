public class Main {
    public static void main(String[] args) {
        Lion scar;
        Gazelle gazou;
        String sentence;

        scar = new Lion("Scar");
        gazou = new Gazelle("Gazou");
        sentence = "Je t'ai bien eu !";

        System.out.println("Dans la savane, le lion " + scar.getName() + " voit " + gazou.getName() + " la gazelle");
        scar.attack(gazou);
        gazou.whichSentence(sentence);
        gazou.tryToEscape(sentence, scar);
    }
}