package Data_structure;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueues {

    /*

     - An unbounded blocking queue of elements that implement Delayed interface.
     - Elements can be taken only after their delay has expired like the queue holds element until their delay has
        expired.
     - Internally uses a Priority Queue (min-heap) ordered by expiration time.
     - When you call take(), it only gives you an element if its delay has expired; otherwise, the consumer blocks.
     - Think of this queue as a timer queue.
     - Element must implement the Delayed interface (which extends Comparable).
     - Time Complexity:
     Insert (put()) → O(log n) (heap insert)
     Remove (take()) → O(log n)
     Peek → O(1)

     */

    static void main (String[] args) throws InterruptedException{
        DelayQueue<ScheduledTask> delayQueue = new DelayQueue<>();

        // Producer
        System.out.println("Produced: Task1 - run after 1 sec at " + System.currentTimeMillis());
        delayQueue.add(new ScheduledTask("Task1 - run after 1 sec", 1000));

        System.out.println("Produced: Task2 - run after 4 sec at " + System.currentTimeMillis());
        delayQueue.add(new ScheduledTask("Task2 - run after 4 sec", 4000));

        System.out.println("Produced: Task3 - run after 3 sec at " + System.currentTimeMillis());
        delayQueue.add(new ScheduledTask("Task3 - run after 3 sec", 3000));

        System.out.println("Produced: Task4 - run after 2 sec at " + System.currentTimeMillis());
        delayQueue.add(new ScheduledTask("Task4 - run after 2 sec", 2000));

        // Consumer
        while(!delayQueue.isEmpty()){
            System.out.println("Consumed: " + delayQueue.take() + " at " + System.currentTimeMillis());
            // wait until delay expires
        }

    }

}

class ScheduledTask implements Delayed {

    private final String name;
    private final long startTime; // time in nanoseconds when task is pushed.

    public  ScheduledTask(String name, long delayTimeinMillisec){
        this.name = name;
        this.startTime = System.nanoTime() + TimeUnit.NANOSECONDS.convert(delayTimeinMillisec, TimeUnit.MILLISECONDS);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        long remaining = startTime - System.nanoTime();
        return unit.convert(remaining, TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        return Long.compare(this.getDelay(TimeUnit.NANOSECONDS), other.getDelay(TimeUnit.NANOSECONDS));
    }

    @Override
    public String toString(){
        return name;
    }

}

