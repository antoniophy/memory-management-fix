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
    public Processo(int _codigoID, int _tamanhoProcesso, int _tempoExecução, int _numerosPagina){
        this.codigo = _codigoID;
        this.processoFinalizado = false;
        this.tamanhoProcesso = _tamanhoProcesso;
        this.tempoExecucao = _tempoExecução;
        this.numeroPaginaProcesso = _numerosPagina;
    }
    
    //Get código
    public int pegarID()
    {
        return this.codigo;
    }
    
    //Setando o valor true(verdadeiro) ao processo chegar ao tempo 0
    public synchronized void setFinalProcesso(boolean _processoFinalizado){
        this.processoFinalizado = _processoFinalizado;
    }
    
    
}
