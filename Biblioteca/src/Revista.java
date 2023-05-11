
/**
 * Classe de item que representa os Livros
 * @author tulio.henry
 */
public class Revista extends Item{
    private int volume;
    private int numero;

    /**
     * Constructor da Classe Revista
     * @param titulo Titulo da Revista
     * @param autor Autor da Revista
     * @param anoPublicacao Ano da publicaçao da Revista
     * @param quantDisponivel Quantidade disponivel da Revista
     * @param quantEmprestada Quantidade emprestada da Revista
     * @param volume Volume da Revista
     * @param numero Numero da Revista
     */
    public Revista( String titulo, String autor, int anoPublicacao, int quantDisponivel, int quantEmprestada
                    ,int volume, int numero) {
        super(titulo, autor, anoPublicacao, quantDisponivel, quantEmprestada);
        this.volume = volume;
        this.numero = numero;
    }

    /**
     * Printa os dados especificos do CD para exibir ao usuario
     */
    @Override
    public void getDados(){
        System.out.println("\n==== Dados da Revista ====");
        super.getDados();
        System.out.println("Volume: " + volume +
                            "\nNumero: " + numero);

    }

    /**
     * Retorna o Volume da Revista
     * @return Volume da Revista
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Altera o Volume da Revista
     * @param volume Volume da Revista
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Retorna o Numero da Revista
     * @return Numero da Revista
     */
    public int getNumero() {
        return numero;
    }

    /**
     * Altera o Numero da Revista
     * @param numero Numero da Revista
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
