

/**
 * Classe de item que representa os CDs
 * @author tulio.henry
 */
public class CD extends Item {
    private int volume;
    private String gravadora;

    /**
     * Constructor da classe CD
     * @param titulo Titulo do CD
     * @param autor Autor do CD
     * @param anoPublicacao Ano da publicaçao do CD
     * @param quantDisponivel Quantidade disponivel do CD
     * @param quantEmprestada Quantidade emprestada do CD
     * @param volume Volume do CD
     * @param gravadora Gravadora do CD
     */
    public CD( String titulo, String autor, int anoPublicacao, int quantDisponivel, 
                int quantEmprestada, int volume, String gravadora) {
        super(titulo, autor, anoPublicacao, quantDisponivel, quantEmprestada);
        this.volume = volume;
        this.gravadora = gravadora;
    }

    /**
     * Printa os dados especificos do CD para exibir ao usuario
     */
    @Override
    public void getDados(){
        System.out.println("\n==== Dados do CD ====");
        super.getDados();
        System.out.println("Volume: " + volume +
                            "\nGravadora: " + gravadora);

    }

    /**
     * Retorna o Volume do CD
     * @return Volume do CD
     */
    public int getVolume() {
        return volume;
    }

    /**
     * Altera o Volume do CD
     * @param volume Volume do CD
     */
    public void setVolume(int volume) {
        this.volume = volume;
    }

    /**
     * Retorna a Gravadora do CD
     * @return Gravadora do CD
     */
    public String getGravadora() {
        return gravadora;
    }

    /**
     * Altera a Gravadora do CD
     * @param gravadora Gravadora do CD
     */
    public void setGravadora(String gravadora) {
        this.gravadora = gravadora;
    }
    
    
}
