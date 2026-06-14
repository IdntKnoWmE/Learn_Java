package Data_structure;

import java.util.*;

public class Sets {

    static void main() {
        // Since Set is an interface so, you cannot instantiate it.
        // There are few types of hash sets which implemented from Set interface class. Let's see them:

        System.out.println("Testing Hashset.\n");

        // 1. Hashsets: stores elements in an unordered, hash table–backed structure and does not
        // maintain insertion order
        Set<String> cities = new HashSet<>();
        cities.add("Mumbai");
        cities.add("Delhi");
        cities.add("Ghaziabad");
        cities.add("Gurgaon");
        cities.add("Delhi");
        System.out.println(cities); // unordered set will be print
        System.out.println(cities.contains("Delhi"));
        System.out.println(cities.remove("Mumbai"));
        System.out.println(cities); // order will change again after removal of a city
        // Use case: When fast searches and uniqueness are required, but element order doesn’t
        // matter (e.g., storing unique user IDs).

        System.out.println("\nTesting LinkedHashSet.\n");

        // 2. LinkedHashSet: preserves insertion order and uses a doubly-linked list inside with hash table.
        Set<String> cities2 = new LinkedHashSet<>();
        cities2.add("Mumbai");
        cities2.add("Delhi");
        cities2.add("Ghaziabad");
        cities2.add("Gurgaon");
        cities2.add("Delhi");
        System.out.println(cities2); // Ordered set the order in which the city are inputted
        System.out.println(cities2.contains("Delhi"));
        System.out.println(cities2.remove("Mumbai"));
        System.out.println(cities2); // Even after the removal of city order is intact
        // Use case: maintains insertion order, allows quick insertion, deletion and lookup of elements,
        // useful for caching applications where insertion order is important.

        System.out.println("\nTesting TreeSet.\n");

        // 3. TreeSet: maintains elements in sorted (default: natural, but can be custom) order using a Red-Black tree.
        Set<String> cities3 = new TreeSet<>();
        cities3.add("Mumbai");
        cities3.add("Delhi");
        cities3.add("Ghaziabad");
        cities3.add("Gurgaon");
        cities3.add("Delhi");
        System.out.println(cities3); // Sorted set even the inputted strings are random
        System.out.println(cities3.contains("Delhi"));
        System.out.println(cities3.remove("Mumbai"));
        System.out.println(cities3); // Even after the removal of city is sorted
        //Use case: Ideal for scenarios needing sorted, unique sets (e.g., storing sorted, unique scores).


        System.out.println("\nTesting EnumSet.\n");

        // EnumSet: specialized for storing enum constants, extremely fast but supports only enum type data.

        enum Days {MON, TUE, WED, THU}
        Set<Days> weekend = EnumSet.of(Days.MON, Days.TUE, Days.WED);
        System.out.println(weekend);
        weekend.add(Days.THU);
        System.out.println(weekend);
        weekend.remove(Days.TUE);
        System.out.println(weekend);



        // Testing Immutable sets instantiations
        Set imm_set = Set.of(1,2,3);
        System.out.println(imm_set);

        // imm_set.remove(2); // Will give error
        // imm_set.add(4); // will give error
        // System.out.println(imm_set);

    }
}
