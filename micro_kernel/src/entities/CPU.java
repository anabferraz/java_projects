package entities;

class CPU implements Runnable {
    private String cpu;

    public CPU(String cpu) {
        this.cpu = cpu;
    }

    @Override
    public void run() {
        System.out.println("Eu sou uma thread trabalhadora da CPU");
    }

}
