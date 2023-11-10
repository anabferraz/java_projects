package entities;
import java.util.*;

public class Kernel {
    List<Client> listaClient = new ArrayList<Client>();

    public Kernel() {
    }

    public void start() {
        // Thread do escalador de CPUs
        Thread schedulerThread = new Thread(new Scheduler());
        schedulerThread.start();
        schedulerThread.run();

        // Threads simulando CPUs (Multiprocessamento)
        Thread cpu1 = new Thread(new CPU("CPU 1"));
        Thread cpu2 = new Thread(new CPU("CPU 2"));
        cpu1.start();
        cpu2.start();
        cpu1.run();
        cpu2.run();

        // Threads clientes para serem atendidas
        for (int i = 1; i < 5; i++) {
            Thread clientThread = new Thread();
            Client cliente = new Client();
            Scanner scan = new Scanner(System.in);
            int idCliente = i;
            cliente.setIdCliente(idCliente);
            System.out.println("Digite o nome do cliente "+ i + ": ");
            String nomeCliente = scan.nextLine();
            cliente.setCliente(nomeCliente);
            System.out.println("Digite a prioridade: ");
            int prioridade = scan.nextInt();
            cliente.setPrioridadeCliente(prioridade);
            listaClient.add(cliente);
            System.out.println("Cliente "+nomeCliente+" adicionado com prioridade "+prioridade);
            System.out.println("O ID do cliente é "+ idCliente);
            clientThread.start();
            clientThread.run();

        }
    }

    public List<Client> retornaLista(){
        return listaClient;
    }
}

