//package micro_kernel;
import java.util.Scanner;

class Client implements Runnable {
    private String cliente;
    private int prioridade;

    public int getPrioridadeCliente(){
        return prioridade;
    }

    public String getCliente(){
        return cliente;
    }

    public void setPrioridadeCliente(int prioridade){
        this.prioridade = prioridade;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public void criarCliente(int i){
        Scanner scan = new Scanner(System.in);
        System.out.println("Digite o nome do cliente "+ i + ": ");
        String cliente = scan.nextLine();
        setCliente(cliente);
        System.out.println("Digite a prioridade: ");
        int prioridade = scan.nextInt();
        setPrioridadeCliente(prioridade);
        System.out.println("Cliente "+cliente+" adicionado com prioridade "+prioridade);
    }

    @Override
    public void run() {
        // Implemente a lógica do cliente aqui
    }
}
