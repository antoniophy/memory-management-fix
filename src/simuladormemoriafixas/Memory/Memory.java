package simuladormemoriafixas.Memory;

import java.util.ArrayList;
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

	@Override
	public void run(){

		final int tamanhoPartition = tamanhoMemoria / 10;
        partitions = new ArrayList<>();

		for(int i = 0; i < 10; i++){
			partitions.add( new Partition(tamanhoPartition) );
		}

	}
}