public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       Carro c1 = new Carro("a", "ART1242",50.0);
       
       Cliente cl1 = new Cliente("Etevaldo","456432234-12");
       
       Locacao l1 = new Locacao("12/02/2002", "13/03/2002", cl1, c1);
       
       System.out.println(l1.calcularValor());
       
    }
    
}