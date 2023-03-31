import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayBanco {
    Banco myBank = new Banco();
    Scanner scan = new Scanner(System.in);

    public void initBanco() throws FileNotFoundException{
        File banco = new File("ProjetoBanco/Projeto/src/banco.txt");
        //System.out.println(banco.getAbsolutePath()); //debug
        Scanner scanBanco = new Scanner(banco);

        

        String lin = scanBanco.nextLine();
        String[] campos = lin.split("#");

        myBank.setNome(campos[0]);
        myBank.setNumero(Integer.parseInt(campos[1]));
        myBank.setCnpj(campos[2]);
        myBank.setEndereco(campos[3]);

        scanBanco.close();

        //System.out.println(myBank.getEndereco());

    }


    
    public void login(){
        int numeroConta, agenciaConta;
        String senhaConta;

        System.out.println("Digite a agencia da conta:");
        agenciaConta = scan.nextInt();
        System.out.println("Digite o numero da conta:");
        numeroConta = scan.nextInt();
        scan.nextLine();                    //consome o "nextline" do resultado anterior, senao ele pula o proximo nextline
        System.out.println("Digite a senha da conta:");
        senhaConta = scan.nextLine();

        myBank.logarCliente(agenciaConta, numeroConta, senhaConta);

    }
}
