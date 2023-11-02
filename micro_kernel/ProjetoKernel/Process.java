import java.util.Scanner;
public class Process {
        private String name;
        private int priority;
        private Client cliente;
    
        public int getPriority() {
            return priority;
        }
        public String getItem() {
            return name;
        }
        public Client getCliente(){
            return cliente;
        }
        public void setName(String name){
            this.name = name;
        }
        public void setPriority(int priority){
            this.priority = priority;
        }
        public void setCliente(Client cliente){
            this.cliente = cliente;
        }
        public void execute(){
            
            System.out.println("Executing task: " + name + " do cliente "+ cliente);
        }
        public void criarTask(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Digite a tarefa:");
            String task = scan.nextLine();
            setName(task);
            System.out.println("Digite a prioridade:");
            int priority = scan.nextInt();
            setPriority(priority);
            System.out.println("Tarefa "+name+" adicionada com prioridade "+priority);
            
        }
    
}
