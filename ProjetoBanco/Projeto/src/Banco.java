import java.util.ArrayList;

public class Banco {
    private String nome;
    private int numero; 
    private String cnpj;
    private String endereco;
    private Conta contaLogada;
    private ArrayList<Agencia> agencias = new ArrayList<Agencia>();

    public Agencia buscarAgencia(int codigo){
        int i;
        Agencia temp;
        for(i = 0; i < agencias.size(); i++){
            temp = agencias.get(i);
            if(temp.getNumeroAgencia() == codigo){
                return temp;
            }
        }
        return null; //nao encontrei
    }

    public void logarCliente(int numAgencia, int numConta, String senha){
        Agencia temp = buscarAgencia(numAgencia);
        Conta temp2 = temp.buscarConta(numConta, senha);
        if(temp2 == null)
            System.out.println("Conta não encontrada");
    }

}
