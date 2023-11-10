package entities;
import java.util.*;

public class CircularPriorityQueue {
    private Queue<Process>[] queues;
    private int[] priorities;
    private int capacity;
    private int[] indices;

    public CircularPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queues = new Queue[capacity];
        this.priorities = new int[4];
        this.indices = new int[4];

        for (int i = 3; i >= 0; i--) {
            queues[i] = new LinkedList<Process>();
            priorities[i] = i;
            indices[i] = 3;
        }
    }
    public void enqueue(Process p, CircularPriorityQueue queue) {
        int priority = p.getPriority();
        String name = p.getItem();
        Client cliente = p.getCliente();
        if (priority >= 0 && priority < 4) {
            for (int i = 0;i<4;i++){
                if (queues[priority].size() < capacity && priority == i) {
                    boolean bo = queues[priority].add(p);
                    if (bo = true){
                        System.out.println("Tarefa "+name+ " adicionada na fila");
                        p.addToReadyQueue(p,queue);
                        break;
                    }
                } else if (queues[priority].size() == capacity && priority == i){
                    System.out.println("Fila de prioridade " + priority + " está cheia.");
                    break;
                }
                }
        } else {
            System.out.println("Prioridade inválida.");
        }
    }

    public Process dequeue() {
        Scheduler escalonador = new Scheduler();

        for (int i = 0; i <= 3; i++) {
            int priority = (i + indices[i]) % 4;
            
            if (!queues[priority].isEmpty()) {
                Process item = queues[priority].poll();
                indices[i] = (indices[i] + 1) % 4;
                System.out.println("Executando a tarefa: "+ item.getCliente());
                return item;

            }
        }
        System.out.println("Todas as filas de prioridade estão vazias.");
        return null;
    }
    public int getCapacity(){
        return capacity;
    }
}
