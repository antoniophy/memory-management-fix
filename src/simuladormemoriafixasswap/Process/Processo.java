package simuladormemoriafixasswap.Process;

import java.time.LocalDate;

public class Processo {
    
    private int pid;
    private int size;
    private LocalDate uptime;
    private int pageSize;
    private int LogicalAddressSize;
    private boolean upruning;
    
    public Processo(int pid, int size, int pageSize){
		this.pid = pid;
		this.size = size;
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public LocalDate getUptime() {
        return uptime;
    }

    public void setUptime(LocalDate uptime) {
        this.uptime = uptime;
    }

    public int getSize() {
        return size;
    }

    public int getPid() {
        return pid;
    }

    public int getLogicalAddressSize() {
        return LogicalAddressSize;
    }

    public void setLogicalAddressSize(int logicalAddressSize) {
        LogicalAddressSize = logicalAddressSize;
    }

    public boolean isUpruning() {
        return upruning;
    }

    public void setUpruning(boolean upruning) {
        this.upruning = upruning;
    }
}
