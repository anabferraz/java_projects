//package micro_kernel;

import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

class CircularPriorityQueue {
    private Queue<String>[] queues;
    private int[] priorities;
    private int capacity;
    private int[] indices;

    public CircularPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queues = new Queue[capacity];
        this.priorities = new int[4];
        this.indices = new int[4];

        for (int i = 3; i >= 0; i--) {
            queues[i] = new LinkedList<String>();
            priorities[i] = i;
            indices[i] = 3;
        }
    }
    public void enqueue(Process p) {
        int priority = p.getPriority();
        String name = p.getItem();
        if (priority >= 0 && priority < 4) {
            if (queues[priority].size() < capacity) {
               queues[priority].add(name);
               if (true){
                System.out.println("Tarefa "+name+ " adicionada na fila");
               }
            } else {
                System.out.println("Fila de prioridade " + priority + " está cheia.");
            }
        } else {
            System.out.println("Prioridade inválida.");
        }
    }

    public String dequeue() {
        Scheduler escalonador = new Scheduler();

        for (int i = 0; i <= 3; i++) {
            int priority = (i + indices[i]) % 4;
            
            if (!queues[priority].isEmpty()) {
                String item = queues[priority].poll();
                indices[i] = (indices[i] + 1) % 4;
                System.out.println("Executando a tarefa: "+ item);
                return item;

            }
        }
        System.out.println("Todas as filas de prioridade estão vazias.");
        return null;
    }
}
