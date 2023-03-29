import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringEspecial {
    Scanner scan = new Scanner(System.in);

    public void CheckSpecial(){
        String str;
        Pattern p = Pattern.compile("[!@#$%&*()_+=|<>?{}\\[\\]~-]", Pattern.CASE_INSENSITIVE);
        Matcher m;
        boolean isfound;

        
        str = scan.nextLine();
        m = p.matcher(str);
        isfound = m.find();

        if(isfound){
            System.out.println("Foi encontrado caracteres especiais!");
        }else{
            System.out.println("Nenhum caracter especial!");
        }

    }

}

/*
 * Exemplos de Pattern
 * Pattern letter = Pattern.compile("[a-zA-z]");
   Pattern digit = Pattern.compile("[0-9]");
Pattern special = Pattern.compile ("[!@#$%&*()_+=|<>?{}\\[\\]~-]");
 */