
import java.util.Date;

/**
 *Classe que armazena os dados dos emprestimos realizados
 *Serao salvos dentro da instancia do usuario
 * @author tulio.henry
 */
public class Emprestimo {
    private Item item;
    private Date dataEmprestimo;
    private Date dataDevolucao;
    private Date dataDevolucaoPrevista;

    /**
     * Contructor da classe Emprestimo, ja inicializando as variaveis iniciais
     * @param item Objeto do item que sera registrado
     * @param dataEmprestimo Data em que o item foi emprestado
     * @param dataDevolucaoPrevista Data que deve ser devolvido
     */
    public Emprestimo(Item item, String dataEmprestimo, String dataDevolucaoPrevista) {
        String[] dtEmprestimo = dataEmprestimo.split("/");
        String[] dtPrevista = dataDevolucaoPrevista.split("/");
        
        this.item = item;
        this.dataEmprestimo = new Date(Integer.parseInt(dtEmprestimo[2]),
                    Integer.parseInt(dtEmprestimo[1]), Integer.parseInt(dtEmprestimo[0]));
        this.dataDevolucaoPrevista = new Date(Integer.parseInt(dtPrevista[2]),
                    Integer.parseInt(dtPrevista[1]), Integer.parseInt(dtPrevista[0]));
    }
    
    /**
     * Retorna o numero de dias que se passaram da data de devoluçao prevista
     * @return  Numero de dias pós-vencimento
     */
    public int calcularDiasVencido(){
        long diff = dataDevolucao.getTime() - dataDevolucaoPrevista.getTime();
        if(diff > 0)
            return (int)(diff/ (1000*60*60*24));
        return 0;
    }
    
    /**
     * Retorna o Item registrado no emprestimo
     * @return Item do emprestimo
     */
    public Item getItem(){
        return item;
    }

    /**
     * Define a data de devoluçao do emprestimo, ja que nao é inicializada no costructor
     * e deve ser verificada somente na devoluçao
     * @param data Data da devoluçao
     */
    public void setDataDevolucao(String data){
        String[] dtDevolucao = data.split("/");

        this.dataDevolucao = new Date(Integer.parseInt(dtDevolucao[2]),
            Integer.parseInt(dtDevolucao[1]), Integer.parseInt(dtDevolucao[0]));
    }
    
}
