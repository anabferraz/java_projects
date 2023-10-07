import java.util.Queue;
import java.util.LinkedList;

class CircularPriorityQueue<T> {
    private Queue<T>[] queues;
    private int[] priorities;
    private int capacity;
    private int[] indices;

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

    public void enqueue(int priority, T item) {
        if (priority >= 0 && priority < 3) {
            if (queues[priority].size() < capacity) {
                queues[priority].add(item);
            } else {
                System.out.println("Fila de prioridade " + priority + " está cheia.");
            }
        } else {
            System.out.println("Prioridade inválida.");
        }
    }

    public T dequeue() {
        for (int i = 0; i < 3; i++) {
            int priority = (i + indices[i]) % 3;
            if (!queues[priority].isEmpty()) {
                T item = queues[priority].poll();
                indices[i] = (indices[i] + 1) % 3;
                return item;
            }
        }
        System.out.println("Todas as filas de prioridade estão vazias.");
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
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
}