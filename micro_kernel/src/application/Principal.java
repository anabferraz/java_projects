package application;

import entities.*;
import entities.Process;
import java.util.*;

public class Principal{
    public static void main (String[]args){
        Kernel kernel = new Kernel();
        kernel.start();
        System.out.println("Eu sou a thread principal");

        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("******** Bem-vindo(a) ao menu principal! *********");
            System.out.println("Ao iniciar o código, o Kernel já foi inicializado,");
            System.out.println("juntamente com as Threads CPU e Cliente.");
            System.out.println("Você gostaria de cadastrar uma nova Task? \ns/n");
            char resp = sc.next().charAt(0);
            if (resp == 's'){
                Process item = new Process();
                item.Process(item);
            }
            else if (resp == 'n'){
                System.out.println("Retornando ao menu principal...");
            }

        }
    }
}