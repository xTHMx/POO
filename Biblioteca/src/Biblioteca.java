import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * @author tulio.henry
 */
public class Biblioteca {
    private List<Usuario> users = new ArrayList<>();
    private List<Item> itens = new ArrayList<>();
    private Scanner scan = new Scanner(System.in);
    private String userPath;
    private String itemPath;

    /**
     * Contructor da classe biblioteca, sendo ela que armazena os dados e operaçoes do programa
     * Ela ja deve ser criada com os caminhos dos dados para inicializaçao
     * @param itemPath Local do arquivo que armazena os dados dos items
     * @param userPath Local do arquivo que armazena os dados dos usuarios
     */
    public Biblioteca(String itemPath, String userPath){
        BufferedReader buffr;
        String line;
        String[] temp;

        this.userPath = userPath; //recebe os locais
        this.itemPath = itemPath;

        //items
        try{
            buffr = new BufferedReader(new FileReader(itemPath)); //cria o leitor
            
            while((line = buffr.readLine()) != null){ //recebe a linha durante loop
                temp = line.split("#"); //separa a linha

                switch(temp[0]){ //descobre o tipo do item
                    case "Livro": //cria com as strings e salva a instancia na lista
                        itens.add(new Livro(temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), 0, temp[5], temp[6]));
                        break;
                    case "Revista":
                        itens.add(new Revista(temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), 0, Integer.parseInt(temp[5]), Integer.parseInt(temp[6])));
                        break;
                    case "CD":
                        itens.add(new CD(temp[1], temp[2], Integer.parseInt(temp[3]), Integer.parseInt(temp[4]), 0, Integer.parseInt(temp[5]), temp[6]));
                        break;
                    default:
                        System.out.println("Não foi possivel adicionar item");
                        break;
                }

            }

