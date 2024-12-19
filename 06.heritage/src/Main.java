public class Main {
    public static void main(String[] args) {
        Developper ugo = new Developper("Ugo", 25, new String[]{"Java", "Js"});
        Salesman charly = new Salesman("Claudy", 23);
        Salesman claudy = new Salesman("Claudy", 23);
        People charles = new Salesman("Charles", 27);
        People lea = new Developper("Lea", 25, new String[]{"Java", "Js"});

        charles.eat("une pizza");

        lea.eat("un tacos");

        for (String skill :((Developper) lea).getSkills()){
            System.out.println(skill);
        }

        Salesman yves = (Salesman) charles;
        yves.sales(25, 7, "bonbons");

        People[]personnes = {ugo, charles, charly, claudy};

        for (People personne: personnes){
            if(personne instanceof Salesman )
                ((Salesman) personne).sales(25, 7, "bonbons");
            else
                personne.eat("un kebab");
        }

    }
}