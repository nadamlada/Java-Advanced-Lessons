package JA17ExamPreparation.EX01JavaAdvancedRetakeExam_13April2022;

/*
You are the most well-known blacksmith on Middle Earth. What makes your swords so good is the perfect ratio between steel and carbon, which makes them extremely sharp and durable.
First, you will be given a sequence representing steel. Afterward, you will be given another sequence representing carbon.
You should start from the first steel and try to mix it with the last carbon. If the sum of their values is equal to any of the swords in the table below you should forge the sword corresponding to the value and remove both the steel and the carbon. Otherwise, remove only the steel, increase the value of the carbon by 5 and insert it back into the collection. You need to stop forging when you have no more steel or carbon left.
Sword	Resources needed
Gladius	70
Shamshir	80
Katana	90
Sabre	110
Forge as many swords as possible.
Input
•	On the first line, you will receive the steel, separated by a single space (" ").
•	On the second line, you will receive the carbon, separated by a single space (" ").
Output
•	On the first line of output depending on the result:
o	If at least one sword was forged: "You have forged {totalNumberOfSwords} swords."
o	If no sword was forged: "You did not have enough resources to forge a sword."
•	On the second line - print all steel you have left:
o	If there are no steel: "Steel left: none"
o	If there are steel: "Steel left: {steel1}, {steel2}, {steel3}, (…)"
•	On the third line - print all carbon you have left:
o	If there are no carbon: "Carbon left: none"
o	If there are carbon: "Carbon left: {carbon1}, {carbon2}, {carbon3}, (…)"
•	Then, you need to print only the swords that you manage to forge and how many of them, ordered alphabetically:
o	"Sabre: {amount}"
o	"Katana: {amount}"
o	"Shamshir: {amount}"
o	"Gladius: {amount}"
Constraints
•	All of the given numbers will be valid resources in the range [0, 130].
 */

import java.util.*;

public class EX01Blacksmith {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] steelInput = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

        int[] carbonInput = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

//        Queue<Integer> steelQ = new ArrayDeque<>();
//        Stack<Integer> carbonS = new Stack<>();

        ArrayDeque<Integer> steelQ = new ArrayDeque<>();
        ArrayDeque<Integer> carbonS = new ArrayDeque<>();

        for (int i : steelInput) {
            steelQ.offer(i);
        }

        for (int i : carbonInput) {
            carbonS.push(i);
        }

        Map<Integer, String> priceList = new HashMap<>();
        priceList.put(70, "Gladius");
        priceList.put(80, "Shamshir");
        priceList.put(90, "Katana");
        priceList.put(110, "Sabre");


        Map<String, Integer> ready = new TreeMap<>();
        ready.put("Sabre", 0);
        ready.put("Katana", 0);
        ready.put("Shamshir", 0);
        ready.put("Gladius", 0);

        int allReadySwords = 0;

        while (!carbonS.isEmpty() && !steelQ.isEmpty()) {
            int sum = carbonS.peek() + steelQ.peek();

            if (priceList.containsKey(sum)) {
                String currentItem = priceList.get(sum);
                ready.put(currentItem, ready.get(currentItem) + 1);
                allReadySwords++;

                steelQ.poll();
                carbonS.pop();
            } else {
                steelQ.poll();
                int newCarbon = carbonS.peek() + 5;
                carbonS.pop();
                carbonS.push(newCarbon);
            }
        }

        if (allReadySwords >= 1) {
            System.out.printf("You have forged %d swords.%n", allReadySwords);
        } else {
            System.out.println("You did not have enough resources to forge a sword.");
        }

        if (steelQ.isEmpty()) {
            System.out.println("Steel left: none");
        } else {
            String print = steelQ.toString().replaceAll("]", "").replaceAll("\\[", "");
            System.out.printf("Steel left: %s%n", print);
        }

        if (carbonS.isEmpty()) {
            System.out.println("Carbon left: none");
        } else {
            String print = carbonS.toString().replaceAll("]", "").replaceAll("\\[", "");
            System.out.printf("Carbon left: %s%n", print);
        }

        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, Integer> entry : ready.entrySet()) {
            if (entry.getValue() != 0) {
                sb.append(String.format("%s: %d%n", entry.getKey(), entry.getValue()));
            }
        }

        System.out.println(sb.toString().trim());
    }
}