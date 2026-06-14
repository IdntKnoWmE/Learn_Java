package Data_structure;

import java.util.concurrent.*;
import java.time.*;

public class BlockingQueues {

    static void main() throws InterruptedException {
        /*
            What are Blocking Queues?

                They are thread-safe queues from java.util.concurrent.
                Unlike normal queues, they can block a thread:
                    If the queue is full, a producer trying to insert will wait.
                    If the queue is empty, a consumer trying to remove will wait.
                This makes them perfect for producer-consumer problems.

            Think of it like a restaurant kitchen:

                The chef (producer) puts dishes into a serving counter (queue).
                The waiter (consumer) picks dishes from the counter.
                If the counter is full → chef must wait.
                If the counter is empty → waiter must wait.

            Blocking queues uses function like put() and take() which are actually thread safe and
            wait if queue is full or empty.
         */

        // Type :
        System.out.println("Testing Array Blocking Queue");
        // ArrayBlockingQueueExample();
        System.out.println("Testing Linked Blocking Queue");
        // LinkedBlockingQueueExample();

        System.out.println("Testing Priority Blocking Queue");
        // PriorityBlockingQueueExample();

        System.out.println("Testing Synchronous Blocking Queue");
        SynchronousQueueExample();



    }
    public static void ArrayBlockingQueueExample(){

        /**

         - It's a bounded blocking queue backed by a fixed-size array like if queue is full then no
          input will be taken.
         - The capacity is given at the time of creation.
         - Uses ReentrantLock internally for thread safety.
         - Maintains FIFO order.
         - It uses one ReentrantLock. The same lock is used for both put and take operations.
         - Since it’s mandatory to mention initial capacity in it, we can end up allocating more space than required.

          **/

        BlockingQueue<String> restaurant = new ArrayBlockingQueue<>(2); // Capacity 2 (is required)

        // Consumer Thread
        new Thread(() -> {
            try{
                Thread.sleep(2000); // wait for producer to fill for 2 seconds
                System.out.println(restaurant.getClass().getSimpleName() + " Consumer taking now...");
                System.out.println(restaurant.getClass().getSimpleName() + " Consumed: " + restaurant.take());
                System.out.println(restaurant.getClass().getSimpleName() + " Consumed: " + restaurant.take());
                System.out.println(restaurant.getClass().getSimpleName() + " Consumed: " + restaurant.take());
            }
            catch (Exception e) { e.printStackTrace();}
        }).start();

        // Producer thread
        new Thread(() -> {
            try {
                restaurant.put("Dish1");
                System.out.println(restaurant.getClass().getSimpleName() + " Produced Dish1");
                restaurant.put("Dish2");
                System.out.println(restaurant.getClass().getSimpleName() + " Produced Dish2");

                System.out.println(restaurant.getClass().getSimpleName() + " Producer waiting to add Dish3 (queue full)...");
                restaurant.put("Dish3"); // Blocks until consumer takes something
                System.out.println(restaurant.getClass().getSimpleName() + " Produced Dish3 (producer unblocked)");
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();



    }

    public static void LinkedBlockingQueueExample(){

        /**

         - A LinkedBlockingQueue in Java is optionally bounded. This means it can be created as either bounded or
         unbounded.

         - When you create a LinkedBlockingQueue using a constructor that takes an integer argument for the
         initial capacity (e.g., new LinkedBlockingQueue<>(capacity)), it becomes a bounded queue. This capacity
         defines the maximum number of elements the queue can hold.

         - Unbounded LinkedBlockingQueue: If you create a LinkedBlockingQueue using the no-argument constructor
         (e.g., new LinkedBlockingQueue<>()), it is considered unbounded. In this case, its capacity is effectively
         Integer.MAX_VALUE, allowing it to grow dynamically based on available memory.

         - Backed by a linked list.
         - Also FIFO.
         - It uses separate ReentrantLock for read and write operations. This prevents contention between producer and
         consumer threads.
         - Memory space	Since it’s mandatory to mention initial capacity in it, we can end up allocating more space
         than required.	It usually doesn’t pre-allocate nodes. Therefore, its memory footprint matches its size.

         * */

        BlockingQueue<String> restaurant = new LinkedBlockingQueue<>(2); // max_capacity = 2

        // Consumer Thread
        new Thread(() -> {
            try{
                Thread.sleep(2000); // wait for producer to fill for 2 seconds
                System.out.println(restaurant.getClass().getSimpleName() + " Consumer taking now...");
                System.out.println(restaurant.getClass().getSimpleName() + " Consumed: " + restaurant.take());
                System.out.println(restaurant.getClass().getSimpleName() + " Consumed: " + restaurant.take());
                System.out.println(restaurant.getClass().getSimpleName() + " Consumed: " + restaurant.take());
            }
            catch (Exception e) { e.printStackTrace();}
        }).start();

        // Producer thread
        new Thread(() -> {
            try {
                restaurant.put("Dish1");
                System.out.println(restaurant.getClass().getSimpleName() + " Produced Dish1");
                restaurant.put("Dish2");
                System.out.println(restaurant.getClass().getSimpleName() + " Produced Dish2");

                System.out.println(restaurant.getClass().getSimpleName() + " Producer waiting to add Dish3 (queue full)...");
                restaurant.put("Dish3"); // Blocks until consumer takes something
                System.out.println(restaurant.getClass().getSimpleName() + " Produced Dish3 (producer unblocked)");
            } catch (InterruptedException e) { e.printStackTrace(); }
        }).start();
    }

    public static void PriorityBlockingQueueExample() throws InterruptedException {

        // This is a thread-safe unbounded priority queue.
        // Backed by heap (like priority queue)
        // Elements are ordered based on natural ordering (Comparing) or a custom ordering by using Comparator.
        // No blocking on insert but take() blocks if empty.
        // Operations:
            // Insert (put() / offer()) → O(log n) (heap insert)
            // Remove (take() / poll()) → O(log n)
            // Peek → O(1)

        BlockingQueue<Integer> pbq = new PriorityBlockingQueue<>();

        new Thread(() -> {
            try {
                pbq.put(30);
                System.out.println("Putted 30 and now the peek in queue is " + pbq.peek() + " " + LocalDateTime.now());
                pbq.put(10);
                System.out.println("Putted 20 and now the peek in queue is " + pbq.peek() + " " + LocalDateTime.now());
                pbq.put(20);
                System.out.println("Putted 10 and now the peek in queue is " + pbq.peek() + " " + LocalDateTime.now());
            } catch (InterruptedException e) {e.printStackTrace();}
        }).start();

        new Thread(() -> {
            try {
                while (true)
                {
                    System.out.println("Consumed: " + pbq.take() + " " + LocalDateTime.now());
                }
            } catch (InterruptedException e) {e.printStackTrace();}
        }).start();

        Thread.sleep(2000);
        pbq.put(5); // inserted later but consumed first
    }

    // Use Case:
    // Task scheduling with priorities (e.g., higher priority tasks processed earlier).
    // Job queues in thread pools.

    public static void SynchronousQueueExample(){

        /**
         - A zero-capacity queue (does not store elements).
         - Every put() must wait for a take(), and vice versa.
         - Perfect for handoff between producer and consumer threads.
         - Internally uses Exchanger-like mechanism.
         - It is just like a relay race pole where producer give pole to the consumer directly and no other pole he
            handles in that time, or you can say a waiter who handles payment like customer will raise the payment
            request and waiter will take the request and fulfill it with the payment machine he has, now in between
            this time no other payment will be done.

         Time Complexity
         - Put → O(1) (but blocks until take arrives)
         - Take → O(1) (but blocks until put arrives)
         **/

        BlockingQueue<String> restaurant = new SynchronousQueue<>();

        // Producer
        new Thread(() -> {
            try {
                System.out.println("Producer: waiting to put Task1...");
                restaurant.put("Customer making payment request");
                restaurant.put("Another Customer making payment request");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        // Consumer
        new Thread (() -> {
            try{
                Thread.sleep(2000);
                System.out.println("Consumer: waiting to pick Task1...");
                System.out.println("Waiter picked request of " + restaurant.take());
                System.out.println("Waiter picked request of " + restaurant.take());
            } catch (InterruptedException e) {e.printStackTrace();}
        }).start();

    }

    // In the Output you will only one payment request put by producer and picked by consumer no other request is
    // handled.
    // Use Case:
    //      - Direct handoff scenarios.
    //      - Used internally in ThreadPoolExecutor (CachedThreadPool) to hand tasks directly to worker threads.


}


