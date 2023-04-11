public class Capitulo {
    private String titulo;
    private int numPaginas;
    private String sobrenomeAutor;

    /**
     * Cria instancia da classe Capitulo
     * @param titulo  Titulo do capitulo
     * @param numPaginas Numero de Paginas
     * @param sobrenomeAutor Sobrenome do autor
     */
    public Capitulo(String titulo, int numPaginas, String sobrenomeAutor){
        this.numPaginas = numPaginas;
        this.titulo = titulo;
        this.sobrenomeAutor = sobrenomeAutor;
    }

    /**
     * Retorna o titulo do arquivo
     * @return Titulo
     */
    public String getTitulo(){
        return titulo;
    }

    /**
     * Retorna o numero de paginas do capitulo
     * @return numero de paginas
     */
     public int getNumPaginas(){
        return numPaginas;
     }

     /**
      * Devolve o sobrenome do autor
      * @return Sobrenome do Autor
      */
     public String getSobrenome(){
        return sobrenomeAutor;
     }
}
