package entities;

import java.util.LinkedList;
import java.util.Queue;
import java.util.PriorityQueue;

class Scheduler implements Runnable {
    int capacity;
    Queue []queues;
    int []priorities;
    int []indices;

    public Scheduler(){
    }

    public int compare(Process p1, Process p2) {
        try{
            if (p1 instanceof Thread && p2 instanceof Thread) {
                int c1 = p1.getCliente().getPrioridadeCliente();
                int c2 = p2.getCliente().getPrioridadeCliente();
                int priority1 = p1.getPriority();
                int priority2 = p2.getPriority();
                int num;
                if (c1 == c2 && priority1 < priority2){
                        return -1; // p1 is less important
                    } else if (c1 == c2 && priority1 > priority2) {
                        return 1; // p1 is more important
                    } else if(c1 == c2 && priority1 == priority2) {
                        return 0; // priorities are equal
                    }
            else{
                PriorityComparator pc = new PriorityComparator();
                int r = pc.compare(p1.getCliente(),p2.getCliente());
                return r;
            }
            
    }
}
        finally{
            System.out.println("Erro ao executar o escalonador");
            return 10;
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
    
    @Override
    public void run() {
        System.out.println("Eu sou uma thread trabalhadora de Scheduler");
    }
}
