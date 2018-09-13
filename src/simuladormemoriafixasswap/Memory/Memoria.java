package simuladormemoriafixasswap.Memory;

public class Memoria {

	final int tamanhoMemoria;
	final int tamanhoPagina;

	
	public Memoria(int _tamanhoMemoria, int _tamanhoPagina)
	{
		this.tamanhoMemoria = _tamanhoMemoria;
		this.tamanhoPagina = _tamanhoPagina;
	}
	
	public int getTamanhoPagina() {
        return tamanhoPagina;
    } 
}