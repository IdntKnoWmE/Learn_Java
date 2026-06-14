package Data_structure;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

public class Lists {

    static void main() {

        // Lists are ordered collection in java that allows duplicate elements unlike sets.
        // Lists also supports indexed access and modification.
        // Type:

        // 1. ArrayList:  uses a resizable array, providing fast random access and is best for frequent retrieval operations.
        List<String> cities = new ArrayList<>();
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Ghaziabad");
        cities.add("Gurgaon");
        cities.add("Delhi");
        System.out.printf("Cities: %s%n", cities);

        cities.set(2, "GZB"); // Change value at any index  O(1)
        System.out.printf("Cities after setting GZB at 2: %s%n", cities);

        cities.remove("Mumbai"); // Remove element from list  O(n)
        System.out.printf("Cities after removing Mumbai: %s%n", cities);


        System.out.printf("First Index of Delhi: %d%n", cities.indexOf("Delhi")); // Find first index of element  O(n)
        System.out.printf("Last Index of Delhi: %d%n", cities.lastIndexOf("Delhi")); // Find last index of element  O(n)
        System.out.printf("Value at Index 2: %s%n", cities.get(2)); // Access element by index  O(n)
        System.out.printf("Size of cities: %d%n", cities.size()); // size of list  O(1)
        System.out.printf("is cities empty: %s%n", cities.isEmpty()); // check if list is empty  O(1)
        System.out.printf("Is cities contains Delhi: %s%n", cities.contains("Delhi"));  // Check if element exists O(n)

        // Iterate
        System.out.println("Iterator 1: ");
        for (String city: cities){
            System.out.printf("%s|", city);
        }
        System.out.println("\nIterator 2: ");
        // OR
        Iterator<String> it = cities.iterator();
        while(it.hasNext()) System.out.printf("%s|", it.next());


        cities.clear(); // Remove all elements O(n)
        // Use Case: When you need fast random access and mostly append operations.
        // Not Thread Safe as Multiple threads modifying it can cause race conditions
        // Can also be wrapped with Collections.synchronizedList() to make it thread safe, but it is too slow.

        System.out.println("\n\n Testing Linked List \n");

        List<String> cities2 = new LinkedList<>();
        cities2.add("Mumbai"); // O(1)
        cities2.add("Delhi");
        cities2.add("Ghaziabad");
        cities2.add("Gurgaon");
        cities2.add("Delhi");

        System.out.printf("Cities: %s%n", cities2);

        cities2.set(2, "GZB"); // Change value at any index  O(n)
        System.out.printf("Cities after setting GZB at 2: %s%n", cities2);

        cities2.remove("Mumbai"); // Remove element from list  O(n)
        System.out.printf("Cities after removing Mumbai: %s%n", cities2);

        cities2.addFirst("Manali"); // Add at starting index O(1)
        System.out.printf("Cities after Adding Manali at starting point: %s%n", cities2);

        cities2.add(3, "Punjab"); // Add at any index O(n)
        System.out.printf("Cities after adding Punjab at 3 index: %s%n", cities2);

        System.out.printf("First Index of Delhi: %d%n", cities2.indexOf("Delhi")); // Find first index of element  O(n)
        System.out.printf("Last Index of Delhi: %d%n", cities2.lastIndexOf("Delhi")); // Find last index of element  O(n)
        System.out.printf("Value at Index 2: %s%n", cities2.get(2)); // Access element by index  O(n)
        System.out.printf("Size of cities: %d%n", cities2.size()); // size of list  O(1)
        System.out.printf("is cities empty: %s%n", cities2.isEmpty()); // check if list is empty  O(1)
        System.out.printf("Is cities contains Delhi: %s%n", cities2.contains("Delhi"));  // Check if element exists O(n)

        // Iterate
        System.out.println("Iterator 1: ");
        for (String city: cities2){
            System.out.printf("%s|", city);
        }
        System.out.println("\nIterator 2: ");
        // OR
        Iterator<String> it2 = cities2.iterator();
        while(it2.hasNext()) System.out.printf("%s|", it2.next());

        // Use Case: When you do a lot of insertions/deletions in the middle.
        // Not Thread Safe as Multiple threads modifying it can cause race conditions
        // Can also be wrapped with Collections.synchronizedList() to make it thread safe, but it is too slow.


        System.out.println("\n\n Testing Vector List \n");

        // Vector: 
        // Old class (legacy from Java 1.0).
        // Synchronized (thread-safe), but slower due to locking.
        // Similar to ArrayList, but not recommended in modern apps.
        List<String> cities3 = new Vector<>();

        cities3.add("Mumbai"); // O(1)
        cities3.add("Delhi");
        cities3.add("Ghaziabad");
        cities3.add("Gurgaon");
        cities3.add("Delhi");

        System.out.printf("Cities: %s%n", cities3);

        cities3.set(2, "GZB"); // Change value at any index  O(1)
        System.out.printf("Cities after setting GZB at 2: %s%n", cities3);

        cities3.remove("Mumbai"); // Remove element from list  O(n)
        System.out.printf("Cities after removing Mumbai: %s%n", cities3);

        cities3.addFirst("Manali"); // Add at starting index O(1)
        System.out.printf("Cities after Adding Manali at starting point: %s%n", cities3);

        cities3.add(3, "Punjab"); // Add at any index O(n)
        System.out.printf("Cities after adding Punjab at 3 index: %s%n", cities3);


        System.out.printf("First Index of Delhi: %d%n", cities3.indexOf("Delhi")); // Find first index of element  O(n)
        System.out.printf("Last Index of Delhi: %d%n", cities3.lastIndexOf("Delhi")); // Find last index of element  O(n)
        System.out.printf("Value at Index 2: %s%n", cities3.get(2)); // Access element by index  O(1)
        System.out.printf("Size of cities: %d%n", cities3.size()); // size of list  O(1)
        System.out.printf("is cities empty: %s%n", cities3.isEmpty()); // check if list is empty  O(1)
        System.out.printf("Is cities contains Delhi: %s%n", cities3.contains("Delhi"));  // Check if element exists O(n)

        // Iterate
        System.out.println("Iterator 1: ");
        for (String city: cities3){
            System.out.printf("%s|", city);
        }
        System.out.println("\nIterator 2: ");
        // OR
        Iterator<String> it3 = cities3.iterator();
        while(it3.hasNext()) System.out.printf("%s|", it3.next());

        // Use Case: Rare, only when you need thread-safe List without external synchronization.
        // Is Thread safe as all methods are synchronised in nature.
        // But this synchronization makes it very slow leading to performance bottlenecks.


        System.out.println("\n\n Testing CopyOnWriteArrayList \n");

        // CopyOnWriteArrayList:
        //From java.util.concurrent.
        //Thread-safe alternative to ArrayList.
        //On modification, it creates a new copy of the array.
        //Reads are fast & lock-free, writes are costly.
        //Best for read-heavy, write-light concurrent apps.
        List<String> cities4 = new CopyOnWriteArrayList<>();

        cities4.add("Mumbai"); // O(n)
        cities4.add("Delhi");
        cities4.add("Ghaziabad");
        cities4.add("Gurgaon");
        cities4.add("Delhi");

        System.out.printf("Cities: %s%n", cities4);

        cities4.set(2, "GZB"); // Change value at any index  O(n)
        System.out.printf("Cities after setting GZB at 2: %s%n", cities4);

        cities4.remove("Mumbai"); // Remove element from list  O(n)
        System.out.printf("Cities after removing Mumbai: %s%n", cities4);

        cities4.addFirst("Manali"); // Add at starting index O(n)
        System.out.printf("Cities after Adding Manali at starting point: %s%n", cities4);

        cities4.add(3, "Punjab"); // Add at any index O(n)
        System.out.printf("Cities after adding Punjab at 3 index: %s%n", cities4);

        System.out.printf("First Index of Delhi: %d%n", cities4.indexOf("Delhi")); // Find first index of element  O(n)
        System.out.printf("Last Index of Delhi: %d%n", cities4.lastIndexOf("Delhi")); // Find last index of element  O(n)
        System.out.printf("Value at Index 2: %s%n", cities4.get(2)); // Access element by index  O(1)
        System.out.printf("Size of cities: %d%n", cities4.size()); // size of list  O(1)
        System.out.printf("is cities empty: %s%n", cities4.isEmpty()); // check if list is empty  O(1)
        System.out.printf("Is cities contains Delhi: %s%n", cities4.contains("Delhi"));  // Check if element exists O(n)

        // Iterate
        System.out.println("Iterator 1: ");
        for (String city: cities4){
            System.out.printf("%s|", city);
        }
        System.out.println("\nIterator 2: ");
        // OR
        Iterator<String> it4 = cities4.iterator();
        while(it4.hasNext()) System.out.printf("%s|", it4.next());

        // Use Case: When you need concurrent reads with occasional writes.
        // Thread safe as it:
        // Uses copy-on-write mechanism → on every modification, a new copy of the underlying array is created.
        // Reads are lock-free and very fast.
        // Writes are slower (O(n)) since array copy happens.
        // Perfect for read-heavy, write-light concurrent scenarios.















    }
}
