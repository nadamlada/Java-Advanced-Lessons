package JA13GenericsLab.L03GenericScale;

/*
Create a class Scale<T> that holds two elements - left and right. The scale should receive the elements through its single constructor:
•	Scale(T left, T right)
The scale should have a single method:
•	T getHeavier()
The greater of the two elements is heavier. The method should return null if elements are equal.
 */

public class Main {
    public static void main(String[] args) {
        Scale <String> scale = new Scale<>("ff","oo");
        System.out.println(scale.getHeavier());

        Scale <Integer> scale2 = new Scale<>(2,100);
        System.out.println(scale2.getHeavier());
    }
}
