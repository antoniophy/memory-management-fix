package simuladormemoriafixasswap.MainApplication;

import simuladormemoriafixasswap.Manager.Alocador;
import simuladormemoriafixasswap.Memory.Memory;
import simuladormemoriafixasswap.Process.ProcessMaker;

public class SimuladorMemoriaFixasSwap {

    private static final int MEMORY_SIZE = 1024;

    public static void main(String[] args) {
        Memory memory = new Memory(MEMORY_SIZE);
        ProcessMaker processMaker = new ProcessMaker();

        try {

            processMaker.run();
            processMaker.join();

            memory.run();
            memory.join();

            Alocador alocador = new Alocador(memory, processMaker.getProcess());
            alocador.run();
            alocador.join();

            alocador.printFinalRelatorio();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}


