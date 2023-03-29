public class MaiorNumero {
    

    public void Maior(double[] d_arr){
        int i = 0, maior = 0;
        int size = d_arr.length;

        for(i = 0; i < size-1; i++){
            if(d_arr[maior] < d_arr[i]){
                maior = i;
            }
        }

        System.out.println("Maior: " + d_arr[maior]);
    }
}


/*
 * No Main ->
 * 
    MaiorNumero m = new MaiorNumero();
    double[]  arr = {1,22,3,51,12,6,123,4,25,61,12};
    m.Maior(arr);
 */