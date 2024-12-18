public class Lion {
    private String name;

    public Lion(String name){
        this.name = name;
    }

    public void attack(Gazelle gazelle, double percentageOfSurvival){
        gazelle.dieOrEscape(percentageOfSurvival);
    }
    public String getName() {
        return name;
    }
}
