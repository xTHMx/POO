
/**
 *
 * @author tulio.henry
 */
public class Revista extends Item{
    private int volume;
    private int numero;

    public Revista( String titulo, String autor, int anoPublicacao, int quantDisponivel, int quantEmprestada
                    ,int volume, int numero) {
        super(titulo, autor, anoPublicacao, quantDisponivel, quantEmprestada);
        this.volume = volume;
        this.numero = numero;
    }

    @Override
    public void getDados(){
        System.out.println("\n==== Dados da Revista ====");
        super.getDados();
        System.out.println("Volume: " + volume +
                            "\nNumero: " + numero);

    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }
    
    
}
