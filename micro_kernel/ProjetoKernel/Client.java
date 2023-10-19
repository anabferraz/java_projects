package micro_kernel;

class Client implements Runnable {
    private String cliente;

    public Client(String cliente) {
        this.cliente = cliente;
    }

    @Override
    public void run() {
        // Implemente a lógica do cliente aqui
    }
}
