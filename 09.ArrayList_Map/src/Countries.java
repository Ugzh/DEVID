import java.util.ArrayList;
import java.util.Collection;

public class Countries {
    public void exo1(){
        ArrayList<String> countries = new ArrayList<>();
        String[] listOfCountries = {"France","Espagne","Chine","Mexique","Russie","Tunisie"};
        String showAllCountries;
        String showSize;

        showAllCountries = "";
        showSize = "\nLa taille du tableau est de : ";

        for (String country : listOfCountries){
            if (countries.contains(country))
                return;
            else
                countries.add(country);
        }

        for(int i = 0; i < countries.size(); i++){
            showAllCountries += countries.get(i) + ',';
        }
        System.out.println(showAllCountries+showSize+countries.size()+"\n");

        //
        showAllCountries = "";
        countries.remove("Chine");

        for(int i = 0; i < countries.size(); i++){
            showAllCountries += countries.get(i) + ',';
        }

        System.out.println(showAllCountries+showSize+countries.size()+"\n");
        showAllCountries = "";
        //
        for(int i = 0; i < countries.size(); i++){
            if(countries.get(i) == "Russie"){
                countries.remove("Russie");
                countries.add(i, "Ukraine");
            }
            showAllCountries += countries.get(i) + ',';
        }
        System.out.println(showAllCountries+showSize+countries.size()+"\n");
        showAllCountries ="";

        for(int i = 0; i < countries.size(); i++){
            if(countries.get(i) == "Espagne"){
                countries.add(i + 1, "Mali");
            }
            showAllCountries += countries.get(i) + ',';
        }
        System.out.println(showAllCountries+showSize+countries.size()+"\n");
        showAllCountries ="";

        countries.clear();
        for(int i = 0; i < countries.size(); i++){
            showAllCountries += countries.get(i) + ',';
        }

        System.out.println(showAllCountries+showSize+countries.size()+"\n");
        showAllCountries ="";
    }

}
