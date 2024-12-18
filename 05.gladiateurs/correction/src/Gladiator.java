public class Gladiator {
    private final String name;
    private int hp;
    private int str;
    private boolean isAlive;

    public Gladiator(String name, int hp, int str){
        this.name = name;
        this.hp = hp;
        this.str = str;
        isAlive = true;
    }

    public void attack(Gladiator foe){
        foe.takeDamage(str);
    }

    private void takeDamage(int str){
        hp -= str;
        isAlive = hp > 0;
//        methode plus légèrement plus optimisée
//        if(hp <= 0)
//            isAlive = false
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public int getHp() {
        return hp;
    }

    public boolean isAlive() {
        return isAlive;
    }

}
