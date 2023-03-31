import java.util.ArrayList;

public class Banco {
    private String nome;
    private int numero; 
    private String cnpj;
    private String endereco;
    private Conta contaLogada = null;;
    private ArrayList<Agencia> agencias = new ArrayList<Agencia>();

    /**
     * 
     * @param codigo Numero para buscar a agencia
     * @return  Retorna a agencia
     */
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

    /**
     * 
     * @param numAgencia Numero da Agencia da conta
     * @param numConta Numero da Conta
     * @param senha Senha da conta
     */
    public void logarCliente(int numAgencia, int numConta, String senha){
        Agencia temp = buscarAgencia(numAgencia);
        Conta temp2;

        if(temp != null){
            temp2 = temp.buscarConta(numConta, senha);

            if(temp2 == null){
                System.out.println("Conta não encontrada");
            }else{
                contaLogada = temp2;
            }
        }else{
            System.out.println("Agencia não encontrada");
        }
    }

    /**
     * 
     * @param valor Valor a sacar
     */
    public void realizarSaque(double valor){
        contaLogada.sacar(valor);
    }

    /**
     * 
     * @param valor Valor a depositar
     */
    public void realizarDeposito(double valor){
        contaLogada.depositar(valor);
    }

    /**
     * 
     * @return Saldo da conta Atual
     */
    public double saldo(){
        return contaLogada.getSaldo();
    }

    /**
     * 
     * @param codigo Codigo da nova agencia
     * @param nome Nome da nova agencia
     * @param endereco Endereço da nova agencia
     */
    public void cadastrarAgencia(int codigo, String nome, String endereco){
        Agencia novo = new Agencia();
        novo.setNumeroAgencia(codigo);
        novo.setNome(nome);
        novo.setEndereco(endereco);
        agencias.add(novo);
    }

    /**
     * 
     * @param agencia Instancia da agencia a ser cadastrada
     */
    public void cadastrarAgencia(Agencia agencia){
        agencias.add(agencia);
    }

    /**
     * 
     * @param nome Nome da nova conta
     * @param dataNascimento Data de Nascimento da nova conta
     * @param endereco Endereço da nova conta
     * @param CPF CPF da nova conta
     * @param saldo Saldo da nova conta
     * @param senha Senha da nova conta
     * @param numeroConta Numero da nova conta
     * @param agencia Agencia da nova conta
     */
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

    /**
     * 
     * @param agencia Agencia da conta que receberá o valor
     * @param numConta Numero da conta que receberá o valor
     * @param valor Valor a ser transferido
     */
    public void transferencia(Agencia agencia, int numConta, double valor){
        Conta c;
        int i;

        for(i=0; i < agencia.contas.size(); i++){
            c = agencia.contas.get(i);
            if(c.getNumeroConta() == numConta){
                c.depositar(valor);
                contaLogada.sacar(valor);
            }
        }
    }

    /**
     * 
     * @param CPF Chave Cpf do pix
     * @param valor Valor a ser transferido
     */
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

    /**
     * Desloga do Banco
     */
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
     * @param numero Novo valor do numero do banco
     */
    public void setNumero(int numero){
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