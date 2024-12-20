public class Main {
    public static void main(String[] args) {
        Cars car = new Cars("BM", "Ugo", 57);
        MotorBike car2 = new MotorBike("BM", "PAsUgo", 57);
        Garage garage = new Garage(2);
        garage.store(car2);
        garage.refuel(car2);
    }
}