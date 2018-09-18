package simuladormemoriafixasswap.Manager;


import simuladormemoriafixasswap.Memory.Memory;
import simuladormemoriafixasswap.Process.Process;

import java.util.List;

public class Alocador extends Thread{

	private int runTime;
	private Memory memory;
	private List<Process> processes;
	private int fragmented;
	private int executed;
	private int inLine;

	public Alocador(Memory memory, List<Process> processes)
	{
	    this.memory = memory;
	    this.processes = processes;
	}
	
	@Override
	public void run()
	{
        //fazer as operacoes aqui;
	}

    public void printFinalRelatorio() {
    }
}
