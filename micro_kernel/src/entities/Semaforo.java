package entities;

import java.util.PriorityQueue;
import java.util.concurrent.*;

class Shared 
{
    static int count = 0;
}
  
class MyThread extends Thread{

    Semaphore sem;
    String threadName;
    Process p = new Process();
    public MyThread(Semaphore sem, String threadName) 
    {
        super(threadName);
        this.sem = sem;
        this.threadName = threadName;
    }
  
    @Override
    public void run() {
        PriorityQueue<Process> list = p.getListaProcess();
        String name = list.element().getItem();
        // run by thread A
        if(this.getName().equals(name))
        {
            System.out.println("Starting " + threadName);
            try 
            {
                // First, get a permit.
                System.out.println(threadName + " is waiting for a permit.");
              
                // acquiring the lock
                sem.acquire();
              
                System.out.println(threadName + " gets a permit.");
          
                // Now, accessing the shared resource.
                // other waiting threads will wait, until this 
                // thread release the lock
                for(int i=0; i < 5; i++)
                {
                    Shared.count++;
                    System.out.println(threadName + ": " + Shared.count);
          
                    // Now, allowing a context switch -- if possible.
                    // for other thread to execute
                    Thread.sleep(10);
                }
            } catch (InterruptedException exc) {
                    System.out.println(exc);
                }
          
                // Release the permit.
                System.out.println(threadName + " releases the permit.");
                sem.release();
        }
          
        
    }

    // Driver class
    public void semaphoreDemo(Semaphore sem,MyThread mt1)throws InterruptedException{
            
            // stating thread A
            mt1.start();
            
            // waiting for thread A
            mt1.join();
            
            // count will always remain 0 after
            // both threads will complete their execution
            System.out.println("count: " + Shared.count);
        }
}

