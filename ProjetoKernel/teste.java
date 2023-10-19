package micro_kernel;
import java.util.PriorityQueue;

class Kernel {
    private PriorityQueue<Process> readyQueue;

    public Kernel() {
        readyQueue = new PriorityQueue<>(new PriorityComparator()); // Fila de prontos com prioridade
    }

    public void start() {
        // Thread do escalador de CPUs
        Thread schedulerThread = new Thread(new Scheduler());
        schedulerThread.start();

        // Threads simulando CPUs (Multiprocessamento)
        Thread cpu1 = new Thread(new CPU("CPU 1"));
        Thread cpu2 = new Thread(new CPU("CPU 2"));
        cpu1.start();
        cpu2.start();

        // Threads clientes para serem atendidas
        for (int i = 1; i <= 5; i++) {
            Thread clientThread = new Thread(new Client("Client " + i));
            clientThread.start();
        }
    }

    public synchronized void addToReadyQueue(Process process) {
        readyQueue.add(process);
        notify(); // Notifica o escalador de CPUs
    }

    public synchronized Process getNextProcess() throws InterruptedException {
        while (readyQueue.isEmpty()) {
            wait(); // Aguarda até que haja processos na fila de prontos
        }
        return readyQueue.poll();
    }

    public static void main(String[] args) {
        Kernel kernel = new Kernel();
        kernel.start();
    }
}

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

class Scheduler implements Runnable {
    @Override
    public void run() {
        // Implemente a lógica de escalonamento aqui
    }
}

class CPU implements Runnable {
    private String cpu;

    public CPU(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void run() {
        // Implemente a lógica de execução da CPU aqui
    }
}

class Client implements Runnable {
    private String cliente;

    public Client(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        // Implemente a lógica do cliente aqui
    }
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