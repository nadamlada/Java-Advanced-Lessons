package JA05SetsAndMapsAdvancedLab;
/*
Write a program to read continents, countries, and their cities put them in a nested map, and print them in the order of the first appearance.
 */

import java.util.*;

public class X07CitiesbyContinentandCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        //Map<String> -> continent
        //Map<String, List<String> -> country, cities
        Map<String, Map<String, List<String>>> map = new LinkedHashMap<>();

        while (n-- > 0) {

            String[] data = scanner.nextLine().split(" ");
            String continent = data[0];
            String country = data[1];
            String city = data[2];

            map.putIfAbsent(continent, new LinkedHashMap<>());
            map.get(continent).putIfAbsent(country, new ArrayList<>());
            map.get(continent).get(country).add(city);
        }

        map.entrySet()
                .forEach(entry -> {
                    String continent = entry.getKey();
                    Map<String, List<String>> countryWithCities = entry.getValue();

                    System.out.println(continent + ":");
                    countryWithCities.entrySet()
                            .forEach(e -> {
                                System.out.println("  " + e.getKey() + " -> " + String.join(", ", e.getValue()));
                            });
                });
    }
}