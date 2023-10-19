package micro_kernel;
import java.util.PriorityQueue;
class PriorityComparator implements Comparator<Process> {
    public CircularPriorityQueue(int capacity) {
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

public static void main (String[]args){
    CircularPriorityQueue<String> priorityQueue = new CircularPriorityQueue<>(5);

    priorityQueue.enqueue(1, "Item 1 - Prioridade 1");
    priorityQueue.enqueue(0, "Item 2 - Prioridade 0");
    priorityQueue.enqueue(2, "Item 3 - Prioridade 2");
    priorityQueue.enqueue(1, "Item 4 - Prioridade 1");

    String item1 = priorityQueue.dequeue();
    String item2 = priorityQueue.dequeue();
    String item3 = priorityQueue.dequeue();

    System.out.println(item1);
    System.out.println(item2);
    System.out.println(item3);
}