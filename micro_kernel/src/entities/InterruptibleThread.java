package entities;

class InterruptibleThread implements Runnable{
    /**
    * Esta thread continuará executando até que seja interrompida
    */
    public void run(){
        while (true){
        /*
        *realiza alguma atividade por um tempo …
        */
            if (Thread.currentThread().isInterrupted()){
            System.out.println ("Eu estou interrompida");
            break;
            }
        }
// limpa e termina
    }
}

