package application;

import entities.*;
import entities.Process;
import java.util.*;

public class Principal{
    public static void main (String[]args){
        Kernel kernel = new Kernel();
        kernel.start();
        System.out.println("Eu sou a thread principal");
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