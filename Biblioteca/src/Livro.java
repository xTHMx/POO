
/**
 *Classe de item que representa os Livros
 * @author tulio.henry
 */
public class Livro extends Item{
    private String editora;
    private String isbn;

    /**
     * Constructor da Classe Livro
     * @param titulo Titulo do Livro
     * @param autor Autor do Livro
     * @param anoPublicacao Ano da publicaçao do Livro
     * @param quantDisponivel Quantidade disponivel do Livro
     * @param quantEmprestada Quantidade emprestada do Livro
     * @param editora Editora do Livro
     * @param isbn Isbn do Livro
     */
    public Livro( String titulo, String autor, int anoPublicacao, int quantDisponivel, 
                int quantEmprestada,String editora, String isbn) {
        super(titulo, autor, anoPublicacao, quantDisponivel, quantEmprestada);
        this.editora = editora;
        this.isbn = isbn;
    }

    /**
     * Printa os dados especificos do CD para exibir ao usuario
     */
    @Override
    public void getDados(){
        System.out.println("\n==== Dados do Livro ====");
        super.getDados();
        System.out.println("Editora: " + editora +
                            "\nIsbn: " + isbn);

    }

    /**
     * Retorna a Editora do livro
     * @return Editora do livro
     */
    public String getEditora() {
        return editora;
    }

    /**
     * Altera a Editora do livro
     * @param editora Editora do livro
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * Retorna o Ibns
     * @return Ibns do Livro
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Altera o Ibns
     * @param isbn Ibns do Livro
     */
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    
    
}
