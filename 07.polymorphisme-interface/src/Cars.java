public class Cars extends Vehicles implements IMaintenace{
    private int maxFuel;
    private int currentFuel;

    public Cars(String brand, String owner, int maxFuel, int currentFuel){
        super(brand);
        this.maxFuel = maxFuel;
        this.currentFuel = currentFuel;
    }

    public Cars(String brand, String owner, int maxFuel){
        super(brand);
        this.maxFuel = maxFuel;
    }

    @Override
    public void wash() {
        System.out.println("Le garagiste lave la voiture");
    }

    @Override
    public void refuel() {
        System.out.println("Il y a actuellement " +currentFuel+"L d'essence. Le garagiste ajoute " +(maxFuel - currentFuel)+"L pour faire le plein et arriver à "+maxFuel+"L.");
    }

    public int getMaxFuel() {
        return maxFuel;
    }

    public int getCurrentFuel() {
        return currentFuel;
    }
}
