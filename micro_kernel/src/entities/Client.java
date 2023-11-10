package entities;
import java.util.*;

class Client implements Runnable {
    private String cliente;
    private int prioridade;
    private int idCliente;
    private static List<Client> lista;

    public int getIdCliente(){
        return this.idCliente;
    }

    public int getPrioridadeCliente(){
        return this.prioridade;
    }

    public String getCliente(){
        return this.cliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setPrioridadeCliente(int prioridade){
        this.prioridade = prioridade;
    }

    public void setCliente(String cliente){
        this.cliente = cliente;
    }

    public List<Client> getLista(){
        return lista;
    }

    @Override
    public void run() {
        System.out.println("Eu sou uma thread trabalhadora de Cliente");
    }
}
