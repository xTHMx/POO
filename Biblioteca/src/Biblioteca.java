import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author tulio.henry
 */
public class Biblioteca {
    private int op;
    private List<Usuario> users = new ArrayList<>();
    private List<Item> itens = new ArrayList<>();
    private Usuario usuarioLogado;

    public Biblioteca(String itemPath, String userPath){
        BufferedReader buffr;
        String line;
        String[] temp;

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
            e.printStackTrace();
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
                    case "AssesorTecnico":
                    users.add(new AssesorTecnico(temp[1],Integer.parseInt(temp[2]),temp[3]));
                        break;
                    default:
                        System.out.println("Não foi possivel adicionar item");
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
        while(op != 0){
            switch(op){
                default:
                    System.out.println("Opçao inexistente!");
                    break;
            }
        }
    }

}
