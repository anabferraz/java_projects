//import micro_kernel.*; 
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class teste{
    public static void main (String[]args){
        Kernel kernel = new Kernel();
        kernel.start();
        CircularPriorityQueue priorityQueue = new CircularPriorityQueue(10);
        Process item1 = new Process();
        Process item2 = new Process();
        Process item3 = new Process();
        Process item4 = new Process();
        item1.criarTask();
        item2.criarTask();
        item3.criarTask();
        item4.criarTask();

        priorityQueue.enqueue(item1);
        priorityQueue.enqueue(item2);
        priorityQueue.enqueue(item3);
        priorityQueue.enqueue(item4);

        priorityQueue.dequeue();
        priorityQueue.dequeue();
        priorityQueue.dequeue();
        priorityQueue.dequeue();
    }
}