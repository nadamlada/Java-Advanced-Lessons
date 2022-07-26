package JA05SetsAndMapsAdvancedLab;

/*
1.	Parking Lot
Write a program that:
o	Records car numbers for every car that enters the parking lot.
o	Removes car number when the car is out.
When the parking lot is empty, print "Parking Lot is Empty".
Input
The input will be a string in the format "{direction, carNumber}".
The input ends with the string "END".
Output
Print the output with all car numbers, which are in the parking lot.

•	Car numbers are unique.
•	Use the methods isEmpty().
 */

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class L01ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Set<String> parkingLots = new LinkedHashSet<>();

        while (!input.equals("END")) {
            String[] parts = input.split(", ");

            if (parts[0].equals("IN")) {
                parkingLots.add(parts[1]);
            } else if (parts[0].equals("OUT")) {
                parkingLots.remove(parts[1]);
            }

            input = scanner.nextLine();
        }

        if (parkingLots.isEmpty()) {
            System.out.println("Parking Lot is Empty");
            return;
        }

        for (String parkingLot : parkingLots) {
            System.out.println(parkingLot);
        }
    }
}