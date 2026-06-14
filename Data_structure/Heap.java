package Data_structure;

import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Heap {

    static void main() {

        /*
        A heap is a binary tree-based data structure that adheres to a heap property.
        In a heap, every parent node has a specific relationship with its children:
          -> In a max-heap, each parent is greater than or equal to its children.
          -> In a min-heap, each parent is less than or equal to its children.
         */


        // PriorityQueue used for solving HEAP tasks.:
        // Elements are ordered by natural ordering or a Comparator.
        // Not FIFO, but priority-based.
        // Doesn’t allow null.
        // Backed by a heap → O(log n) insert/remove.

        Queue<String> cities = new PriorityQueue<>();

        cities.add("Delhi"); // adding value to heap O(log(n))
        cities.offer("Ghaziabad"); // adding value to heap O(log(n))
        cities.add("Gurgaon");
        cities.add("Faridabad");
        cities.add("Gurgaon"); // Supports duplicates
        cities.add("Mumbai");
        cities.offer("Delhi");
        System.out.printf("cities after insert Operations: %s%n", cities);

        cities.remove(); // removing value from last of heap O(log(n))
        cities.poll(); // removing value from last of heap O(log(n))
        cities.remove("Delhi"); // Removing the value from heap O(n)
        System.out.printf("cities after remove Operations: %s%n", cities);

        System.out.printf("Element at front of the heap, no removing it: %s%n", cities.peek()); // O(1)
        System.out.printf("Check heap is empty? : %s%n", cities.isEmpty()); // O(1)
        System.out.printf("Check heap size : %s%n", cities.size()); // O(1)
        System.out.printf("Check heap contains value Gurgaon : %s%n", cities.contains("Gurgaon")); // O(n)

        System.out.println("Iterator 1: ");
        for(String city : cities) System.out.printf("%s | ", city);

        System.out.println("\nIterator 2: ");
        Iterator<String> it2 = cities.iterator();
        while(it2.hasNext()) System.out.printf("%s | ", it2.next());

        // Use Case → Task scheduling, Dijkstra’s shortest path, CPU scheduling.
        
    }
}
