
public class Vetor {
    
   public static int[] somaVetor(int[] a, int[] b){
        int[] ans = new int[a.length];
        int i;
        
        for(i = 0; i < a.length; i++){
            ans[i] = a[i] + b[i];
        }

        return ans;
    }

    public static double[] somaVetor(double[] a, double[] b){
        double[] ans = new double[a.length];
        int i;
        
        for(i = 0; i < a.length; i++){
            ans[i] = a[i] + b[i];
        }
        System.out.print("\n");

        return ans;
    }

    public static void printVetor(int[] vet){
        int i;

        for(i = 0; i < vet.length; i++){
            System.out.print(vet[i] + " ");
        }
    }

    public static void printVetor(double[] vet){
        int i;
 
        for(i = 0; i < vet.length; i++){
            System.out.print(vet[i] + " ");
        }
        System.out.print("\n");
    }
    
}
