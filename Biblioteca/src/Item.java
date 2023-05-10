

/**
 *
 * @author tulio.henry
 */
public abstract class Item implements Emprestavel{
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantDisponivel;
    private int quantEmprestada;

    public Item(String titulo, String autor, int anoPublicacao, int quantDisponivel, int quantEmprestada) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantDisponivel = quantDisponivel;
        this.quantEmprestada = quantEmprestada;
    }

    public void getDados(){
        System.out.println("Titulo: " + getTitulo() +
                            "\nAutor: " + getAutor() +
                            "\nAno: " + getAnoPublicacao() +
                            "\nQuantidade Disponivel: " + getQuantDisponivel() +
                            "\nQuantidade Emprestada: " + getQuantEmprestada());
    }
    

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
    }

    public int getQuantEmprestada() {
        return quantEmprestada;
    }

    public void setQuantEmprestada(int quantEmprestada) {
        this.quantEmprestada = quantEmprestada;
    }

    @Override
    public void emprestimo() {
        quantDisponivel--;
        quantEmprestada++;
    }

    @Override
    public void devolucao() {
        quantDisponivel++;
        quantEmprestada--;
    }
    
    
    
}
