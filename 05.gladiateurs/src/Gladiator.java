public class Gladiator {
    private final String name;
    private int hp;
    private final int str;

    public Gladiator(String name, int hp, int str){
        this.name = name;
        this.hp = hp;
        this.str = str;
    }

    public void attack(Gladiator gladiator){
        gladiator.updateHp(str);
    }

    public void updateHp(int hp) {
        this.hp -= hp;
    }

    public boolean isAlive(){
        return hp > 0;
    }

    public int getHp() {
        return hp;
    }

    public String getName() {
        return name;
    }

    public int getStr() {
        return str;
    }

    public void riposte(Gladiator gladiator){
        if (gladiator.isAlive())
            this.attack(gladiator);

        if (this.isAlive())
            gladiator.attack(this);
    }
}
