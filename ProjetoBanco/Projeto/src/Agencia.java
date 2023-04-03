
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
    public ArrayList<Conta> contas = new ArrayList<Conta>();

    /**
     * Funçao que cria e adiciona as contas ao ArrayList
     * @throws FileNotFoundException
     */
    public void initContas() throws FileNotFoundException{
        File ag = new File("ProjetoBanco/Projeto/src/conta.txt");
        Scanner scanConta = new Scanner(ag);
        String[] campos;
        String lin;
        int i = 0;
        
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

    public Agencia(String nome, int numAgencia, String endereco){
        this.nome = nome;
        this.numeroAgencia = numAgencia;
        this.endereco = endereco;
    }


    /**
     * @param conta Conta a ser cadastrada
     */
    public void CadastrarConta(Conta conta){
        contas.add(conta);
    };

    /**
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
                if(temp.getSenha() == senha){
                    return temp;
                }
            }
        }
        return null;
    }


    /**
     * @return retorna o nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome Troca o nome da instancia
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return Devolve o numero da Agencia
     */
    public int getNumeroAgencia() {
        return numeroAgencia;
    }

    /**
     * 
     * @param numeroAgencia Novo numero da agencia
     */
    public void setNumeroAgencia(int numeroAgencia){
        this.numeroAgencia = numeroAgencia;
    }

    /**
     * @return Devolve o endereco da Agencia
     */
    public String getEndereco(){
        return endereco;
    }

    /**
     * 
     * @param endereco Endereço a ser alterado
     */
    public void setEndereco(String endereco){
        this.endereco = endereco;
    }

}