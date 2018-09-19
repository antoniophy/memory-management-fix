package simuladormemoriafixas.Manager;


import simuladormemoriafixas.Memory.Memory;
import simuladormemoriafixas.Memory.Partition;
import simuladormemoriafixas.Process.Process;

import java.util.Iterator;
import java.util.List;

public class Alocador extends Thread{

	private int runTime;
	private Memory memory;
	private List<Process> processes;
	private int fragmented;
	private int executed;

	public Alocador(Memory memory, List<Process> processes)
	{
	    this.memory = memory;
	    this.processes = processes;
	}
	
	@Override
	public void run()
	{
        Iterator<Process> iteratorProcess = processes.iterator();

        while(iteratorProcess.hasNext()) {

        	Process process = iteratorProcess.next();

        	System.out.println("Vou executar o processo de pid: " + process.getPid());

			Iterator<Partition> iterator = memory.getPartitions().iterator();

			while(iterator.hasNext()){
				Partition partition = iterator.next();

				if(partition.getPidProcess() == 0){

					partition.setPidProcess(process.getPid());
					partition.setProcessSizeInPartition(process.getSize());
                    process.setUpruning(true);

                    stopCPU();

					if(process.getSize() < partition.getSize()){

					    System.out.println("Houve fragmentacao interna");
                        fragmented++;
                    }

                } else {

				    System.out.println("Partition ocupada! Vou para a proxima partition");
                    Process processExecuting = processes.get(partition.getPidProcess());
                    int cpuTime = processExecuting.getCpuTime();
                    processExecuting.setCpuTime(cpuTime--);

                    System.out.println("Decrementando cpu time do processo: " + processExecuting.getPid());

                    stopCPU();

                    if(processExecuting.getSize() <= 0){
                        System.out.println("Prcesso " + processExecuting.getPid() + "Terminou! ");
                        processExecuting.setUpruning(false);
                        System.out.println("Vou aproveitar e colocar esse outro processo!");

                        try {
                            Thread.sleep(100);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        partition.setPidProcess(process.getPid());
                        partition.setProcessSizeInPartition(process.getSize());

                        if(process.getSize() < partition.getSize()){

                            System.out.println("Houve fragmentacao externa");
                            fragmented++;
                        }
                    }
     			}

     			runTime++;

     			if(!process.isUpruning()){
     			    System.out.println("Não foi possível encontrar partitions, Houve uma fragmentacao!");
     			    fragmented++;
                   stopCPU();
                }
			}
        }

        cleanPartitions();

	}

	private void stopCPU(){
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

	private void cleanPartitions(){

	    int totalPartitionCleaned = 0;

	    Iterator<Partition> partition = memory.getPartitions().iterator();

	    while (partition.hasNext()){

	        Partition partitionAlloc = partition.next();

	        if(partitionAlloc.getPidProcess() != 0){

	            Process process = processes.get(partitionAlloc.getPidProcess());

	            if(process.getCpuTime() > 0){
	                int cpuTime = process.getCpuTime();
	                process.setCpuTime(cpuTime--);

	                stopCPU();

	                if(process.getCpuTime() <= 0){
                        System.out.println("Partition Livre! ");
                        totalPartitionCleaned++;
                    }
                }

            } else {
	            System.out.println("Partition Livre! ");
	            totalPartitionCleaned++;
	            stopCPU();
            }

            runTime++;
	    }

	    if(totalPartitionCleaned < memory.getPartitions().size()){
            this.cleanPartitions();
        }
    }

    public void printFinalRelatorio() {

	    System.out.println("================== Memoria Finalizada ============== ");
	    System.out.println("Run time: " + runTime + " unidades de CPU ");
	    System.out.println("Total de Fragmentação: " + fragmented);

    }
}
