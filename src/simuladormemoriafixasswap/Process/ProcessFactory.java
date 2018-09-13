package simuladormemoriafixasswap.Process;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ProcessFactory {

    private List<Processo> processos;
    private final int DEFAULT_PROCESS_ID_SIZE = 200;
    private final int DEFAULT_MAX_PROCESS_SIZE = 100;
    private final int DEFAULT_MAX_PAGE_SIZE = 50;


    public ProcessFactory(){

        if(processos == null) {
            processos = new ArrayList<>();
        }

    }

    protected void doCreate() {
        Random random = new Random();
        Processo processo;

        for(int i = 0; i < 200; i++){
            processo = new Processo(random.nextInt(DEFAULT_PROCESS_ID_SIZE), random.nextInt(DEFAULT_MAX_PROCESS_SIZE), random.nextInt(DEFAULT_MAX_PAGE_SIZE));
            processos.add(processo);
        }
    }

    protected Processo getProcess(int randomProcess){

        if(randomProcess > 199){
            return processos.get(199);
        }

        return processos.get(randomProcess);
    }

    public int getProcessosCreatedSize(){
        return this.processos.size();
    }

}
