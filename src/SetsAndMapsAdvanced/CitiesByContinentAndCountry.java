package SetsAndMapsAdvanced;

import java.util.*;

//Write a program to read continents, countries and their cities,
//put them in a nested map and print them in the order of first appearance.
public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, LinkedHashMap<String, List<String>>> myMap = new LinkedHashMap<>();
        while (n > 0) {
            String[] input = scanner.nextLine().split(" ");
            if (!myMap.containsKey(input[0])) {
                LinkedHashMap<String, List<String>> countryAndCities = new LinkedHashMap<>();
                List<String> cities = new ArrayList<>();
                cities.add(input[2]);
                countryAndCities.put(input[1], cities);
                myMap.put(input[0], countryAndCities);
            }else {
                if(myMap.get(input[0]).containsKey(input[1])){
                    myMap.get(input[0]).get(input[1]).add(input[2]);
                }else{
                    List<String> cities = new ArrayList<>();
                    cities.add(input[2]);
                    myMap.get(input[0]).put(input[1], cities);
                }
            }


            n--;
        }
        //Europe:
        //  Bulgaria -> Sofia, Plovdiv
        //  Poland -> Warsaw, Poznan
        //  Germany -> Berlin

        for (Map.Entry<String, LinkedHashMap<String, List<String>>> continent : myMap.entrySet()) {
            StringBuilder output = new StringBuilder();
            output.append(continent.getKey()).append(":\n");
            for (Map.Entry<String, List<String>> country : continent.getValue().entrySet()) {
                output.append("  ").append(country.getKey()).append(" -> ");
                for (int i = 0; i < country.getValue().size(); i++) {
                    if(i == country.getValue().size() -1){
                        output.append(country.getValue().get(i)).append(" ");
                    }else {
                        output.append(country.getValue().get(i)).append(", ");
                    }
                }
                output.append("\n");
            }
            System.out.println(output);
        }

    }
}

