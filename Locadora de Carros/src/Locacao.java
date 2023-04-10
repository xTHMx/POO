
import java.util.Date;

/**
 *
 * @author tulio.henry
 */
public class Locacao {
    private int numero;
    private String dataInic;
    private String dataFim;
    private Cliente cliente;
    private Carro carro;
    private String motorista;
    private Date dataI, dataF;
    
    
    public Locacao(String dataInic, String dataFim, Cliente cli, Carro c){
        this.dataInic = dataInic;
        this.dataFim = dataFim;
        this.carro = c;
        this.cliente = cli;
        
        motorista = cli.getNome();
    }
    
    public double calcularValor(){
        String[] inicio = dataInic.split("/");
        String[] fim = dataFim.split("/");
                        
                         //year                       month                         day
        dataI = new Date(Integer.parseInt(inicio[2]), Integer.parseInt(inicio[1]), Integer.parseInt(inicio[0])); 
        dataF = new Date(Integer.parseInt(fim[2]), Integer.parseInt(fim[1]), Integer.parseInt(fim[0]));  

        long diff = dataF.getTime() - dataI.getTime(); //getTime() -> return milisecs
        int dias = (int)  Math.floor(diff/ (1000*60*60*24)); //treat as int
        System.out.println(dias);
        
        return dias * carro.getValorDiaria();
        
        /* //old version
                
        int diaInic, mesInic, anoInic, diaFim, mesFim, anoFim;
        int diff;
        
        diaInic = Integer.parseInt(inicio[0]);
        mesInic = Integer.parseInt(inicio[1]);
        anoInic = Integer.parseInt(inicio[2]);
        diaFim = Integer.parseInt(fim[0]);
        mesFim = Integer.parseInt(fim[1]);
        anoFim = Integer.parseInt(fim[2]);
        
        diff = (diaFim + mesFim*30 + anoFim*365) - (diaInic + mesInic*30 + anoInic*365);

        return diff * carro.getValorDiaria();
        */
        
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDataInic() {
        return dataInic;
    }

    public void setDataInic(String dataInic) {
        this.dataInic = dataInic;
    }

    public String getDataFim() {
        return dataFim;
    }

    public void setDataFim(String dataFim) {
        this.dataFim = dataFim;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Carro getCarro() {
        return carro;
    }

    public void setCarro(Carro carro) {
        this.carro = carro;
    }

    public String getMotorista() {
        return motorista;
    }

    public void setMotorista(String motorista) {
        this.motorista = motorista;
    }
    
    
}