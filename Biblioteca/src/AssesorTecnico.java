
/**
 * Classe especifica do Usuario que representa um assessor
 * @author tulio.henry
 */
public class AssesorTecnico extends Usuario {
    private String secao;

    /**
     * Constuctor da classe Assessor Tecnico
     * @param nome Nome do assessor
     * @param matricula Matricula do assessor
     * @param secao seçao do assessor
     */
    public AssesorTecnico( String nome, int matricula, String secao) {
        super(nome, matricula);
        this.secao = secao;
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
        return super.getTaxaMulta() * 1.15f;
    }

    /**
     * Retorna a seçao do assessor
     * @return Seçao do Assessor
     */
    public String getSecao() {
        return secao;
    }

    /**
     * Altera a seçao do assessor
     * @param secao Seçao do Assessor
     */
    public void setSecao(String secao) {
        this.secao = secao;
    }
    
    
}
