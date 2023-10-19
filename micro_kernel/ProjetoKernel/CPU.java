package micro_kernel;

class CPU implements Runnable {
    private String cpu;

    public CPU(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void run() {
        // Implemente a lógica de execução da CPU aqui
    }
}
