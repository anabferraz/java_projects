import java.util.*;

public class PriorityComparator implements Comparator<Client> {
    int capacity;
    Queue []queues;
    int []priorities;
    int []indices;

    public int compare(Client c1, Client c2){
        int cliente1 = c1.getPrioridadeCliente();
        int cliente2 = c2.getPrioridadeCliente();
        if (cliente1>cliente2){
            int retorno = 1;
            return retorno;
        }
        else if(cliente1<cliente2){
            int retorno = -1;
            return retorno;
        }
        else {
            throw new IllegalArgumentException("Both items must be instances of Cliente.");
        }
    }

}
