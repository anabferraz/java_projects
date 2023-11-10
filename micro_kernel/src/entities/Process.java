package entities;
import java.util.*;
import java.util.concurrent.Semaphore;
public class Process extends Thread {
        private String name;
        private int priority;
        private Client cliente;
        private static List<Process> listaTask = new ArrayList<Process>();
        private static CircularPriorityQueue priorityQueue = new CircularPriorityQueue(10);
        private static PriorityQueue<Process> readyQueue = new PriorityQueue<>(); // lista de prontos com prioridade
    
        public int getPrioridade() {
            return priority;
        }
        public String getItem() {
            return name;
        }
        public Client getCliente(){
            return cliente;
        }
        public void setNome(String name){
            this.name = name;
        }
        public void setPrioridade(int priority){
            this.priority = priority;
        }
        public void setCliente(Client cliente){
            this.cliente = cliente;
        }
        public void execute(){
            
            System.out.println("Executing task: " + name + " do cliente "+ cliente);
        }
        public void Process(Process item){
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a tarefa:");
            String task = scan.nextLine();
            setName(task);
            System.out.println("Digite a prioridade:");
            int priority = scan.nextInt();
            setPriority(priority);
            System.out.println("Digite o ID do cliente: ");
            int idCliente = scan.nextInt();
            Client cliente = new Client();
            List<Client> list = cliente.getLista();
            for (int i=0; i<list.size();i++){
                if(Objects.equals(idCliente, list.get(i).getIdCliente())){
                System.out.println("Tarefa "+name+" adicionada com prioridade "+priority+ "para o cliente "+list.get(i));
                listaTask.add(item);
                if (listaTask != null){
                    for (int f = 0; f<listaTask.size();f++){
                        Scheduler s = new Scheduler();
                        int numer = s.compare(listaTask.get(f),item);
                        if (numer == 1){
                            priorityQueue.enqueue(item, priorityQueue);
                        }
                        else if (numer == 0){
                            priorityQueue.enqueue(item, priorityQueue);
                        }
                        else{
                            continue;
                        }
                    }
                    break;
                }
                }addToReadyQueue(item, priorityQueue);
            }
            System.out.println("Não foi possível encontrar o cliente.");

            
        }

    public synchronized void addToReadyQueue(Process p,CircularPriorityQueue q) {
        int priority = p.getPriority();
        String name = p.getItem();
        Client cliente = p.getCliente();
        readyQueue.add(p);
        notify(); // Notifica o escalador de CPUs
        p.run(readyQueue);
    }
    public synchronized Process getNextProcess() throws InterruptedException {
        while (readyQueue.isEmpty()) {
            wait(); // Aguarda até que haja processos na fila de prontos
        }
        return readyQueue.poll();
    }
    public void run(PriorityQueue<Process> readyQueue){
        Semaphore sem = new Semaphore(2);
        MyThread thrd = new MyThread (sem,readyQueue.element().getItem());
        thrd.run();

    }
    public PriorityQueue<Process> getListaProcess(){
        return readyQueue;
    }
}
