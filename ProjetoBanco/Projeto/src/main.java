import java.io.File;

public class Main {

    public static void main(String[] args) throws Exception {
        DisplayBanco displayBanco = new DisplayBanco();

        File fileBanco = new File("ProjetoBanco/Projeto/src/banco.txt");
        File fileAgencia = new File("ProjetoBanco/Projeto/src/agencia.txt");
        File fileConta = new File("ProjetoBanco/Projeto/src/conta.txt");

        //processo principal
        displayBanco.init(fileBanco, fileAgencia, fileConta);
        displayBanco.login();

        //obs: talvez seja necessario utilizar "," como separador decimal, ou talvez "."
    }
}