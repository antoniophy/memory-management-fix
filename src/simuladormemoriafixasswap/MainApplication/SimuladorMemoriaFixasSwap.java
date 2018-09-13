package simuladormemoriafixasswap.MainApplication;

import simuladormemoriafixasswap.Process.Processo;

import java.util.ArrayList;
import java.util.Random;

public class SimuladorMemoriaFixasSwap {

    public static void main(String[] args) {
        

    }
    
   public void criaProcessos(){
   
   //Criando uma lista de objetos que contém os processos
   ArrayList<Processo> processo = new ArrayList<Processo>();
   
   //Criando o objeto Random (Aleatorio)
   Random random = new Random();
  
   for(int i = 0; i < 200; i++)
   {
       int codigoPID = random.nextInt(500);
       int tamanhoProcesso = random.nextInt(1000);
   }
    }
}


