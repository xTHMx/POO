import java.io.FileReader;

/**
 *
 * @author tulio.henry
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        String itemPath = "Biblioteca/src/items.txt";
        String userPath = "Biblioteca/src/users.txt";

        Biblioteca biblioteca = new Biblioteca(itemPath,userPath);
    }
    
}
