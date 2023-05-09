

import java.util.Date;

/**
 *
 * @author tulio.henry
 */
public class Emprestimo {
    private Item item;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Date dataDevolucaoPrevista;

    public Emprestimo(Item item, String dataEmprestimo, String dataDevolucao, String dataDevolucaoPrevista) {
        String[] dtEmprestimo = dataEmprestimo.split("/");
        String[] dtDevolucao = dataDevolucao.split("/");
        String[] dtPrevista = dataDevolucaoPrevista.split("/");
        
        this.item = item;
        this.dataEmprestimo = new Date(Integer.parseInt(dtEmprestimo[2]),
                    Integer.parseInt(dtEmprestimo[1]), Integer.parseInt(dtEmprestimo[0]));
        this.dataDevolucao = new Date(Integer.parseInt(dtDevolucao[2]),
                    Integer.parseInt(dtDevolucao[1]), Integer.parseInt(dtDevolucao[0]));
        this.dataDevolucaoPrevista = new Date(Integer.parseInt(dtPrevista[2]),
                    Integer.parseInt(dtPrevista[1]), Integer.parseInt(dtPrevista[0]));
    }
    
    public int calcularDiasVencido(){
        long diff = dataDevolucao.getTime() - dataDevolucaoPrevista.getTime();
        if(diff > 0)
            return (int)(diff/ (1000*60*60*24));
        return 0;
    }
    
    
}
