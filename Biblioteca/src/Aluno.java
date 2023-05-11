
/**
 * Classe especifica do Usuario que representa um aluno
 * @author tulio.henry
 */
public class Aluno extends Usuario {
    private String curso;
    private String periodo;

    /**
     * Contructor da class Aluno
     * @param nome Nome do aluno
     * @param matricula Matricula do aluno
     * @param curso Curso do aluno
     * @param periodo Periodo do curso
     */
    public Aluno(String nome, int matricula, String curso, String periodo) {
        super(nome, matricula);
        this.curso = curso;
        this.periodo = periodo;
    }
    
    /*
     * Funçao que calcula a multa a partir do numero dos dias
     */
    @Override
    public float calcularMulta(Emprestimo emprestimo) {
        return getTaxaMulta() * emprestimo.calcularDiasVencido();
    }

    /**
     * Retorna o curso do aluno
     * @return Curso do Aluno
     */
    public String getCurso() {
        return curso;
    }

    /**
     * Altera o curso do aluno pelo valor
     * @param curso Curso do aluno
     */
    public void setCurso(String curso) {
        this.curso = curso;
    }

    /**
     * Retorna o periodo do curso do aluno
     * @return Periodo do curso
     */
    public String getPeriodo() {
        return periodo;
    }

    /**
     * Altera o periodo do curso do aluno
     * @param periodo Periodo do curso
     */
    public void setPeriodo(String periodo) {
        this.periodo = periodo;
    }
    
    
    
}
