import java.util.*;

public class PriorityComparator implements Comparator<Process> {
    int capacity;
    Queue []queues;
    int []priorities;
    int []indices;

    public int compare(Process p1, Process p2) {
        if (p1 instanceof Process && p2 instanceof Process) {
 
            int priority1 = p1.getPriority();
            int priority2 = p2.getPriority();

            if (priority1 < priority2) {
                return -1; // p1 is less important
            } else if (priority1 > priority2) {
                return 1; // p1 is more important
            } else {
                return 0; // priorities are equal
            }
        } else {
            throw new IllegalArgumentException("Both items must be instances of Cliente.");
        }
    }

    public void CircularPriorityQueue(int capacity) {
        this.capacity = capacity;
        queues = new Queue[3];
        priorities = new int[3];
        indices = new int[3];

        for (int i = 0; i < 3; i++) {
            queues[i] = new LinkedList<>();
            priorities[i] = i;
            indices[i] = 0;
        }
    }
}

class Process<T> {
    private T name;
    private int priority;

    public Process(T name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
    public T getItem() {
        return name;
    }
    public void execute(){
        System.out.println("Executing task: " + name);
    }


}
