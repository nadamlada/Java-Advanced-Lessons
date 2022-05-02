package JA05SetsAndMapsAdvancedLab;
/*
Write a program that counts the occurrence of real numbers. The input is a single line with real numbers separated by a space. Print the numbers in the order of appearance. All numbers must be formatted to one digit after the decimal point.
 */

import java.util.*;
import java.util.stream.Collectors;

public class X04CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double[] input = Arrays.stream(scanner.nextLine().split(" ")).mapToDouble(Double::parseDouble).toArray();

        Map<Double, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            if (map.containsKey(input[i])) {
                int currentQty = map.get(input[i]);
                map.put(input[i], currentQty +1);
            }else{
                map.put(input[i], 1);
            }
        }

        for (Map.Entry<Double, Integer> entry : map.entrySet()) {
            System.out.printf("%.1f -> %d%n", entry.getKey(), entry.getValue());
        }
    }
}
