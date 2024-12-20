import java.util.ArrayList;

public class Garage {
    private ArrayList<Vehicles> vehicles = new ArrayList<Vehicles>();

    private int stockMax;
    private int currentStock;

    public Garage(int stockMax){
        this.stockMax = stockMax;
        currentStock = 0;
    }

    public void store(Vehicles vehicle){
        if(currentStock < stockMax){
            vehicles.add(vehicle);
            currentStock ++;
        } // Gestion d'erreur
    }

    public void unstore(Vehicles vehicle){
        if(currentStock > stockMax){
            vehicles.remove(vehicle);
            currentStock--;
        }
    }

    public void refuel(Vehicles vehicle){
        if(vehicle instanceof IMaintenace){
            ((IMaintenace) vehicle).refuel();
        }
    }
}
