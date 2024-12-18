public class Arena {
    public void deathMatch(Gladiator g1, Gladiator g2){
        String story;
        String winner;
        Gladiator gladiatorA, gladiatorB;

        if(g1 == null)
            g1 = new Gladiator("Maximus", 10, 7);
        if(g2 == null)
            g2 = new Gladiator("Tentacux", 10, 7);

        story = "Bienvenue aujourd'hui pour le combat à mort entre " + g1.getName() + " et " + g2.getName() + ".\n";

        while (g2.isAlive() && g1.isAlive()){
            // Methode pas optimisée
//            if(Math.random() > 0.5){
//                g1.attack(g2);
//                if(g2.isAlive())
//                    g2.attack(g1);
//            } else {
//                g2.attack(g1);
//                if(g1.isAlive())
//                    g1.attack(g2);
//            }
            // Méthode optimisée
            if(Math.random() > 0.5){
                gladiatorA = g1;
                gladiatorB = g2;
            } else {
                gladiatorA = g2;
                gladiatorB = g1;
            }
            gladiatorA.attack(gladiatorB);
            if(gladiatorB.isAlive())
                gladiatorB.attack(gladiatorA);

        }

        winner = g1.isAlive() ? g1.getName() : g2.getName();
        story += "Et le vainqueur est " + winner + " !!";

        System.out.println(story);
    }
}
