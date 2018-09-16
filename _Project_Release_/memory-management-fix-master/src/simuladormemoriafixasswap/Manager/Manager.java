package simuladormemoriafixasswap.Manager;


public class Manager extends Thread{

	private final int uptime;
	private Memory memory; 
	
	public Manager(int _uptime)
	{
		this.uptime = _uptime;
	}

	private void allocate(){

	}

	@Override
    public void run(){

    	//Has memory?
    	while(memory.getSize() > 0) {
    		this.allocate();
    	}
    	
    }
	
}
