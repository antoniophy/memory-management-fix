package simuladormemoriafixasswap.Process;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class ProcessFactoryTest {

    ProcessFactory processFactory;

    @Before
    public void init(){
        processFactory = new ProcessFactory();
    }

    @Test
    public void ShouldReturn200WhenProcessosCreated(){
        processFactory.doCreate();

        assertEquals(200, processFactory.getProcessosCreatedSize());
    }

    @Test
    public void ShouldReturnAProcesso(){
        processFactory.doCreate();

        assertNotNull(processFactory.getProcess(200));
    }
}