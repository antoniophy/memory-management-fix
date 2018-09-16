package simuladormemoriafixasswap.Memory;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

public abstract class Memory{

	protected ArrayList<Process> processes;
	protected char[] main_memory;

	protected static final char FREE_MEMORY = '.';
	protected static final char RESEVED_MEMORY = '#';
	public static final int MAIN_MEMORY_SIZE = 2400;
	protected int CURRENT_TIME = -1;

	public Memory(ProcessFactory processFactory) {
		main_memory = new char[ this.MAIN_MEMORY_SIZE ];
		processes = processFactory.getAllProcess();
		initializeMainMemory();
	}

	private void initializeMainMemory() {
		for (int i = 0; i < 100 && i < main_memory.length; i++) {
			main_memory[i] = RESERVED_MEMORY;
		}
		for (int i = 100; i < main_memory.length; i++) {
			main_memory[i] = FREE_MEMORY;
		}
	}
}