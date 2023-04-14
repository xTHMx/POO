
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Banco {
    private String nome;
    private int numero; 
    private String cnpj;
    private String endereco;
    private Conta contaLogada = null;;
    private ArrayList<Agencia> agencias = new ArrayList<Agencia>();

    /**
     * Inicializa as instancias de Agencias e Contas
     * @param fileAgencia path do arquivo contendo as agencias
     * @param fileConta path do arquivo contendo as contas
     * @throws FileNotFoundException
     */
    public void initAgencia( File fileAgencia, File fileConta) throws FileNotFoundException{
        Scanner scanAgencia = new Scanner(fileAgencia);
        String[] campos;
        String lin;
        Agencia temp;
        
        while(scanAgencia.hasNextLine()){
            lin = scanAgencia.nextLine();
            campos = lin.split("#");

            temp = new Agencia(campos[0], Integer.parseInt(campos[1]), campos[2]);
            temp.initContas(fileConta);

            agencias.add(temp);
            
        }

        scanAgencia.close();
    }

    /**
     * Busca a agencia á partir do seu codigo
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
     * Loga o cliente no banco
     * @param numAgencia Numero da Agencia da conta
     * @param numConta Numero da Conta
     * @param senha Senha da conta
     */
    public boolean logarCliente(int numAgencia, int numConta, String senha){
        Agencia temp = buscarAgencia(numAgencia);
        Conta temp2;

        if(temp != null){
            temp2 = temp.buscarConta(numConta, senha);

            if(temp2 == null){
                System.out.println("Conta não encontrada");
                return false;
            }else{
                contaLogada = temp2;
                System.out.println("\nBem vindo, " + temp2.getNome());
                return true;
            }
        }else{
            System.out.println("Agencia não encontrada");
            return false;
        }
    }

    /**
     * Realiza o saque na conta logada
     * @param valor Valor a sacar
     */
    public void realizarSaque(double valor){
        Extrato ex;
        
        ex = new Extrato(contaLogada, -valor, "Saque");
        contaLogada.sacar(valor);
        contaLogada.addExtrato(ex);
    }

    /**
     * Deposita o valor na conta logada
     * @param valor Valor a depositar
     */
    public void realizarDeposito(double valor){
        Extrato ex; 

        ex = new Extrato(contaLogada, valor, "Deposito");
        contaLogada.depositar(valor);
        contaLogada.addExtrato(ex);
    }

    /**
     * Retorna o saldo da conta logada
     * @return Saldo da conta Atual
     */
    public double saldo(){
        return contaLogada.getSaldo();
    }

    /**
     * Cadastra uma agencia
     * @param codigo Codigo da nova agencia
     * @param nome Nome da nova agencia
     * @param endereco Endereço da nova agencia
     */
    public void cadastrarAgencia(int codigo, String nome, String endereco){
        Agencia novo = new Agencia(nome,codigo,endereco);
        agencias.add(novo);
    }

    /**
     * Cadastra uma agencia a partir da instancia
     * @param agencia Instancia da agencia a ser cadastrada
     */
    public void cadastrarAgencia(Agencia agencia){
        agencias.add(agencia);
    }

    /**
     * Cadastra uma nova conta
     * @param nome Nome da nova conta
     * @param dataNascimento Data de Nascimento da nova conta
     * @param endereco Endereço da nova conta
     * @param CPF CPF da nova conta
     * @param saldo Saldo da nova conta
     * @param senha Senha da nova conta
     * @param numConta Numero da nova conta
     * @param agencia Agencia da nova conta
     */
    public void cadastrarConta(String nome, String dataNascimento, String endereco, String CPF, double saldo, int agencia, int numConta, String senha){
        Conta novo = new Conta(nome,dataNascimento,endereco,CPF,saldo,agencia,numConta,senha);
        Agencia ag = buscarAgencia(agencia);
        ag.CadastrarConta(novo);
        
    }

    /**
     * Realiza uma transferencia de conta logada á outra
     * @param agencia Agencia da conta que receberá o valor
     * @param numConta Numero da conta que receberá o valor
     * @param valor Valor a ser transferido
     */
    public void transferencia(Agencia agencia, int numConta, double valor){
        Conta c;
        Extrato ex;

        c = agencia.buscarConta(numConta);

        if(c != null && c.getNumeroConta() == numConta){
            c.depositar(valor);
            contaLogada.sacar(valor);
            ex = new Extrato(c, contaLogada, -valor, "Transferencia");
            contaLogada.addExtrato(ex);
            c.addExtrato(ex);

        }else{
            System.out.println("Conta não encontrada!");
        }

    }

    /**
     * Realiza um pix usando CPF como chave
     * @param CPF Chave Cpf do pix
     * @param valor Valor a ser transferido
     */
    public void PIX(String CPF, double valor){
        int i;
        Agencia ag;
        Conta c;
        Extrato ex;

        for(i = 0; i < agencias.size(); i++){
            ag = agencias.get(i);

            c = ag.buscarConta(CPF);

            if(c != null && c.getCPF().equals(CPF)){
                contaLogada.sacar(valor);
                c.depositar(valor);

                ex = new Extrato(c, contaLogada, -valor, "Pix");
                c.addExtrato(ex);
                contaLogada.addExtrato(ex);
                c.addExtrato(ex);

                //System.out.println("CPF");
            }else{
                System.out.println("Conta não encontrada!");
            }

        }
    }

    /**
     * Printa os extratos das contas
     */
    public void printExtrato(){
        contaLogada.printExtatos();
    }

    /**
     * Desloga do Banco
     */
    public void deslogar(){
        contaLogada = null;
    }

    /**
     * Retorna o nome do banco
     * @return Nome do banco
     */
    public String getNome() {
        return nome;
    }
    
    /**
     * Define o nome do banco
     * @param nome Novo nome a ser trocado
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o endereco do banco
     * @return Endereço do banco
     */
    public String getEndereco() {
        return endereco;
    }

    /**
     * Define o endereco do banco
     * @param endereco Novo endereço a ser trocado
     */
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    /**
     * Retorna o numero do banco
     * @return Numero do banco
     */
    public int getNumero() {
        return numero;
    }
    
    /**
     * Define o numer do banco
     * @param numero Novo valor do numero do banco
     */
    public void setNumero(int numero){
        this.numero = numero;
    }

    /**
     * Retorna o Cnpj do banco
     * @return Cnpj do banco
     */
    public String getCnpj() {
        return cnpj;
    }
    
    /**
     * Define o Cnpj do banco
     * @param cnpj Novo valor de cnpj
     */
    public void setCnpj(String cnpj){
        this.cnpj = cnpj;
    }
}