
/**
 *
 * @author tulio.henry
 */
import java.util.ArrayList;

public class Agencia {

    private String nome;
    private String endereco;
    private int numeroAgencia;
    public ArrayList<Conta> contas = new ArrayList<Conta>();


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