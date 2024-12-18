public class Arena {

    public void gladiatorsFighting(Gladiator gladiator1, Gladiator gladiator2) {
        int i;
        String winner;
        String informationsDuringARound;
        String looser;

        i = 1;

        if (gladiator1 == null)
            gladiator1 = new Gladiator("Spartacus", 100, 200);
        if (gladiator2 == null)
            gladiator2 = new Gladiator("Tentacus", 1000, 20);

        informationsDuringARound = "Au début du combat : \n" + gladiator1.getName() + " a " + gladiator1.getHp() + " pv et il attaque avec une puissance de " + gladiator1.getStr()
                                 +".\n" + gladiator2.getName() + " a " + gladiator2.getHp() + " pv et il attaque avec une puissance de " + gladiator2.getStr() +".\n\n";

        do {
            gladiator1.riposte(gladiator2);
            gladiator2.riposte(gladiator1);

            informationsDuringARound += "A la fin du tour " + i + " : " + gladiator1.getName() + " a " + gladiator1.getHp()
                    + " pv et " + gladiator2.getName() + " a " + gladiator2.getHp() + " pv \n";
            i++;
        } while (gladiator1.isAlive() && gladiator2.isAlive());

        if(gladiator1.isAlive()){
            winner = gladiator1.getName();
            looser = gladiator2.getName();
        } else {
            winner = gladiator2.getName();
            looser = gladiator1.getName();
        }

        System.out.println(informationsDuringARound + winner + " a tué " + looser + " !");
    }

}
