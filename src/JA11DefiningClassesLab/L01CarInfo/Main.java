package JA11DefiningClassesLab.L01CarInfo;

/*
Create a class named Car.
The class should have public fields for:
•	Brand: String
•	Model: String
•	Horsepower: int
Create a new class and ensure proper naming:
Define the fields:
Create a Test client in the same package:
You should be now able to use your class:
Private Fields
Change the access modifiers of all class fields to private.
When done go back to the main method you should have compilation errors:

Getters and Setters
Create getters and setters for each class field.
Do the same for all the fields.

Fix Main Method
You should set and get the values by using the correct methods

Create Car Info Method
This method should return the info about any car object in the following format:
"The car is: {brand} {model} – {horsePower} HP."
You have to figure out how to create a method and use it in the outside code:

Test the Program
Read cars objects, add them to the collection of your choice, and print each one on the console using the carInfo() method. The input consists of a single integer N the number of lines representing car objects. One each line you will read car info in the following format "{brand} {model} {horsePower}" separated by single space.
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Car> carsCollection = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] data = scanner.nextLine().split(" ");
            String brand = data[0];
            String model = data[1];
            int horsePower = Integer.parseInt(data[2]);

            Car car = new Car();
            car.setBrand(brand);
            car.setModel(model);
            car.setHorsePower(horsePower);

            carsCollection.add(car);
        }

        carsCollection.forEach(car -> System.out.println(car.carInfo()));
    }
}
