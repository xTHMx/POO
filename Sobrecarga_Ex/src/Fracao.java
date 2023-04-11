public class Fracao {
    private double denominador;
    private double numerador;

    public Fracao(double numerador, double denominador){
        if(denominador < 0){
            System.out.println("Denominador nao pode ser negativo");

        }else if(denominador == 0){
            System.out.println("Denominador nao pode ser zero");

        }else{
            this.denominador = denominador;
            this.numerador = numerador;
        }
    }

    public static void somaFracao(Fracao a, Fracao b){
        double den, num; //denominador e numerador

        den = a.getDenominador(); 

        if(a.getDenominador() == b.getDenominador() ){
            num = a.getNumerador() + b.getNumerador();
        }else{
            den = a.getDenominador() * b.getDenominador();
            num = (a.getNumerador() * b.getDenominador()) + (b.getNumerador() * a.getDenominador());
        }

        System.out.println((num / den));
    }
    
    public static void subtFracao(Fracao a, Fracao b){
        double den, num; //denominador e numerador

        den = a.getDenominador(); 

        if(a.getDenominador() == b.getDenominador() ){
            num = a.getNumerador() - b.getNumerador();
        }else{
            den = a.getDenominador() * b.getDenominador();
            num = (a.getNumerador() * b.getDenominador()) - (b.getNumerador() * a.getDenominador());
        }

        System.out.println((num / den));
    }

    public static void multFracao(Fracao a, Fracao b){
        double den, num; //denominador e numerador

        num = a.getNumerador() * b.getNumerador();
        den = a.getDenominador() * b.getDenominador();       

        System.out.println((num / den));
    }

    public static void divFracao(Fracao a, Fracao b){
        double den, num; //denominador e numerador

        num = a.getNumerador() * b.getDenominador();
        den = a.getDenominador() * b.getNumerador();       

        System.out.println((num / den));
    }

    public double getNumerador(){
        return numerador;
    }

    public double getDenominador(){
        return denominador;
    }

}
