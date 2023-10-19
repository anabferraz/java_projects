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

