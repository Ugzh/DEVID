import java.util.*;

public class HashCountries {
    public void exo2(){
        Map<String, Long> hashCountries;
        StringBuilder printSentence;
        hashCountries  = new HashMap<>();
        printSentence = new StringBuilder();


        hashCountries.put("France",70000000L);
        hashCountries.put("Tunisie",11800000L);
        hashCountries.put("Mexique",133200000L);
        hashCountries.forEach((country, population) -> printSentence.append(country).append(" ").append(population).append("\n"));

        System.out.println(printSentence.toString()+"\n");
        hashCountries.putIfAbsent("Russie", 146000000L);
        hashCountries.forEach((country, population) -> printSentence.append(country).append(" ").append(population).append("\n"));

        System.out.println(printSentence.toString()+"\n");
        hashCountries.remove("Russie");
        hashCountries.put("Sénégal", 17700000L);
        hashCountries.forEach((country, population) -> printSentence.append(country).append(" ").append(population).append("\n"));
        System.out.println(printSentence.toString()+"\n");

        ArrayList<Long> populationList = new ArrayList<>(hashCountries.values());
        Collections.sort(populationList);

        for(Long population : populationList){
            for (Map.Entry<String, Long> mapEntry : hashCountries.entrySet()){ // Permet de pouvoir faire un forEach
                if(mapEntry.getValue().equals(population)) {
                    printSentence.append(mapEntry.getKey()).append(" ").append(mapEntry.getValue()).append("\n");
                    break;
                }
            }
        }

//        populationList.stream().forEach(population -> {
//            for (Map.Entry<String, Long> mapEntry : hashCountries.entrySet()){ // Permet de pouvoir faire un forEach
//                if(mapEntry.getValue().equals(population)) {
//                    printSentence.append(mapEntry.getKey()).append(" ").append(mapEntry.getValue()).append("\n");
//                    break;
//                }
//            }
//        });


        System.out.println(printSentence.toString());

        ArrayList<String> sortedCountriesByKey = new ArrayList<>(hashCountries.keySet());
        Collections.sort(sortedCountriesByKey);

        for (String name: sortedCountriesByKey){
            printSentence.append(name).append(" ").append(hashCountries.get(name)).append("\n");
        }
        System.out.println(printSentence.toString());


    }
}
