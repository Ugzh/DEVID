public class MotorBike extends Vehicles implements IMaintenace{
    private int maxFuel;
    private int currentFuel;

    public MotorBike(String brand, String owner, int maxFuel, int currentFuel){
        super(brand);
        this.maxFuel = maxFuel;
        this.currentFuel = currentFuel;
    }

    public MotorBike(String brand, String owner, int maxFuel){
        super(brand);
        this.maxFuel = maxFuel;
        currentFuel = 0;
    }

    @Override
    public void wash() {
        System.out.println("Le garagiste lave la moto");
    }

    @Override
    public void refuel() {
        System.out.println("Il y a actuellement " +currentFuel+"L d'essence. Le garagiste ajoute " +(maxFuel - currentFuel)+"L pour faire le plein et arriver à "+maxFuel+"L.");
    }
}
