//import micro_kernel.*; 
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.LinkedList;

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