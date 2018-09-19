package simuladormemoriafixas.Process;

public class Process {
    
    private int pid;
    private int size;
    private int cpuTime;
    private boolean upruning;
    
    public Process(int pid, int size, int cpuTime) {
        this.pid = pid;
        this.size = size;
        this.cpuTime = cpuTime;
    }

    public int getSize() {
        return size;
    }

    public int getPid() {
        return pid;
    }

    public boolean isUpruning() {
        return upruning;
    }

    public void setUpruning(boolean upruning) {
        this.upruning = upruning;
    }

    public int getCpuTime() {
        return cpuTime;
    }

    public void setCpuTime(int cpuTime) {
        this.cpuTime = cpuTime;
    }
}
