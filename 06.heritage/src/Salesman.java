public class Salesman extends People{

    public Salesman(String name, int age){
        super(name, age);
    }

    public void sales(int price, int nbOfProducts, String nameOfProduct){
        System.out.println(name + " a vendu "+ nbOfProducts+" " +nameOfProduct +" à un prix de "+ price + " euros.\nCe qui lui a rapporté " + (price* nbOfProducts) + " euros.\n");
    }

}
