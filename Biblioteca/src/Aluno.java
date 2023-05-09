
/**
 *
 * @author tulio.henry
 */
public class Aluno extends Usuario {
    private String curso;
    private String periodo;

    public Aluno(String nome, int matricula, String curso, String periodo) {
        super(nome, matricula);
        this.curso = curso;
        this.periodo = periodo;
    }
    
    @Override
    public float calcularMulta(Emprestimo emprestimo) {
        return getTaxaMulta() * emprestimo.calcularDiasVencido();
    }


    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    public String getPeriodo() {
        return periodo;
    }

    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
    
}
