public class Gazelle {
    private String name;
    private boolean isAlive;

    public Gazelle(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void dieOrEscape(double percentageOfSurvival){
        isAlive = Math.random() <= percentageOfSurvival;

        //ou équivalent plus verbeux

        if(Math.random() <= percentageOfSurvival)
            die();
        else
            escape();
    }

    private void die(){
        isAlive = false;
    }

    private void escape(){
        isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }
}
