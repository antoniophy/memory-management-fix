package simuladormemoriafixasswap;

public class Processo {
    
    //Recebe o valor do ID do processo - Parecido com o PID.
    private int codigo;
    
    //Recebe o valor do tamanho do processo.
    private int tamanhoProcesso;
    
    //Recebe o tempo em segundos do processo.
    private int tempoExecucao;
    
    //Recebe o numero de páginas que o processo possui.
    private int numeroPaginaProcesso;
    
    //Recebe a quantidade de endereços (Logicos) que o processo possui.
    private int quantidadeEnderecosLogicos;
    
    //Recebe true(verdadeiro) quando o processo estiver finalizado (Tempo de Execução = 0)
    private boolean processoFinalizado;
    
    //Construtor da classe processo
    public Processo(int _codigoID, int _tamanhoProcesso, int _tempoExecucao, int _numerosPagina){
        this.codigo = _codigoID;
        this.processoFinalizado = false;
        this.tamanhoProcesso = _tamanhoProcesso;
        this.tempoExecucao = _tempoExecucao;
        this.numeroPaginaProcesso = _numerosPagina;
    }
    
    //Get código
    public int getCodigo()
    {
        return this.codigo;
    }
	
	//Set código
	public void setCodigo(int _codigo)
	{
		this.codigo = _codigo;
	}
	
	//Get tamanho do processo
    public int getTamanhoProcesso()
    {
        return this.tamanhoProcesso;
    }
	
	//Set tamanho do processo
	public void  setTamanhoProcesso(int _tamanhoProcesso)
	{
		this.tamanhoProcesso = _tamanhoProcesso;
	}
	
    //Get tempo de execução
    public int getTempoExecucao()
    {
        return this.tempoExecucao;
    }
	
	//Set tempo Execucao
	public void  setTempoExecucao(int _tempoExecucao)
	{
		this.tempoExecucao = _tempoExecucao;
	}
	
	 //Get numero de Paginas do Processo
	 public int getNumeroPaginaProcesso()
	 {
	 	return this.numeroPaginaProcesso;
	 }
	 
	 //Set numero de Paginas do Processo
	 public void setNumeroPaginaProcesso(int _numeroPaginaProcesso)
	 {
	 	this.numeroPaginaProcesso = _numeroPaginaProcesso;
	 }
	 
	 //Get Quantidade de Endereços Logicos 
	 public int getQuantidadeEnderecosLogicos()
	 {
	 	return this.quantidadeEnderecosLogicos;
	 }
	 
	 //Set Quantidade de Endereços Logicos 
	 public void setQuantidadeEnderecosLogicos(int _quantidadeEnderecosLogicos)
	 {
	 	this.quantidadeEnderecosLogicos = _quantidadeEnderecosLogicos;
	 }
	
	//Get Processo Finalizado 
	public boolean getProcessoFinalizado()
	{
		return this.processoFinalizado;
	}
	
    //Setando o valor true(verdadeiro) ao processo chegar ao tempo 0
    public void setProcessoFinalizado(boolean _processoFinalizado){
        this.processoFinalizado = _processoFinalizado;
    }
}
