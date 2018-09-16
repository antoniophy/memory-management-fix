package simuladormemoriafixasswap.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Random;

public class ProcessFactory {

    private ArrayList<Process> processList processos;
    private final int DEFAULT_PROCESS_ID_SIZE = 200;
    private final int DEFAULT_MAX_PROCESS_SIZE = 100;
    private final int DEFAULT_MAX_START_TIME = 10;
    private final int DEFAULT_MAX_END_TIME = 50;


    public ProcessFactory(){

        if(processList == null) {
            processList = new ArrayList<Process>();
        }

    }

    protected void doCreate() {
        Random random = new Random();
        Process processList;

        for(int i = 0; i < 200; i++){
            processList = new Process(random.nextInt(DEFAULT_PROCESS_ID_SIZE), random.nextInt(DEFAULT_MAX_PROCESS_SIZE), random.nextInt(DEFAULT_MAX_START_TIME), random.nextInt(DEFAULT_MAX_END_TIME));
            processList.add(processList);
        }
    }

    protected Process getProcess(int randomProcess){

        if(randomProcess > 199){
            return processList.get(199);
        }

        return processList.get(randomProcess);
    }

    public static ArrayList<Process> getAllProcess(){
        Collections.sort(processList);
        return processList;
    }

    public int getProcessosCreatedSize(){
        return this.processList.size();
    }

}
