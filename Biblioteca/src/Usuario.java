

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author tulio.henry
 */
public abstract class Usuario {
    private String nome;
    private int matricula;
    private float taxaMulta = 5.0f;
    private List<Emprestimo> emprestimos = new ArrayList<>();

    public Usuario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    public abstract float calcularMulta(Emprestimo emprestimo);
    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }

    public float getTaxaMulta() {
        return taxaMulta;
    }

    
}
