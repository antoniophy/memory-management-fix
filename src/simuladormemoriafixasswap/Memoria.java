package simuladormemoriafixasswap;

import java.util.List;

public class Memoria {

	//Recebe o tamanho da memoria 
	final int tamanhoMemoria;
	final int tamanhoPagina;

	
	//final List<MemoriaRegistro> registros;
	//final List<MemoriaListener> listeners;

	//Construtor padrão, recebe como parametro Tamanho da Memoria e Tamanho da Página  
	public Memoria(int _tamanhoMemoria, int _tamanhoPagina)
	{
		this.tamanhoMemoria = _tamanhoMemoria;
		this.tamanhoPagina = _tamanhoPagina;
		 ///this.registros = new ArrayList<>();
	}
	
	//Get tamanho da Pagina
    public int getTamanhoPagina() {
        return tamanhoPagina;
    } 
}