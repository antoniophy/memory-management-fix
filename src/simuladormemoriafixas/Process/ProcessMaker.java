package simuladormemoriafixas.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessMaker extends Thread {

    private final List<Process> processes;
    private int DEFAULT_MAX_PROCESS_SIZE;
    private final int DEFAULT_MAX_CPU_TIME = 10;

    public ProcessMaker(int memorySize) {
        this.processes = new ArrayList<>();
        DEFAULT_MAX_PROCESS_SIZE = memorySize / 10;
    }


    @Override
    public void run(){
        Random random = new Random();

        for(int id = 1; id < 200; id++){
            processes.add(new Process(id, random.nextInt(DEFAULT_MAX_PROCESS_SIZE), random.nextInt(DEFAULT_MAX_CPU_TIME)));
        }
    }

    public List<Process> getProcess(){
        return this.processes;
    }
}
