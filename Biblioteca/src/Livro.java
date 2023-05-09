
/**
 *
 * @author tulio.henry
 */
public class Livro extends Item{
    private String editora;
    private String isbn;

    public Livro( String titulo, String autor, int anoPublicacao, int quantDisponivel, 
                int quantEmprestada,String editora, String isbn) {
        super(titulo, autor, anoPublicacao, quantDisponivel, quantEmprestada);
        this.editora = editora;
        this.isbn = isbn;
    }

    public String getEditora() {
        return editora;
    }

    public void setEditora(String editora) {
        this.editora = editora;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
}
