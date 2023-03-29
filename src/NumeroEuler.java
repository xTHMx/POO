public class NumeroEuler {
    
    public int Frac(int n){
        if(n == 1 || n == 0) 
            return 1;
        else
            return n * Frac(n-1);
    }

    public double Euler(int n){ 
        if(n > 0)
            return (1/(double)Frac(n)) + Euler(n-1);  //operaçoe aritimeticas devem ser feitas com o mesmo tipo de return (double)

        return 0;
    }
    
}
