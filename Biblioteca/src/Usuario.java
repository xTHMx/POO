

import java.util.ArrayList;
import java.util.List;

/**
 *Classe Abstrata que representa todos os usuarios e armazena seus metodos e atributos gerais
 * @author tulio.henry
 */
public abstract class Usuario {
    private String nome;
    private int matricula;
    private float taxaMulta = 5.0f;
    private List<Emprestimo> emprestimos = new ArrayList<>();

    /**
     * Contructor do usuario, contem somente os atributos gerais
     * @param nome Nome do Usuario
     * @param matricula Matricula do Usuario
     */
    public Usuario(String nome, int matricula) {
        this.nome = nome;
        this.matricula = matricula;
    }
    
    /**
     * Metodo Abstrato que ira calcular a multa e retorna-la
     * @param emprestimo Emprestimo que sera calculado a multa
     * @return  Valor da multa
     */
    public abstract float calcularMulta(Emprestimo emprestimo);

    /**
     * Basicamente adiciona um novo emprestimo a lista do usuario
     * @param item Item do Emprestimo
     * @param dataEmprestimo Data do Emprestimo
     * @param dataDevolucaoPrevista Data de Devoluçao do Emprestimo
     */
    public void addEmprestimo(Item item, String dataEmprestimo, String dataDevolucaoPrevista){
        emprestimos.add(new Emprestimo(item, dataEmprestimo, dataDevolucaoPrevista));
    }
    
    /**
     * Busca um certo emprestimo por nome na lista do mesmo no objeto usuario
     * @param titulo Titulo do Item
     * @return Retorna a Instancia do emprestimo
     */
    public Emprestimo buscarEmprestimo(String titulo){
        int i = 0;

        while(i < emprestimos.size()-1 && !titulo.equals(emprestimos.get(i).getItem().getTitulo()))
            i++;
        
        if(titulo.equals(emprestimos.get(i).getItem().getTitulo())){
            return emprestimos.get(i);
        }else{
           System.out.println("Não foi possivel encontrar emprestimo");
           return null;
        }
    }

    /**
     * Printa na tela todos os titulos que possui emprestado
     */
    public void printEmprestimos(){
        int i = 0;

        System.out.println("Emprestimos:");
        if(emprestimos.size() > 0){
            while(i < emprestimos.size()){
                System.out.println("Nome: " + emprestimos.get(i).getItem().getTitulo());
                i++;
            }

        }else{
            System.out.println("Não existem emprestimos realizados");
        }
            
    }
    
    /**
     * Retorna o nome do usuario
     * @return Nome do usuario
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do usuario
     * @param nome Nome do usuario
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o valor da matricula do usuario
     * @return Matricula do Usuario
     */
    public int getMatricula() {
        return matricula;
    }

    /**
     * Define o valor da matricula do usuario
     * @param matricula Matricula do Usuario
     */
    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    /* 
    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public void setEmprestimos(List<Emprestimo> emprestimos) {
        this.emprestimos = emprestimos;
    }
    */

    /**
     * Retorna a taxa da multa
     * @return Taxa da multa
     */
    public float getTaxaMulta() {
        return taxaMulta;
    }

    
}
