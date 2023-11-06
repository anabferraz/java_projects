//package micro_kernel;
import java.util.*;

class Kernel {
    private PriorityQueue<Process> readyQueue;

    public Kernel() {
        readyQueue = new PriorityQueue<>(); // Fila de prontos com prioridade
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
        for (int i = 1; i < 5; i++) {
            Thread clientThread = new Thread();
            Client cliente = new Client();
            cliente.criarCliente(i);
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

}

