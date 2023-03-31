import java.util.ArrayList;

public class Banco {
    private String nome;
    private int numero; 
    private String cnpj;
    private String endereco;
    private Conta contaLogada = null;;
    private ArrayList<Agencia> agencias = new ArrayList<Agencia>();

    public Agencia buscarAgencia(int codigo){
        int i;
        Agencia temp;
        for(i = 0; i < agencias.size(); i++){
            temp = agencias.get(i);
            if(temp.getNumeroAgencia() == codigo){
                return temp;
            }
        }
        return null; //nao encontrei
    }

    public void logarCliente(int numAgencia, int numConta, String senha){
        Agencia temp = buscarAgencia(numAgencia);
        Conta temp2 = temp.buscarConta(numConta, senha);
        if(temp2 == null){
            System.out.println("Conta não encontrada");
        }else{
            contaLogada = temp2;
        }
    }

    public void realizarSaque(double valor){
        contaLogada.sacar(valor);
    }

    public void realizarDeposito(double valor){
        contaLogada.depositar(valor);
    }

    public double saldo(){
        return contaLogada.getSaldo();
    }

    public void cadastrarAgencia(int codigo, String nome, String endereco){
        Agencia novo = new Agencia();
        novo.setNumeroAgencia(codigo);
        novo.setNome(nome);
        novo.setEndereco(endereco);
        agencias.add(novo);
    }

    public void cadastrarAgencia(Agencia ag){
        agencias.add(ag);
    }

    public void cadastrarConta(String nome, String dataNascimento,String endereco,String CPF, double saldo,String senha,int numeroConta,int agencia){
        Conta novo = new Conta();
        Agencia ag = buscarAgencia(agencia);
        novo.setNome(nome);
        novo.setDataNascimento(dataNascimento);
        novo.setEndereco(endereco);
        novo.setCPF(CPF);
        novo.setSaldo(saldo);
        novo.setSenha(senha);
        novo.setNumeroConta(numeroConta);
        novo.setAgencia(agencia);

        ag.CadastrarConta(novo);
        
    }

    public void transferencia(Agencia ag, int numConta, double valor){
        Conta c;
        int i;

        for(i=0; i < ag.contas.size(); i++){
            c = ag.contas.get(i);
            if(c.getNumeroConta() == numConta){
                c.depositar(valor);
                contaLogada.sacar(valor);
            }
        }
    }


    public void PIX(String CPF, double valor){
        int i, j;
        Agencia ag;
        Conta c;
        for(i = 0; i < agencias.size(); i++){
            ag = agencias.get(i);
            for(j=0; j < ag.contas.size(); j++ ){
                c = ag.contas.get(j);
                if(c.getCPF() == CPF){
                    contaLogada.sacar(valor);
                    c.depositar(valor);
                }
            }
        }
    }

    public void deslogar(){
        contaLogada = null;
    }

    /**
     * 
     * @return Retorna o nome do banco
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
     * @return Endereço do banco
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
     * @return Retorna o n° do banco
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * 
     * @param numeroConta Novo valor do numero do banco
     */
    public void setNumeroConta(int numero){
        this.numero = numero;
    }

    /**
     * 
     * @return Retorna o Cnpj do banco
     */
    public String getCnpj() {
        return cnpj;
    }
    
    /**
     * 
     * @param cnpj Novo valor de cnpj
     */
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
}