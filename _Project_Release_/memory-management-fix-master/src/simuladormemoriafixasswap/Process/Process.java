package simuladormemoriafixasswap.Process;

public class Process implements Comparable<Process> {
    
    private int pid;
    private int size;
    private int start_time;
    private int end_time;
    
    public Process(int pid, int size, int start_time, int end_time){
		this.pid = pid;
		this.size = size;
        this.start_time = start_time;
        this.end_time = end_time;
    }

    public int getPid() {
        return pid;
    }

    public int getSize() {
        return size;
    }

    public int getStartTime() {
        return start_time;
    }
    
    public int getEndTime() {
        return end_time;
    }

    @Override
    public int compareTo(Process _p) {
        if (this.start_time < _p.start_time) {
            return -1;
        } else if (this.start_time == _p.start_time) {
            return 0;
        } else {
            return 1;
        }       
    }
}
