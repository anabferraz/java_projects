import java.util.*;

public class PriorityComparator implements Comparator<Process> {
    int capacity;
    Queue []queues;
    int []priorities;
    int []indices;

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

class Process {
    private String name;
    private int priority;

    // Implemente o construtor e métodos relevantes para Process aqui
}
