package simuladormemoriafixas.Manager;


import simuladormemoriafixas.Memory.Memory;
import simuladormemoriafixas.Memory.Partition;
import simuladormemoriafixas.Process.Process;

import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class Alocador extends Thread{

	private Memory memory;
	private List<Process> processes;
	private int fragmented;
	private int executed;
	private int notExecuted;
	private int timeExecution;                  

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

            while (iterator.hasNext()) {

                Partition partition = iterator.next();

                if (partition.getPidProcess() == 0) {

                    partition.setPidProcess(process.getPid());
                    partition.setProcessSizeInPartition(process.getSize());

                    synchronized (process) {
                        process.setUpruning(true);
                        executed++;
                    }

                    if (process.getSize() < partition.getSize()) {

                        System.out.println("Houve fragmentacao interna");
                        fragmented++;
                        break;
                    }

                } else {

                    System.out.println("Partition ocupada! Vou para a proxima partition");

                    Process processExecuting = processes.get(partition.getPidProcess() - 1);

                    synchronized (partition) {
                        synchronized (processExecuting) {

                            int cpuTime = processExecuting.getCpuTime();
                            processExecuting.setCpuTime(--cpuTime);

                            System.out.println("Decrementando cpu time do processo: " + processExecuting.getPid() + " Tempo para finalizar, " + processExecuting.getCpuTime() + " Unidades de CPU");
                        }
                    }

                    if (processExecuting.getCpuTime() <= 0) {
                        System.out.println("Prcesso " + processExecuting.getPid() + " Terminou! ");

                        synchronized (partition) {
                            synchronized (processExecuting) {
                                processExecuting.setUpruning(false);
                                System.out.println("Vou aproveitar e colocar esse outro processo! Colocando processo: " + process.getPid());
                                executed++;
                            }
                        }

                        partition.setPidProcess(process.getPid());
                        partition.setProcessSizeInPartition(process.getSize());

                        synchronized (process) {
                            process.setUpruning(true);
                        }

                        if (process.getSize() < partition.getSize()) {
                            System.out.println("Houve fragmentacao externa");
                            fragmented++;
                        }

                        break;
                    }
                }

                stopCPU();

            }

            timeExecution++;

            if (!process.isUpruning()) {
                System.out.println("Não foi possível encontrar partitions, Houve uma fragmentacao!");
                notExecuted++;
            }
        }

        addRemainingTime();

	}

    private void addRemainingTime() {

	    Iterator<Partition> iterator = memory.getPartitions().iterator();

	    int maxCpuTimeToExecute = 0;

	    while (iterator.hasNext()){
	        Process process = processes.get(iterator.next().getPidProcess() - 1);

	        if(process.getCpuTime() > maxCpuTimeToExecute){
	            maxCpuTimeToExecute = process.getCpuTime();
            }

        }

        timeExecution += maxCpuTimeToExecute;

    }

    private void stopCPU(){
        try {
            Thread.sleep(0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printFinalRelatorio() {
        System.out.println();
        System.out.println();
	    System.out.println("================== Memoria Finalizada ============== ");
	    System.out.println("Tempo Total de Execução: " + timeExecution + " unidades de CPU ");
	    System.out.println("Total de fragmentação interna: " + fragmented);
	    System.out.println("Tempo medio de execução: " + (timeExecution / executed) + " unidades de CPU ");
	    System.out.println("Processos executados: " + executed);
	    System.out.println("Processos descartados: " + notExecuted);
	    System.out.println("====================================================");

    }
}
