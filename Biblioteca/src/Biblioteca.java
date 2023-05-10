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

        this.userPath = userPath;
        this.itemPath = itemPath;

        //items
        try{
            buffr = new BufferedReader(new FileReader(itemPath));
            
            while((line = buffr.readLine()) != null){
                temp = line.split("#");

                switch(temp[0]){
                    case "Livro":
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

            buffr.close();

        }catch(IOException e){
            System.out.println("Erro ao salvar cadastro " + e.getMessage());
        }

        //usuarios
        try{
            buffr = new BufferedReader(new FileReader(userPath));
            
            while((line = buffr.readLine()) != null){
                temp = line.split("#");

                switch(temp[0]){
                    case "Aluno":
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

        }catch(FileNotFoundException e){
            File f = new File(userPath);
            try{
                f.createNewFile();

            }catch(IOException r){
                r.printStackTrace();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    } 
    
    public void display(){
        int op = -1;
        while(op != 0){
            System.out.println("\nDigite o que deseja fazer:\n"+
                                "1 - Cadastro\n" + 
                                "2 - Devolucao/Emprestimo\n"+
                                "3 - Busca\n" + 
                                "4 - Consulta de Emprestimos\n" + 
                                "0 - Sair");  

            op = scan.nextInt();
            switch(op){
                case 1:
                    cadastros();
                    break;
                case 2:
                    devolucaoOuEmprestimo();
                    break;
                case 3:
                    buscaTitulo();
                    break;
                case 4:
                    consulta();
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


    private void cadastros(){
        int op = -1;

        while(op != 0){
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

    private void cadastroItem(){
        BufferedWriter buffw;
        int op =-1;
        String nome, autor;
        int anoPublicacao, quantDisponivel;

        System.out.println("\nDigite o que deseja cadastrar:\n" +
                            "1 - Livro\n" +
                            "2 - Revista\n" + 
                            "3 - CD\n" + 
                            "4 - Sair");  

        op = scan.nextInt();
        switch(op){
            case 1: //livro
                System.out.println("Digite o nome do livro:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite o autor do livro:");
                autor = scan.nextLine();
                System.out.println("Digite o ano de publicacao do livro:");
                anoPublicacao = scan.nextInt();
                System.out.println("Digite a quantidade de livros:");
                quantDisponivel = scan.nextInt();
                System.out.println("Digite o editor do livro:");
                String editora = scan.nextLine();
                System.out.println("Digite o ibns do livro:");
                String ibns = scan.nextLine();

                try{
                    itens.add(new Livro(nome, autor, anoPublicacao, quantDisponivel, 0, editora, ibns));

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos " + e.getMessage());
                }

                try{
                    buffw = new BufferedWriter(new FileWriter(new File(getItemFilePath()),true));
                    buffw.write("Livro#"+nome+"#"+autor+"#"+anoPublicacao+"#"+quantDisponivel+"#"+editora+"#"+ibns);
                    buffw.newLine();
                    buffw.close();

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;
            case 2: //revista
                System.out.println("Digite o nome darevista:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite o autor da revista:");
                autor = scan.nextLine();
                System.out.println("Digite o ano de publicacao da revista:");
                anoPublicacao = scan.nextInt();
                System.out.println("Digite a quantidade de revistas:");
                quantDisponivel = scan.nextInt();
                System.out.println("Digite o volume da revista:");
                int volume = scan.nextInt();
                System.out.println("Digite o numero da revista:");
                int num = scan.nextInt();

                try{
                    itens.add(new Revista(nome, autor, anoPublicacao, quantDisponivel, 0, volume, num));

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos " + e.getMessage());
                }

                try{
                    buffw = new BufferedWriter(new FileWriter(new File(getItemFilePath()),true));
                    buffw.write("Revista#"+nome+"#"+autor+"#"+anoPublicacao+"#"+quantDisponivel+"#"+volume+"#"+num);
                    buffw.newLine();
                    buffw.close();

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;
            case 3: //cd
                System.out.println("Digite o nome do CD:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite o autor do CD:");
                autor = scan.nextLine();
                System.out.println("Digite o ano de publicacao do CD:");
                anoPublicacao = scan.nextInt();
                System.out.println("Digite a quantidade de CDs:");
                quantDisponivel = scan.nextInt();
                System.out.println("Digite o volume do CD:");
                int vol = scan.nextInt();
                System.out.println("Digite a gravadora do CD:");
                String gravadora = scan.nextLine();

                try{
                    itens.add(new CD(nome, autor, anoPublicacao, quantDisponivel, 0, vol, gravadora));

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos " + e.getMessage());
                }

                try{
                    buffw = new BufferedWriter(new FileWriter(new File(getItemFilePath()),true));
                    buffw.write("CD#"+nome+"#"+autor+"#"+anoPublicacao+"#"+quantDisponivel+"#"+vol+"#"+gravadora);
                    buffw.newLine();
                    buffw.close();

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 4:
                return;
        }
    }

    private void cadastroUsuario(){
        BufferedWriter buffw = null;
        int op =-1;
        String nome;
        int matricula;

        System.out.println("\nDigite o que deseja cadastrar:\n" +
                            "1 - Aluno\n" +
                            "2 - Professor\n" + 
                            "3 - Assesor Tecnico\n" + 
                            "0- Sair");  

        op = scan.nextInt();
        switch(op){
            case 1: //Aluno
                System.out.println("Digite o nome do Aluno:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite a matricula do Aluno:");
                matricula = scan.nextInt();
                System.out.println("Digite o curso do Aluno:");
                scan.nextLine();
                String curso = scan.nextLine();
                System.out.println("Digite o periodo do Aluno:");
                String periodo = scan.nextLine();

                try{
                    users.add(new Aluno(nome,matricula,curso,periodo));

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos " + e.getMessage());
                }

                try{
                    buffw = new BufferedWriter(new FileWriter(new File(getUserFilePath()),true));
                    buffw.write("Aluno#"+nome+"#"+matricula+"#"+curso+"#"+periodo);
                    buffw.newLine();
                    buffw.close();

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 2: //Professor
                System.out.println("Digite o nome do Professor:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite a matricula do Professor:");
                matricula = scan.nextInt();
                System.out.println("Digite o departamento do Professor:");
                scan.nextLine();
                String departamento = scan.nextLine();
                System.out.println("Digite a titulacao do Professor:");
                String titulacao = scan.nextLine();

                try{
                    users.add(new Professor(nome,matricula,departamento,titulacao));

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos " + e.getMessage());
                }

                try{
                    buffw = new BufferedWriter(new FileWriter(new File(getUserFilePath()),true));
                    buffw.write("Professor#"+nome+"#"+matricula+"#"+departamento+"#"+titulacao);
                    buffw.newLine();
                    buffw.close();

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 3: //Assessor
                System.out.println("Digite o nome do Assessor:");
                scan.nextLine();
                nome = scan.nextLine();
                System.out.println("Digite a matricula do Assessor:");
                matricula = scan.nextInt();
                System.out.println("Digite a seçao do Assessor:");
                scan.nextLine();
                String secao = scan.nextLine();

                try{
                    users.add(new AssesorTecnico(nome,matricula,secao));

                }catch(IllegalArgumentException e){
                    System.out.println("Argumento invalidos " + e.getMessage());

                }catch(InputMismatchException e){
                    System.out.println("Argumento invalidos " + e.getMessage());
                }

                try{
                    buffw = new BufferedWriter(new FileWriter(new File(getUserFilePath()),true));
                    buffw.write("Assessor#"+nome+"#"+matricula+"#"+secao);
                    buffw.newLine();
                    buffw.close();

                }catch(IOException e){
                    System.out.println("Erro ao salvar cadastro " + e.getMessage());

                }

                break;

            case 0:
                return;
        }

    }

    private void devolucaoOuEmprestimo(){
        int op  = -1;

        while(op != 0){
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

    private void emprestimo(){
        Usuario user = buscaUsuario();
        Item titulo = buscaTitulo();
        String dataEmprestimo, dataPrevista;

        if(titulo != null){
            if(titulo.getQuantDisponivel() > 0){
                titulo.emprestimo();

                System.out.println("Digite a data do emprestimo:");
                dataEmprestimo = scan.nextLine();
                System.out.println("Digite a data prevista da devoluvao:");
                dataPrevista = scan.nextLine();

                user.addEmprestimo(titulo, dataEmprestimo, dataPrevista);
                System.out.println("Emprestimo Criado!");

            }else{
                System.out.println("Não existem copias disponiveis!");
            }
        }

    }

    private void devolucao(){
        Usuario user = buscaUsuario();
        Item titulo = buscaTitulo();
        Emprestimo emprestimo;
        String dataDevolucao;        
        
        emprestimo = user.buscarEmprestimo(titulo.getTitulo());
        

        if(emprestimo != null && titulo != null){
            System.out.println("Digite a data da devolucao:");
            dataDevolucao = scan.nextLine();

            
            titulo.devolucao();
            emprestimo.setDataDevolucao(dataDevolucao);

            float multa = user.calcularMulta(emprestimo);

            if(multa > 0){
                System.out.println("Voce tem que pagar uma multa de R$"+ multa + " pelo atraso!");
            }

            System.out.println("Devolucao completa!");

        }else{
            System.out.println("Voce não possui emprestimos desse titulo!");
        }
        
    }

    private Item buscaTitulo(){
        String titulo;
        int i = 0;

        System.out.println("Digite o titulo do Item:");
        titulo = scan.nextLine();

        while(i < itens.size()-1 && !titulo.equals(itens.get(i).getTitulo()))
            i++;

        if(titulo.equals(itens.get(i).getTitulo())){
            Item temp = itens.get(i);
            temp.getDados();
            return temp;
        }else{
            System.out.println("Item não encontrado!");
            return null;
        }
        
    }

    private Usuario buscaUsuario(){
        String nome;
        int i = 0;

        System.out.println("Digite o nome do Usuario:");
        scan.nextLine();
        nome = scan.nextLine();

        while(i < users.size()-1 && !nome.equals(users.get(i).getNome()))
            i++;
        
        if(nome.equals(users.get(i).getNome())){
            return users.get(i);
        }else{
            System.out.println("Item não encontrado!");
            return null;
        }
        
    }

    private void consulta(){

    }

    private void sair(){
        return;
    }

    public String getUserFilePath(){
        return userPath;
    }

    public String getItemFilePath(){
        return itemPath;
    }

}
