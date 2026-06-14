package Data_structure;
import java.util.*;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Queues {

    static void main() {

        /* Queue:
           -> It is a linear data structure based on FIFO (First In First out).
           -> Java provides the Queue interface (java.util) with multiple implementations.
           -> Some queues are bounded, some unbounded, some blocking (thread-safe)
         */

        // LinkedList (Queue Implementation)
        // LinkedList implements both List and Queue.
        // Can be used as a normal queue.
        // Allows null values.
        Queue<String> cities = new LinkedList<>();

        cities.add("Delhi"); // Enqueue or say adding value to queue O(1)
        cities.offer("Ghaziabad"); // Enqueue or say adding value to queue O(1)
        cities.add("Gurgaon");
        cities.add("Faridabad");
        cities.add("Gurgaon"); // Supports duplicates
        cities.add("Mumbai");
        cities.offer("Delhi");
        System.out.printf("Cities after Enqueue Operations: %s%n", cities);

        cities.remove(); // Dequeue or say removing value from last of queue O(1)
        cities.poll(); // Dequeue or say removing value from last of queue O(1)
        System.out.printf("Cities after Dequeue Operations: %s%n", cities);

        cities.remove("Delhi"); // Removing the value from queue O(n)
        System.out.printf("Cities after Remove value Delhi Operation: %s%n", cities);

        System.out.printf("Element at front of the queue, no removing it: %s%n", cities.peek()); // O(1)
        System.out.printf("Check queue is empty? : %s%n", cities.isEmpty()); // O(1)
        System.out.printf("Check queue size : %s%n", cities.size()); // O(1)
        System.out.printf("Check queue contains value Gurgaon : %s%n", cities.contains("Gurgaon")); // O(n)

        System.out.println("Iterator 1: ");
        for(String city : cities) System.out.printf("%s | ", city);

        System.out.println("\nIterator 2: ");
        Iterator<String> it = cities.iterator();
        while(it.hasNext()) System.out.printf("%s | ", it.next());

        // Use Case → General-purpose queue when performance isn’t critical.

    }


}
