package simuladormemoriafixasswap;

import java.util.ArrayList;
import java.util.Random;

public class SimuladorMemoriaFixasSwap {
    public static void main(String[] args) {
        
        //Criando os processos
        //REGRA DE NÉGOCIO: Criação de 200 processos
        
    }
    
   public Processo[] criaProcessos(){
   
   //Criando uma lista de objetos que contém os processos
   ArrayList<Processo> processo = new ArrayList<Processo>();
   
   //Criando o objeto Random (Aleatorio)
   Random random = new Random();
  
   for(int i = 0; i < 200; i++)
   {
       int codigoPID = random.nextInt(500);
       int tamanhoProcesso = random.nextInt(1000);
       int tempo
   }
   
   Processo a = new Processo(codigoPID, 20, 5, 3);
   return a;
    }
}


