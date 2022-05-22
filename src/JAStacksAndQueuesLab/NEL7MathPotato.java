package JAStacksAndQueuesLab;//package JAStacksAndQueuesLab;
///*
//Rework the previous problem so that a child is removed only on a composite (not prime) cycle (cycles start from 1).
//If a cycle is prime, just print the child's name.
//As before, print the name of the child that is left last.
// */
//
//import java.util.ArrayDeque;
//import java.util.Scanner;
//
//public class NEL7MathPotato {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        //if (cycle > 1 && cycle % 2 == 1 || cycle == 2) {
//
//
//        String[] kids = scanner.nextLine().split(" ");
//        int numberOfKids = Integer.parseInt(scanner.nextLine());
//
//        ArrayDeque<String> kidsQueue = new ArrayDeque<>();
//
//        for (int i = 0; i < kids.length; i++) {
//            //добавя в опашката
//            kidsQueue.offer(kids[i]);
//        }
//        int cycle = 1;
//        while (kidsQueue.size() > 1) {
//            for (int i = 1; i < numberOfKids; i++) {
//                //премахваме
//                String currentKid = kidsQueue.poll();
//                //добавяме най-накрая
//                kidsQueue.offer(currentKid);
//
//                if (cycle > 1 && cycle % 2 == 1 || cycle == 2){
//
//                }
//
//
//            }
//            //премахваме го
//            String kidToRemove = kidsQueue.poll();
//            System.out.println("Removed " + kidToRemove);
//            cycle++;
//        }
//        String lastKid = kidsQueue.peek();
//        System.out.printf("Last is %s", lastKid);
//
//
//    }
//}
//
//
//
//
//
///* от презентацията
//int cycle = 1;
//while (queue.size() > 1) {
//  for (int i = 1; i < n; i++)
//    queue.offer(queue.poll());
//
//  if (isPrime(cycle))
//    System.out.println("Prime " + queue.peek());
//  else
//    System.out.println("Removed " + queue.poll());
//
//  cycle++;
//}
//System.out.println("Last is " + queue.poll());
//
// */
