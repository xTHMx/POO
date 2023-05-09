
/**
 *
 * @author tulio.henry
 */
public class Professor extends Usuario{
    private String departamento;
    private String titulacao;

    public Professor( String nome, int matricula, String departamento, String titulacao) {
        super(nome, matricula);
        this.departamento = departamento;
        this.titulacao = titulacao;
    }

    @Override
    public float calcularMulta(Emprestimo emprestimo) {
        return getTaxaMulta() * emprestimo.calcularDiasVencido();
    }
    
    @Override
    public float getTaxaMulta(){
        return super.getTaxaMulta() * 1.25f;
    }
    
    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getTitulacao() {
        return titulacao;
    }

    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }
    
    
    
}
