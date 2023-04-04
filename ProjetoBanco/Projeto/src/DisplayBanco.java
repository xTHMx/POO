import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DisplayBanco {
    Banco myBank = new Banco();
    Scanner scan = new Scanner(System.in);

    /**
     * Inicializa o banco a partir de arquivos .txt
     * @param fileBanco path do arquivo contendo info do Banco
     * @param fileAgencia path do arquivo contendo info das Agencias
     * @param fileConta path do arquivo contendo info das Contas
     * @throws FileNotFoundException
     */
    public void init(File fileBanco, File fileAgencia, File fileConta) throws FileNotFoundException{
        //System.out.println(banco.getAbsolutePath()); //debug
        Scanner scanBanco = new Scanner(fileBanco);

        String lin = scanBanco.nextLine();
        String[] campos = lin.split("#");

        myBank.setNome(campos[0]);
        myBank.setNumero(Integer.parseInt(campos[1]));
        myBank.setCnpj(campos[2]);
        myBank.setEndereco(campos[3]);

        scanBanco.close();

        myBank.initAgencia(fileAgencia, fileConta);

        //System.out.println(myBank.getEndereco());

    }


    /**
     * Realiza o login do cliente
     */
    public void login(){
        int numeroConta, agenciaConta;
        String senhaConta;

        System.out.println("\nDigite a agencia da conta:");
        agenciaConta = scan.nextInt();
        System.out.println("Digite o numero da conta:");
        numeroConta = scan.nextInt();
        scan.nextLine();                    //consome o "nextline" do resultado anterior, senao ele pula o proximo nextline
        System.out.println("Digite a senha da conta:");
        senhaConta = scan.nextLine();

        if( myBank.logarCliente(agenciaConta, numeroConta, senhaConta)){
            telaUsuario();
        }else{
            System.out.println("Não foi possivel fazer login!\n");
        }
        

    }

    /**
     * Interface do banco onde o usuario irá interagir com sua conta
     */
    private void telaUsuario(){
        boolean sair = false;
        int opcao;

        while(sair != true){
            System.out.println("\nPor favor, selecione uma das opçoes abaixo: \n"+
                                    "1 - Consultar Saldo \n" +
                                    "2 - Depósito \n" +
                                    "3 - Saque \n" + 
                                    "4 - Transferencia \n" +
                                    "5 - PIX\n" +
                                    "6 - Sair\n");

            opcao = scan.nextInt();

            switch(opcao){
                case 1: operacaoSaldo(); break;
                case 2: operacaoDeposito(); break;
                case 3: operacaoSaque(); break;
                case 4: operacaoTransferencia(); break;
                case 5: operacaoPix(); break;
                case 6: sair = true; operacaoSair(); break;
                default:
                    System.out.println("Erro: Selecione uma opcao existente!");
                    break;
            }
        }
    }

    /**
     * Realiza a operaçao geral de deposito na conta
     */
    private void operacaoDeposito(){
        double val;

        System.out.println("Digite o valor a ser depositado:");
        val = scan.nextDouble();

        myBank.realizarDeposito(val);
        System.out.println("$"+val + " foram depositados!\n");

    }

    /**
     * Realiza a operaçao geral de saque da conta
     */
    private void operacaoSaque(){
        double val;

        System.out.println("Digite o valor a ser sacado:");
        val = scan.nextDouble();

        if(myBank.saldo() >= val){
            myBank.realizarSaque(val);
            System.out.println("$"+val + " foram sacados!");
        }else{
            System.out.println("Erro: Valor na conta insuficiente!\n");
        }
    }

    /**
     * Realiza a operaçao geral da transferencia por PIX
     */
    private void operacaoPix(){
        double val;
        String cpf;

        System.out.println("Digite o valor do CPF (chave) do PIX:");
        scan.nextLine();                                               //remove o \n de algum input anterior
        cpf = scan.nextLine();
        System.out.println("Digite o valor a ser trasferido por PIX:");
        val = scan.nextDouble();

        if(myBank.saldo() >= val){
            myBank.PIX(cpf, val);
            System.out.println("PIX enviado com sucesso!\n");
        }else{
            System.out.println("Erro: Valor na conta insuficiente!\n");
        }

    }

    /**
     * Realiza a operaçao geral da transferencia pela conta
     */
    private void operacaoTransferencia(){
        Agencia temp;
        int numConta;
        double val;

        System.out.println("Digite o numero da agencia da conta a transferir");
        temp = myBank.buscarAgencia(scan.nextInt());
        System.out.println("Digite o numero da conta a transferir");
        numConta = scan.nextInt();
        System.out.println("Digite o valor a transferir");
        val = scan.nextDouble();

        if(myBank.saldo() >= val){
            myBank.transferencia(temp, numConta, val);
            System.out.println("Transferencia realizada com sucesso!\n");
        }else{
            System.out.println("Erro: Valor na conta insuficiente!\n");
        }

    }

    /**
     * Exibe o saldo da conta logada
     */
    private void operacaoSaldo(){
        System.out.println("Seu saldo é de $"+myBank.saldo());
    }

    /**
     * Volta a tela de login do banco
     */
    private void operacaoSair(){
        myBank.deslogar();
        login();
    }
}
