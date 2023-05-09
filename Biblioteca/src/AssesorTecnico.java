
/**
 *
 * @author tulio.henry
 */
public class AssesorTecnico extends Usuario {
    private String secao;

    public AssesorTecnico( String nome, int matricula, String secao) {
        super(nome, matricula);
        this.secao = secao;
    }
    
    @Override
    public float calcularMulta(Emprestimo emprestimo) {
        return getTaxaMulta() * emprestimo.calcularDiasVencido();
    }
    
    @Override
    public float getTaxaMulta(){
        return super.getTaxaMulta() * 1.15f;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
    }
    
    
}
