package simuladormemoriafixasswap.Memory;

import java.util.List;

public class Memory extends Thread{

	private final int tamanhoMemoria;
	private List<Partition> partitions;
	private int inMemoryProcesses;
	
	public Memory(int tamanhoMemoria)
	{
		this.tamanhoMemoria = tamanhoMemoria;
	}

	public int getInMemoryProcesses() {
		return inMemoryProcesses;
	}

	public void setInMemoryProcesses(int inMemoryProcesses) {
		this.inMemoryProcesses = inMemoryProcesses;
	}

	public List<Partition> getPartitions() {
		return partitions;
	}

	public void setPartitions(List<Partition> partitions) {
		this.partitions = partitions;
	}

	@Override
	public void run(){
		//criar particoes até o tamanho da memoria <= tamanho das particoes;
	}
}