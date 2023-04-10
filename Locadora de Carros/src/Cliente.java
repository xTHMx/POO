
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tulio.henry
 */
public class Cliente {
    private String nome;
    private String cpf;
    private List<Locacao> locacoes = new ArrayList<Locacao>();
    
    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public List<Locacao> getLocacoes() {
        return locacoes;
    }
    
    
}