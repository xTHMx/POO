

/**
 * Classe Abstrata dos items, possui seus atributos generalizados
 * @author tulio.henry
 */
public abstract class Item implements Emprestavel{
    private String titulo;
    private String autor;
    private int anoPublicacao;
    private int quantDisponivel;
    private int quantEmprestada;

    /**
     * Constructor da classe Item
     * @param titulo Titulo do Item
     * @param autor Autor do Item
     * @param anoPublicacao Ano da publicaçao do Item
     * @param quantDisponivel Quantidade disponivel do Item
     * @param quantEmprestada Quantidade emprestada do Item
     */
    public Item(String titulo, String autor, int anoPublicacao, int quantDisponivel, int quantEmprestada) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.quantDisponivel = quantDisponivel;
        this.quantEmprestada = quantEmprestada;
    }

    /**
     * Printa os dados genericos do Item, deve ser usado pelas classes filhas sobrescrevendo.
     * Ira exibir tanto os atributos gerais quanto os especificos quando utilizado pelos filhos
     */
    public void getDados(){
        System.out.println("Titulo: " + getTitulo() +
                            "\nAutor: " + getAutor() +
                            "\nAno: " + getAnoPublicacao() +
                            "\nQuantidade Disponivel: " + getQuantDisponivel() +
                            "\nQuantidade Emprestada: " + getQuantEmprestada());
    }
    

    /**
     * Retorna o Titulo do Item
     * @return Titulo do Item
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * Altera o Titulo do Item
     * @param titulo Titulo do Item
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * Retorna o Autor do Item
     * @return Autor do Item
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Altera o Autor do Item
     * @param autor Autor do Item
     */
    public void setAutor(String autor) {
        this.autor = autor;
    }

    /**
     * Retorna o Ano de Publicacão do Item
     * @return Ano de Publicacão do Item
     */
    public int getAnoPublicacao() {
        return anoPublicacao;
    }
    
    /**
     * Altera o Ano de Publicacão
     * @param anoPublicacao Ano de Publicacão
     */
    public void setAnoPublicacao(int anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    /**
     * Retorna o numero de Quantidades Disponiveis
     * @return Quantidades Disponiveis
     */
    public int getQuantDisponivel() {
        return quantDisponivel;
    }

    /**
     * Altera o numero de Quantidades Disponiveis
     * @param quantDisponivel Quantidades Disponiveis
     */
    public void setQuantDisponivel(int quantDisponivel) {
        this.quantDisponivel = quantDisponivel;
    }

    /**
     * Retorna o numero de Quantidades Emprestadas
     * @return Altera o numero de Quantidades Emprestadas
     */
    public int getQuantEmprestada() {
        return quantEmprestada;
    }

    /**
     * Altera o numero de Quantidades Emprestadas
     * @param quantEmprestada Quantidades Emprestadas
     */
    public void setQuantEmprestada(int quantEmprestada) {
        this.quantEmprestada = quantEmprestada;
    }

    /*
     * Ira fazer calculo dos novos valores apos emprestimo
     */
    @Override
    public void emprestimo() {
        quantDisponivel--;
        quantEmprestada++;
    }

    /*
     * Ira fazer calculo dos novos valores apos devolucao
     */
    @Override
    public void devolucao() {
        quantDisponivel++;
        quantEmprestada--;
    }
    
    
    
}
