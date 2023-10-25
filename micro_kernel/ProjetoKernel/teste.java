//import micro_kernel.*; 
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;
import java.util.*;

public class teste{
    public static void main (String[]args){
        CircularPriorityQueue<String> priorityQueue = new CircularPriorityQueue<>(10);
        Process item1 = new Process("Item 1 - Prioridade 1",1);
        Process item2 = new Process("Item 2 - Prioridade 0",0);
        Process item3 = new Process("Item 3 - Prioridade 2",2);
        Process item4 = new Process("Item 4 - Prioridade 1",1);

        priorityQueue.enqueue(item1);
        priorityQueue.enqueue(item2);
        priorityQueue.enqueue(item3);
        priorityQueue.enqueue(item4);

        priorityQueue.dequeue(item1);
        priorityQueue.dequeue(item2);
        priorityQueue.dequeue(item3);
        priorityQueue.dequeue(item4);
        System.out.println(item1);
        System.out.println(item2);
        System.out.println(item3);
        System.out.println(item4);
    }
}