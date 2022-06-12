package JA13GenericsLab.L01JarOfT;

/*
Create a class Jar<> that can store anything.
It should have two public methods:
•	void add(element)
•	element remove()
Adding should add on top of its contents. Remove should get the topmost element.
Hints
Use the syntax Jar<T> to create a generic class.
Submit in Judge
Submit your solution in Judge zip your whole package with the Jar and Main classes:
If you didn't create a package just choose your classes and zip them.
 */

public class Main {
    public static void main(String[] args) {

        Jar <Integer> jar = new Jar<>();
        jar.add(1);
        jar.add(2);
        jar.add(3);

        System.out.println(jar.remove());
        System.out.println(jar.remove());

        Jar<String> jar2 = new Jar<>();
        jar2.add("one");
        jar2.add("two");
        jar2.add("five");

        System.out.println(jar2.remove());
        System.out.println(jar2.remove());

    }
}
