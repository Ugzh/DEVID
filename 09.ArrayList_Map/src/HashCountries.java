import java.util.*;

public class HashCountries {
    public void exo2(){
        HashMap<String, Long> hashCountries = new HashMap<>();
        String showArray;
        showArray = "";
        hashCountries.put("Tunisie",11800000L);
        hashCountries.put("France",70000000L);
        hashCountries.put("Mexique",133200000L);
        hashCountries.forEach((country, population) -> System.out.println(country + " " + population));

        hashCountries.putIfAbsent("Russie", 146000000L);
        System.out.println();
        hashCountries.forEach((country, population) -> System.out.println(country + " " + population));

        hashCountries.remove("Russie");
        hashCountries.put("Sénégal", 17700000L);

        System.out.println();

        hashCountries.forEach((country, population) -> System.out.println(country + " " + population));


        System.out.println();

        ArrayList<Long> sortedByPop = new ArrayList<>(hashCountries.values());
        Collections.sort(sortedByPop);

        for(Long population : sortedByPop){
            for (Map.Entry<String, Long> country : hashCountries.entrySet()){
                if(country.getValue() == population)
                    System.out.println(country.getKey() +" "+country.getValue());
            }
        }

        System.out.println();
        ArrayList<String> sortedCountriesByKey = new ArrayList<>(hashCountries.keySet());

        Collections.sort(sortedCountriesByKey);

        for (String name: sortedCountriesByKey){
            System.out.println(name +" "+hashCountries.get(name));
        }

    }
}
