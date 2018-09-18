package simuladormemoriafixasswap.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessMaker extends Thread {

    private final List<Process> processes;
    private final int DEFAULT_MAX_PROCESS_SIZE = 100;
    private final int DEFAULT_MAX_CPU_TIME = 10;

    public ProcessMaker(){
        this.processes = new ArrayList<>();
    }

    @Override
    public void run(){
        Random random = new Random();
        Process process;

        for(int i = 0; i < 200; i++){
            process = new Process(i, random.nextInt(DEFAULT_MAX_PROCESS_SIZE), random.nextInt(DEFAULT_MAX_CPU_TIME));
            processes.add(process);
        }
    }

    public List<Process> getProcess(){
        return this.processes;
    }
}
