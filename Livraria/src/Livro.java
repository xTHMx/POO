import java.util.ArrayList;
import java.util.List;

public class Livro {
    private String editor;
    private String titulo;
    private int edicao;
    private double preco;
    private List<Capitulo> capitulos = new ArrayList<Capitulo>();

    /**
     * Cria objeto da classe livro
     * @param editor Editor
     * @param titulo Titulo
     * @param edicao Ediçao
     * @param preco Preço
     */
    public Livro(String editor, String titulo, int edicao, double preco){
        this.editor = editor;
        this.titulo = titulo;
        this.edicao = edicao;
        this.preco = preco;
    }

    public void addCapitulo(Capitulo cap){
        capitulos.add(cap);
    }

    public void printInfo(){

    }

    public String getEditor(){
        return editor;
    }

    public String getTitulo(){
        return titulo; 
    }

    public int getEdicao(){
        return edicao;
    }

    public double getPreco(){
        return preco;
    }


}
