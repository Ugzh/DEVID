public class Bike extends Vehicles {

    public Bike(String brand, String owner, int maxFuel, int currentFuel){
        super(brand);
    }

    public void wash() {
        System.out.println("Le garagiste lave le vélo");
    }

}
