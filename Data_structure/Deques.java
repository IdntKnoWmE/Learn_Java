package Data_structure;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

public class Deques {

    /*
        Deque = Double Ended Queue.
        Supports insertion & deletion from both front and rear.
        In Java, Deque is an interface (java.util.Deque) that extends Queue.
        It can be used as:
            Queue (FIFO)
            Stack (LIFO)
            Or a hybrid mix.
        It is part of Java Collections Framework.
     */

    static void main(String[] args) throws InterruptedException {

        System.out.println("Testing Array Deque: ");
        ArrayDequeExample();
        System.out.println("\n\n Testing LinkedList Deque: ");
        LinkedListDequeExample();
        System.out.println("\n\n Testing Concurrent Linked Deque: ");
        ConcurrentLinkedDequeExample();


    }


    public static void ArrayDequeExample(){
        /*
            ArrayDeque (most common)
            Backed by a resizable array.
            No capacity limit (grows automatically).
            Not thread-safe.
            Faster than LinkedList in most cases.
            Nulls not allowed.

            adv:
            - Must faster access to elements as elements are stored in a contiguous block of memory.
            - Zero memory overhead as the newly create array deque with default constructor has no internal array
            and uses minimal memory.
            - Nulls are not allowed as internally nulls are used for empty slots which avoids potential bugs and also
            simplifies the logic for user to manage the head and tail pointers.
            - Optimised for both stack and queue behaviour.

            dis_adv:
            - Whenever new elements are added, the internal logic double the size of arraydeque like arraylist but when
            the elements are removed then there's no logic of shrinkage the memory like arraylist leading to waste of
            resources. It also causes problem in garbage collection also.
            - Iterator fails in middle of iteration if you change the structure of deque.
            - Bulk operations like addAll() are much slower, why because arraydeque copies element one by one when
            bulk operation like insert is done where if you arraylist they are way more optimised for it by using
            System.arraycopy() for adding any number of elements to the end.

         */

        Deque<String> deque = new ArrayDeque<>();

        // Insert at both sides
        deque.addLast("A"); // O(1)
        deque.offerLast("N");

        deque.addFirst("Y"); // O(1)
        deque.offerFirst("A");

        deque.offerLast("T");
        deque.addFirst("J");

        System.out.println("Current deque is: " + deque);
        System.out.println("Current size of deque is: " + deque.size()); // O(1)

        // Remove elements from both sides
        System.out.println("The first element is: " + deque.removeFirst()); // O(1)
        System.out.println("The Last element is: " + deque.removeLast()); // O(1)

        // Peek what are the elements available at each end, no removing
        System.out.println("Front element is: " + deque.peekFirst()); // O(1)
        System.out.println("Last element is: " + deque.peekLast()); // O(1)

        System.out.println("Final deque is: " + deque);
        System.out.println("Final size of deque is: " + deque.size()); // O(1)

        System.out.print("The elements in deque now are: ");
        Iterator it = deque.iterator();
        while(it.hasNext()) System.out.printf("%s ", it.next());

    }
    // Use Case: Stack, Queue, LRU cache, BFS

    public static void LinkedListDequeExample(){

        /*
        - Backed by a doubly-linked list.
        - Implements both List and Deque.
        - Allows null elements.
        - Slower than ArrayDeque due to pointer chasing and memory overhead.

        Adv:
        - Guaranteed O(1) time complexity for all additions and removal of elements at both ends as it is just adding
        new node or removing at each end unlike arraydeque which resize it memory in case of capacity of it is excluded
        leading to a loss of O(n) time sometimes.
        - If you have the reference to any node in between its easy to remove it or add any elements after or before it.
        - No fixed capacity constraint.
        - Can store null elements.

        dis_adv:
        - Need extra memory to store the reference to next and prev elements.
        - Poor cache performance as elements are stored randomly in space and an extra task is required to find the
        addressed where next or prev element is saved.
        - Same above reason is responsible for its slower iteration also.
         */

        Deque<String> deque = new LinkedList<>();

        // Insert at both sides
        deque.addLast("A"); // O(1)
        deque.offerLast("N");

        deque.addFirst("Y"); // O(1)
        deque.offerFirst("A");

        deque.offerLast("T");
        deque.addFirst("J");

        deque.addLast(null);  // allowed

        System.out.println("Current deque is: " + deque);
        System.out.println("Current size of deque is: " + deque.size()); // O(1)

        // Remove elements from both sides
        System.out.println("The first element is: " + deque.removeFirst()); // O(1)
        System.out.println("The Last element is: " + deque.removeLast()); // O(1)

        // Peek what are the elements available at each end, no removing
        System.out.println("Front element is: " + deque.peekFirst()); // O(1)
        System.out.println("Last element is: " + deque.peekLast()); // O(1)

        System.out.println("Final deque is: " + deque);
        System.out.println("Final size of deque is: " + deque.size()); // O(1)

        System.out.print("The elements in deque now are: ");
        Iterator it = deque.iterator();
        while(it.hasNext()) System.out.printf("%s ", it.next());

    }

    // Use cases:
    //      - When null values need to be stored.
    //      - Frequent insert/remove at both ends.


    public static void ConcurrentLinkedDequeExample() throws InterruptedException{

        /*
        Features:
            Thread-safe, non-blocking (lock-free) implementation.
            Uses CAS (Compare-And-Swap) internally.
                - This CAS is an atomic operation used in multithreading to achieve synchronization without traditional
                locks.
                - It works in a very simple way, this algo has three things memory(you want to update), curr_val(curr
                value at the memory place, and expected_value(the value which you want to have at the memory loc).
                - Now if two threads comes with the task to update the curr value at memory supposing it as 1 then
                threadA will send req to cpu in the form of (current_value, expected_value) let's say here (1,2) at
                sametime threadB also send the same req with same values (1,2) to cpu.
                - Now CPU will check for threadA and will match if current value at the memory and the value send by
                threadA are same and if same then it will change the value and at the same time cpu will check for
                threadB task but now the curr value at memory is not equal to the curr value claimed by threadB so, his
                operation will be cancelled. Off course, threadB can change the value in retry with curr_value changed.

            Ideal for high-concurrency environments.
            Unbounded capacity.

        Use Cases:
            Work queues in concurrent systems.
            Multiple producer-consumer scenarios.
            When low-latency and thread-safety are both required.


         */

        Deque<String> deque = new ConcurrentLinkedDeque<>();

        // Producer 1
        Thread producer1 = new Thread(() -> {
            for(int i = 0; i<=5; i++){
                String task = "Producer 1: Task " + i;
                deque.addFirst(task);
                System.out.println("Added Producer 1: Task: " + task);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Producer 2
        Thread producer2 = new Thread(() -> {
            for(int i = 0; i<=5; i++){
                String task = "Producer 2: Task " + i;
                deque.addLast(task);
                System.out.println("Added Producer 2: Task: " + task);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Consumer
        Thread consumer = new Thread(() -> {
            while(true){

                if(deque.peekFirst() != null) System.out.println("Consumed from front: " + deque.removeFirst());
                if(deque.peekLast() != null) System.out.println("Consumed from back: " + deque.removeLast());
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });

        // Start all threads
        producer1.start();
        producer2.start();
        consumer.start();

        // Optional: Wait for producer threads to finish
        producer1.join();
        producer2.join();

        // Interrupt the consumer thread to stop its infinite loop
        consumer.interrupt();

    }

}

