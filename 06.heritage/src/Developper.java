import java.util.List;

public class Developper extends People implements ITest {
    protected String[] skills;

    public Developper(String name, int age, String[] skills){
        super(name, age);
        this.skills = skills;
    }

    public void code(){
        String showSkills;
        showSkills = name + " code en ";

        for(String skill: skills){
            showSkills += skill + ", ";
        }

        System.out.println(showSkills+"\n");
    }

    public String[] getSkills() {
        return skills;
    }

    @Override
    public void eat(String food){
        System.out.println("Je suis super "+name+" et j'adore les burgers");
    }

    @Override
    public void talk() {

    }

}
