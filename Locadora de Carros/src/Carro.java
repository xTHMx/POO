/**
 *
 * @author tulio.henry
 */
public class Carro {
    
    private String modelo;
    private String placa;
    private double valorDiaria;
    
    public Carro(String modelo, String placa, double valor){
        this.modelo = modelo;
        this.placa = placa;
        this.valorDiaria = valor;
    }

    public String getModelo() {
        return modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public double getValorDiaria() {
        return valorDiaria;
    }
    
    
}