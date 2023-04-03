
/**
 *
 * @author tulio.henry
 */
public class Conta {

    private String nome; 
    private String dataNascimento;
    private String endereco;
    private String CPF; 
    private double saldo;
    private String senha;
    private int numeroConta;
    private int agencia;

    public Conta(String nome, String dataNascimento, String endereco, String CPF, double saldo, int agencia, int numConta, String senha){
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.CPF = CPF;
        this.saldo = saldo;
        this.agencia = agencia;
        this.numeroConta = numConta;
        this.senha = senha;
    }

    /**
     * 
     * @return Endereço da conta
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * @param endereco Novo endereço a ser trocado
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * 
     * @return Retorna a Data do Nascimento 
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * 
     * @param dataNascimento Novo valor para trocar a data
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * 
     * @return Retorna a senha da conta
     */
    public String getSenha() {
        return senha;
    }

    /**
     * 
     * @param senha Nova senha a ser trocada
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
    /**
     * 
     * @return Retorna o nome da conta
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * 
     * @param nome Novo nome a ser trocado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * 
     * @return Retorna o valor do CPF da conta
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * 
     * @param CPF Novo valor a ser trocado
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * 
     * @return Retorna o saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * 
     * @param saldo Novo saldo a ser trocado
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * 
     * @return Retorna o n° da conta
     */
    public int getNumeroConta() {
        return numeroConta;
    }
    
    /**
     * 
     * @param numeroConta Novo valor do numero da conta
     */
    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }

    /**
     * 
     * @return Retorna a agencia da conta
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * 
     * @param agencia Nova agencia a ser trocada
     */
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    /**
     * 
     * @param valor Valor a ser inserido na conta
     */
    public void depositar (double valor){
        this.setSaldo(this.saldo + valor);
    }
    
    /**
     * 
     * @param value Valor a ser retirado da conta
     */
    public void sacar(double value){
        saldo -= value;
    }

    /**
     * 
     * @param senha Senha a ser validada
     * @return Verdadeiro se senhas são iguais
     */
    public boolean validarSenha(String senha){
        if(this.senha == senha) return true;
        return false;
    }
}