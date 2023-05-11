
/**
 *
 * @author tulio.henry
 */
public class Main {

    public static void main(String[] args) {
        String itemPath = "Biblioteca/src/items.txt"; //caminhos dos arquivos
        String userPath = "Biblioteca/src/users.txt";

        Biblioteca biblioteca = new Biblioteca(itemPath,userPath); //biblioteca criada e ja com arquivos carregados

        biblioteca.display(); //processo padra com menu
    }
    
}
