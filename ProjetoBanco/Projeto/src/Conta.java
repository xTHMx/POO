
/**
 *
 * @author tulio.henry
 */
public class Conta {

    private String nome; 
    private String dataNascimento;
    private String endereco;
    private long CPF; 
    private double saldo;
    private String senha;
    private int numeroConta;
    private int agencia;

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }   
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getCPF() {
        return CPF;
    }

    public void setCPF(long CPF) {
        this.CPF = CPF;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        this.agencia = agencia;
    }
    
    public void deposito (double valor){
        this.setSaldo(this.saldo + valor);
    }
    
    public boolean isWithdrawPossible (double value){
        if ( value > saldo) return false;
        withdraw (value);
        return true;
    }
    
    public void withdraw (double value){
        saldo -= value;
    }
}