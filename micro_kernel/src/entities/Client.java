package entities;
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

    @Override
    public void run() {
        System.out.println("Eu sou uma thread trabalhadora");
    }
}
