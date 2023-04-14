import java.util.List;
import java.util.ArrayList;

/**
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
    private List<Extrato> extratos = new ArrayList<>();

    /**
     * Cria uma instancia da classe Conta
     * @param nome Nome da conta
     * @param dataNascimento Data de Nacimento do cliente da conta
     * @param endereco Endereço da conta
     * @param CPF CPF da conta
     * @param saldo Saldo da conta
     * @param agencia Agencia da conta
     * @param numConta Numero da conta
     * @param senha Senha da conta
     */
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
     * Retorna o endereço da conta
     * @return Endereço da conta
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereco da conta
     * @param endereco Novo endereço a ser trocado
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna a Data de Nascimento da conta
     * @return Data do Nascimento 
     */
    public String getDataNascimento() {
        return dataNascimento;
    }

    /**
     * Define a Data de Nascimento da conta
     * @param dataNascimento Data para trocar
     */
    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    /**
     * Retorna a Senha da conta
     * @return Senha da conta
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Define a senha da conta
     * @param senha Nova senha a ser trocada
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
    /**
     * Retorna o nome da conta
     * @return Nome da conta
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome da conta
     * @param nome Novo nome a ser trocado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor do CPF da conta
     * @return CPF da conta
     */
    public String getCPF() {
        return CPF;
    }

    /**
     * Define o CPF da conta
     * @param CPF Novo valor a ser trocado
     */
    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    /**
     * Retorna o saldo da conta
     * @return Saldo da conta
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * Define o saldo da conta
     * @param saldo Novo saldo a ser trocado
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * Retorna o numero da conta
     * @return Numero da conta
     */
    public int getNumeroConta() {
        return numeroConta;
    }
    
    /**
     * Define o numero da conta
     * @param numeroConta Novo valor do numero da conta
     */
    public void setNumeroConta(int numeroConta){
        this.numeroConta = numeroConta;
    }

    /**
     * Retorna a agencia da conta
     * @return Agencia da conta
     */
    public int getAgencia() {
        return agencia;
    }

    /**
     * Define a agencia da conta
     * @param agencia Nova agencia a ser trocada
     */
    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    /**
     * Insere o valor definido na conta
     * @param valor Valor a ser inserido na conta
     */
    public void depositar (double valor){
        this.setSaldo(this.saldo + valor);
    }
    
    /**
     * Remove o valor definido da conta
     * @param value Valor a ser retirado da conta
     */
    public void sacar(double value){
        saldo -= value;
    }

    /**
     * Verifica se a senha é verdadeira
     * @param senha Senha a ser validada
     * @return Verdadeiro se senhas são iguais
     */
    public boolean validarSenha(String senha){
        if(this.senha == senha) return true;
        return false;
    }

    /**
     * Adiciona o extrato a conta
     * @param extrato Extrato da transferencia
     */
    public void addExtrato(Extrato extrato){
        extratos.add(extrato);
    }

    /**
     * Printa os extratos das transferencias
     */
    public void printExtatos(){
        int i;
        Extrato temp;

        for(i = 0; i < extratos.size(); i++){
            temp = extratos.get(i);
            temp.printExtrato();
        }
    }
}