            buffr.close(); //fecha arquivo

        }catch(FileNotFoundException e){
            System.out.println("Arquivo de itens não encotrado ->" + e.getMessage());
        }catch(IOException e){
            System.out.println("Erro ao ler arquivo ->" + e.getMessage());
        }

        //usuarios
        try{
            buffr = new BufferedReader(new FileReader(userPath)); //abre buffer de leitura
            
            while((line = buffr.readLine()) != null){ //recebe linha 
                temp = line.split("#"); //divide a linha em strings

                switch(temp[0]){ //descobre o tipo de Usuario
                    case "Aluno": //cria com as strings e salva a instancia na lista
                        users.add(new Aluno(temp[1],Integer.parseInt(temp[2]),temp[3],temp[4]));
                        break;
                    case "Professor":
                    users.add(new Professor(temp[1],Integer.parseInt(temp[2]),temp[3],temp[4]));
                        break;
                    case "Assessor":
                    users.add(new AssesorTecnico(temp[1],Integer.parseInt(temp[2]),temp[3]));
                        break;
                    default:
                        System.out.println("Não foi possivel adicionar item1");
                        break;
                }
            }

            buffr.close();

        }catch(FileNotFoundException e){ //nao existe o arquivo
            File f = new File(userPath);
            try{
                f.createNewFile();

            }catch(IOException r){
                r.printStackTrace();
            }

        }catch(IOException e){
            System.out.println("Erro ao ler arquivo ->" + e.getMessage());
        }
    } 
    
    /**
     * Metodo que Exibe o menu principal da Biblioteca, dentro dela chamamos as operaçoes especificas
     */
    public void display(){
        int op = -1;

        while(op != 0){ //menu principal
            System.out.println("\nDigite o que deseja fazer:\n"+
                                "1 - Cadastro\n" + 
                                "2 - Devolucao/Emprestimo\n"+
                                "3 - Busca\n" + 
                                "4 - Consulta de Emprestimos\n" + 
                                "0 - Sair");  

            op = scan.nextInt();
            switch(op){
                case 1:
                    cadastros(); //realizar cadastros
                    break;
                case 2:
                    devolucaoOuEmprestimo(); //devoluçoes e emprestimos
                    break;
                case 3:
                    buscaTitulo(); //busca de titulos
                    break;
                case 4:
                    consultaEmprestimos(); //consulta de emprestimos
                    break;
                case 0:
                    sair();
                    break;
                default:
                    System.out.println("Opçao inexistente!");
                    break;
            }
        }
    }


    /**
     * Metodo que serve de menu para chamar as funçoes de Cadastro especificos
     */
    private void cadastros(){
        int op = -1;

        while(op != 0){ //menu dos cadastros
        System.out.println("\nDigite o que deseja cadastrar:\n" +
                            "1 - Item\n" +
                            "2 - Usuario\n" +  
                            "0 - Sair");  

            op = scan.nextInt();
            switch(op){
                case 1:
                    cadastroItem();
                    break;
                case 2:
                    cadastroUsuario();
                    break;
                case 0:
                    return; 
                default:
                    System.out.println("Opçao inexistente!");
                    break;
            }
        }

    }

    /**
     * Funçao principal do Cadastro de items, possui menu própio para selecionar o tipo de cadastro
     * , além das verificaçoes especificas.
     */
    private void cadastroItem(){
        BufferedWriter buffw;
        int op =-1; //opçao a ser executada
        String nome, autor;
        String anoPublicacao, quantDisponivel;

        System.out.println("\nDigite o que deseja cadastrar:\n" +
                            "1 - Livro\n" +
                            "2 - Revista\n" + 
                            "3 - CD\n" + 
                            "4 - Sair");  

        op = scan.nextInt();
        switch(op){
            case 1: //livro
                String editora,ibns;

                try{
                    //pega valores
                    System.out.println("Digite o nome do livro:");
                    scan.nextLine();
                    nome = scan.nextLine();
                    System.out.println("Digite o autor do livro:");
                    autor = scan.nextLine();
                    System.out.println("Digite o ano de publicacao do livro:");
                    anoPublicacao = scan.nextLine();                                   //usar string e converter pra int, mas facil de pegar erro quando "a" nao converte pra int
                    System.out.println("Digite a quantidade de livros:");
                    quantDisponivel = scan.nextLine();
                    System.out.println("Digite o editor do livro:");
                    editora = scan.nextLine();
                    System.out.println("Digite o ibns do livro:");
                    ibns = scan.nextLine();

                    //salva o objeto na lista
                    itens.add(new Livro(nome, autor,  Integer.parseInt(anoPublicacao), Integer.parseInt(quantDisponivel), 0, editora, ibns));

                    //salva o objeto no arquivo
                    buffw = new BufferedWriter(new FileWriter(new File(getItemFilePath()),true));
                    buffw.write("Livro#"+nome+"#"+autor+"#"+anoPublicacao+"#"+quantDisponivel+"#"+editora+"#"+ibns);
                    buffw.newLine();

                    //fecha arquivo
                    buffw.close();

                }catch(NumberFormatException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro -> " + e.getMessage());

                }

                break;
            case 2: //revista
                String volume, num;

                try{
                    System.out.println("Digite o nome da revista:");
                    scan.nextLine();
                    nome = scan.nextLine();
                    System.out.println("Digite o autor da revista:");
                    autor = scan.nextLine();
                    System.out.println("Digite o ano de publicacao da revista:");
                    anoPublicacao = scan.nextLine();
                    System.out.println("Digite a quantidade de revistas:");
                    quantDisponivel = scan.nextLine();
                    System.out.println("Digite o volume da revista:");
                    volume = scan.nextLine();
                    System.out.println("Digite o numero da revista:");
                    num = scan.nextLine();

                    itens.add(new Revista(nome, autor, Integer.parseInt(anoPublicacao), Integer.parseInt(quantDisponivel), 0, Integer.parseInt(volume), Integer.parseInt(num)));

                    buffw = new BufferedWriter(new FileWriter(new File(getItemFilePath()),true));
                    buffw.write("Revista#"+nome+"#"+autor+"#"+anoPublicacao+"#"+quantDisponivel+"#"+volume+"#"+num);
                    buffw.newLine();

                    buffw.close();

                }catch(NumberFormatException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro -> " + e.getMessage());

                }

                break;
            case 3: //cd
                String vol, gravadora;

                try{
                    System.out.println("Digite o nome do CD:");
                    scan.nextLine();
                    nome = scan.nextLine();
                    System.out.println("Digite o autor do CD:");
                    autor = scan.nextLine();
                    System.out.println("Digite o ano de publicacao do CD:");
                    anoPublicacao = scan.nextLine();
                    System.out.println("Digite a quantidade de CDs:");
                    quantDisponivel = scan.nextLine();
                    System.out.println("Digite o volume do CD:");
                    vol = scan.nextLine();
                    System.out.println("Digite a gravadora do CD:");
                    gravadora = scan.nextLine();

                    itens.add(new CD(nome, autor, Integer.parseInt(anoPublicacao), Integer.parseInt(quantDisponivel), 0, Integer.parseInt(vol), gravadora));

                    buffw = new BufferedWriter(new FileWriter(new File(getItemFilePath()),true));
                    buffw.write("CD#"+nome+"#"+autor+"#"+anoPublicacao+"#"+quantDisponivel+"#"+vol+"#"+gravadora);
                    buffw.newLine();
                    
                    buffw.close();

                }catch(NumberFormatException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro -> " + e.getMessage());

                }

                break;

            case 4:
                return;
        }
    }

    /**
     * Funçao principal do Cadastro de usuarios, possui menu própio para selecionar o tipo de cadastro
     * , além das verificaçoes especificas.
     */
    private void cadastroUsuario(){
        BufferedWriter buffw = null;
        int op =-1;
        String nome, matricula;

        System.out.println("\nDigite o que deseja cadastrar:\n" +
                            "1 - Aluno\n" +
                            "2 - Professor\n" + 
                            "3 - Assesor Tecnico\n" + 
                            "0- Sair");  

        op = scan.nextInt();
        switch(op){
            case 1: //Aluno
                String curso, periodo;

                try{ 
                    //receve valores
                    System.out.println("Digite o nome do Aluno:");
                    scan.nextLine();
                    nome = scan.nextLine();
                    System.out.println("Digite a matricula do Aluno:");
                    matricula = scan.nextLine();
                    System.out.println("Digite o curso do Aluno:");
                    scan.nextLine();
                    curso = scan.nextLine();
                    System.out.println("Digite o periodo do Aluno:");
                    periodo = scan.nextLine();

                
                    //adiciona novo usuario a lista
                    users.add(new Aluno(nome, Integer.parseInt(matricula), curso, periodo));

                    //salva novo usuario ao arquivo
                    buffw = new BufferedWriter(new FileWriter(new File(getUserFilePath()),true));
                    buffw.write("Aluno#"+nome+"#"+matricula+"#"+curso+"#"+periodo);
                    buffw.newLine();

                    //fecha o arquivo
                    buffw.close();

                }catch(NumberFormatException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 2: //Professor
                String departamento, titulacao;

                try{
                    System.out.println("Digite o nome do Professor:");
                    scan.nextLine();
                    nome = scan.nextLine();
                    System.out.println("Digite a matricula do Professor:");
                    matricula = scan.nextLine();
                    System.out.println("Digite o departamento do Professor:");                  
                    departamento = scan.nextLine();
                    System.out.println("Digite a titulacao do Professor:");
                    titulacao = scan.nextLine();

                
                    users.add(new Professor(nome, Integer.parseInt(matricula), departamento, titulacao));

                    buffw = new BufferedWriter(new FileWriter(new File(getUserFilePath()),true));
                    buffw.write("Professor#"+nome+"#"+matricula+"#"+departamento+"#"+titulacao);
                    buffw.newLine();

                    buffw.close();

                }catch(NumberFormatException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 3: //Assessor
                String secao;

                try{
                    System.out.println("Digite o nome do Assessor:");
                    scan.nextLine();
                    nome = scan.nextLine();
                    System.out.println("Digite a matricula do Assessor:");
                    matricula = scan.nextLine();
                    System.out.println("Digite a seçao do Assessor:");
                    
                    secao = scan.nextLine();

                
                    users.add(new AssesorTecnico(nome, Integer.parseInt(matricula), secao));

                    buffw = new BufferedWriter(new FileWriter(new File(getUserFilePath()),true));
                    buffw.write("Assessor#"+nome+"#"+matricula+"#"+secao);
                    buffw.newLine();

                    buffw.close();

                }catch(NumberFormatException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos -> " + e.getMessage());

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 0:
                return;
        }

    }

    /**
     * Menu principal da area de Devolucao e Emprestimos,
     * a partir dela as funçoes especificas são chamadas
     */
    private void devolucaoOuEmprestimo(){
        int op  = -1;

        while(op != 0){ //Menu das Devolucoes e Emprestimos,
            System.out.println("\nDigite o que deseja fazer:\n" +
                            "1 - Devolucao\n" +
                            "2 - Emprestimo\n" + 
                            "0- Sair"); 

            op = scan.nextInt();

            switch(op){
                case 1:
                    devolucao();
                    break;
                case 2:
                    emprestimo();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opçao inexistente");
                    break;
            }
        }
    }

    /**
     * Metodo principal que realiza o emprestimo de um titulo a partir da matricula e do titulo do item,
     * alem de fazer as verificaçoes se existem copias disponiveis
     */
    private void emprestimo(){
        Usuario user = buscaUsuario();  //busca usuario
        Item titulo = buscaTitulo();   //busca item
        String dataEmprestimo, dataPrevista;

        if(titulo != null){ //se existir o titulo
            if(titulo.getQuantDisponivel() > 0){
                titulo.emprestimo();

                System.out.println("Digite a data do emprestimo (dd/mm/aa):");
                dataEmprestimo = scan.nextLine();
                System.out.println("Digite a data prevista da devoluvao (dd/mm/aa):");
                dataPrevista = scan.nextLine();

                //adiciona o emprestimo ao usuario
                user.addEmprestimo(titulo, dataEmprestimo, dataPrevista);
                System.out.println("Emprestimo Criado!");

            }else{ //tratamento de erro
                System.out.println("Não existem copias disponiveis!");
            }
        }

    }

    /**
     * Metodo principal que realiza a devolucao de um titulo a partir da matricula e do titulo do item,
     * porem somente quando o usuario possui um emprestimo com tal item
     */
    private void devolucao(){
        Usuario user = buscaUsuario(); //busca usuario
        Item titulo = buscaTitulo();   //busca item
        Emprestimo emprestimo;
        String dataDevolucao;        
        
        if(titulo != null ){ //se existir o titulo
            if(titulo.getQuantEmprestada() > 0){ //se houver emprestimos
                emprestimo = user.buscarEmprestimo(titulo.getTitulo());
                
                if(emprestimo != null){               //existe emprestimos para esse usuario?
                    System.out.println("Digite a data da devolucao:");
                    dataDevolucao = scan.nextLine();
                    
                    titulo.devolucao(); //devolve os valores
                    emprestimo.setDataDevolucao(dataDevolucao); //altera a entrega

                    float multa = user.calcularMulta(emprestimo); //pega valor de multa

                    if(multa > 0){                                          //exibe multa
                        System.out.println("Voce tem que pagar uma multa de R$"+ multa + " pelo atraso!");
                    }

                    System.out.println("Devolucao completa!");                 

                }else{ //tratamento de erro 1
                    System.out.println("Voce não possui emprestimos desse titulo!");

                }
            }else{  //tratamento de erro 2
                System.out.println("Não existe emprestimos desse titulo!");

            }
            
        }
        
    }

    /**
     * Funçao que busca um certo item pelo seu titulo,
     * e retorna sua instancia para a variavel ou funçao que o chamou
     * @return Instancia do Item
     */
    private Item buscaTitulo(){
        String titulo;
        int i = 0;

        System.out.println("Digite o titulo do Item:");
        scan.nextLine();
        titulo = scan.nextLine(); //pega nome do item

        while(i < itens.size()-1 && !titulo.equals(itens.get(i).getTitulo())) //procura
            i++;

        if(titulo.equals(itens.get(i).getTitulo())){ //verifica se é o item
            Item temp = itens.get(i);
            temp.getDados();
            return temp; //retorna e printa o item
        }else{
            System.out.println("Item não encontrado!");
            return null;
        }
        
    }

    /**
     * Funçao que busca um certo usuario usando sua matricula,
     * e retorna sua instancia para a variavel ou funçao que o chamou
     * @return Instancia do Usuario
     */
    private Usuario buscaUsuario(){
        int matricula;
        int i = 0;

        System.out.println("Digite a matricula do Usuario:");
        scan.nextLine();
        matricula = scan.nextInt();

        while(i < users.size()-1 && matricula != users.get(i).getMatricula())
            i++;
        
        if(matricula == users.get(i).getMatricula()){
            return users.get(i);
        }else{
            System.out.println("Usuario não encontrado!");
            return null;
        }
        
    }

    /**
     * Printa na tela todos os titulos emprestados do usuario pesquisado
     */
    private void consultaEmprestimos(){
        Usuario user = buscaUsuario(); //busca o usuario

        if(user != null)
            user.printEmprestimos(); //printa os emprestimos

    }

    /**
     * Sai do programa, chamado pelo funçao principal do menu Biblioteca
     */
    private void sair(){
        return; //sai do programa
    }

    /**
     * Retorna o Local do arquivo dos usuarios para salvar ou pegar
     * @return Local do Arquivo dos Usuarios
     */
    public String getUserFilePath(){
        return userPath;
    }

    /**
     * Retorna o Local do arquivo dos items para salvar ou pegar
     * @return Local do Arquivo dos Items
     */
    public String getItemFilePath(){
        return itemPath;
    }

}
