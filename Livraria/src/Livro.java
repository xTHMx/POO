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
        int i;
        Capitulo cap;

        System.out.println("Titulo: "+ titulo +
                            "\nEditor: "+ editor + " Ediçao: " + edicao +
                            "\nPreço: R$"+ preco +
                            "\n================================");        
        
        for(i = 0; i < capitulos.size(); i++){
            cap = capitulos.get(i);
            System.out.println("Capitulo:" +  cap.getTitulo() +
                                "\nN° de Paginas: " + cap.getNumPaginas() + " Autor: "+ cap.getSobrenome()+
                                "\n---------------------------");
        }
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
