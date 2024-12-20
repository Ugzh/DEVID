public abstract class Vehicles {
    private String brand;
    private String owner;

    public Vehicles(String brand){
        this.brand = brand;
    }

    public abstract void wash();
}
