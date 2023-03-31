import java.util.Scanner;

public class DisplayBanco {
    Banco myBank = new Banco();
    Scanner scan = new Scanner(System.in);

    public void login(){
        int numeroConta, agenciaConta;
        String senhaConta;

        System.out.println("Digite a agencia da conta:");
        agenciaConta = scan.nextInt();
        System.out.println("Digite o nome da conta:");
        numeroConta = scan.nextInt();
        System.out.println("Digite a senha da conta:");
        senhaConta = scan.nextLine();

        myBank.logarCliente(agenciaConta, numeroConta, senhaConta);

    }
}
