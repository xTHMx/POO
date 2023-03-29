public class ParImpar {
    

    public void Teste(int[] arr){
        int i;

        for(i = 0; i < arr.length; i++){
            if((arr[i] % 2) == 0)
                System.out.println(arr[i] + " é Par");
            else
                System.out.println(arr[i] + " é Impar");
        }
    }
}


/*
   No Main->
   
 * ParImpar n = new ParImpar();
   int[] m = {1,4,6,23,51,612,12,64,223};
   n.Teste(m);
    
 */