

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

    public void addEmprestimo(Item item, String dataEmprestimo, String dataDevolucaoPrevista){
        emprestimos.add(new Emprestimo(item, dataEmprestimo, dataDevolucaoPrevista));
    }
    
    public Emprestimo buscarEmprestimo(String nome){
        int i = 0;

        while(i < emprestimos.size()-1 && !nome.equals(emprestimos.get(i).getItem().getTitulo()))
            i++;
        
        if(nome.equals(emprestimos.get(i).getItem().getTitulo())){
            return emprestimos.get(i);
        }else{
           System.out.println("Não foi possivel encontrar emprestimo");
           return null;
        }
    }
    
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
