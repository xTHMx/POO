
/**
 *
 * @author tulio.henry
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Agencia {

    private String nome;
    private String endereco;
    private int numeroAgencia;
    private ArrayList<Conta> contas = new ArrayList<Conta>();

    /**
     * Funçao que cria e adiciona as contas ao ArrayList
     * @throws FileNotFoundException
     */
    public void initContas(File fileConta) throws FileNotFoundException{
        Scanner scanConta = new Scanner(fileConta);
        String[] campos;
        String lin;
        
        while(scanConta.hasNextLine()){
            lin = scanConta.nextLine();
            campos = lin.split("#");
            
            if(Integer.parseInt(campos[5]) == numeroAgencia){ //verifica se aquela conta pertence a essa agencia
                contas.add(new Conta(campos[0],campos[1],campos[2],campos[3],Double.parseDouble(campos[4]),
                                        Integer.parseInt(campos[5]),Integer.parseInt(campos[6]),campos[7]));
            }
            
        }

        scanConta.close();
    }

    /**
     * Cria um objeto Agencia
     * @param nome Nome da agencia
     * @param numAgencia Numero da Agencia
     * @param endereco Endereco da Agencia
     */
    public Agencia(String nome, int numAgencia, String endereco){
        this.nome = nome;
        this.numeroAgencia = numAgencia;
        this.endereco = endereco;
    }


    /**
     * Cadastra uma conta
     * @param conta Conta a ser cadastrada
     */
    public void CadastrarConta(Conta conta){
        contas.add(conta);
    };

    /**
     * Busca uma conta a partir de seu numero e senha
     * @param numConta Conta a ser procurada
     * @param senha Senha da conta para verificaçao
     * @return Instacia da conta
     */
    public Conta buscarConta(int numConta, String senha){
        int i;
        Conta temp;
        for(i = 0; i < contas.size(); i++){
            temp = contas.get(i);
            if(temp.getNumeroConta() == numConta){
                if(temp.getSenha().equals(senha)){ //por algum motivo usar (str' == str) nao funciona
                    return temp;
                }
            }
        }
        return null;
    }

    /**
     * Busca conta a partir do numero
     * @param numConta Numero da Conta
     * @return Instancia da conta
     */
    public Conta buscarConta(int numConta){
        int i;
        Conta temp;
        for(i = 0; i < contas.size(); i++){
            temp = contas.get(i);
            if(temp.getNumeroConta() == numConta){
                return temp;

            }
        }
        return null;
    }

    /**
     * Busca Conta por CPF
     * @param cpf Cpf da conta
     * @return Instacia da conta
     */
    public Conta buscarConta(String cpf){
        int i;
        Conta temp;
        
        for(i = 0; i < contas.size(); i++){
            temp = contas.get(i);
            if(temp.getCPF().equals(cpf)){
                return temp;
            }
        }
        return null;
    }

    /**
     * Retorna o tamanho da lista da conta
     * @return Tamnho da lista
     */
    public int getContasListSize(){
        return contas.size();
    }


    /**
     * Retorna o nome da Agencia
     * @return retorna o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome da Agencia
     * @param nome Nome da instancia
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o numero da Agencia
     * @return Numero da Agencia
     */
    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    /**
     * Define o numero da Agencia
     * @param numeroAgencia Novo numero da agencia
     */
    public void setNumeroAgencia(int numeroAgencia){
        this.numeroAgencia = numeroAgencia;
    }

    /**
     * Retorna o endereco da Agencia
     * @return Endereco da Agencia
     */
    public String getEndereco(){
        return endereco;
    }

    /**
     * Define o endereco da Agencia
     * @param endereco Endereço da Agencia
     */
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}