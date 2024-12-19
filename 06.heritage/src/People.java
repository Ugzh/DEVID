public abstract class People {
    protected String name;
    protected int age;

    public People(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void eat(String food){
        System.out.println(name + " mange " + food + "\n");
    }

}
