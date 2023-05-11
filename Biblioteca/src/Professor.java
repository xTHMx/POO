
/**
 *Classe especifica do Usuario que representa um professor
 * @author tulio.henry
 */
public class Professor extends Usuario{
    private String departamento;
    private String titulacao;

    /**
     * Constuctor da classe Professor
     * @param nome Nome do professor
     * @param matricula Matricula do professor
     * @param departamento Departamento do professor
     * @param titulacao Titulaçao do Professor
     */
    public Professor( String nome, int matricula, String departamento, String titulacao) {
        super(nome, matricula);
        this.departamento = departamento;
        this.titulacao = titulacao;
    }

    /*
     * Funçao que calcula a multa a partir do numero dos dias
     */
    @Override
    public float calcularMulta(Emprestimo emprestimo) {
        return getTaxaMulta() * emprestimo.calcularDiasVencido();
    }
    
    /*
     * Multa deve possuir um valor diferente para o assessor
     */
    @Override
    public float getTaxaMulta(){
        return super.getTaxaMulta() * 1.25f;
    }
    

    /**
     * Retorna o Departamento do professor
     * @return Departamento do professor
     */
    public String getDepartamento() {
        return departamento;
    }

    /**
     * Altera o Departamento do professor
     * @param departamento Departamento do professor
     */
    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    /**
     * Retorna a Titulaçao do professor
     * @return Titulaçao do professor
     */
    public String getTitulacao() {
        return titulacao;
    }

    /**
     * Altera a Titulaçao do professor
     * @param titulacao Titulaçao do professor
     */
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    
    
}
