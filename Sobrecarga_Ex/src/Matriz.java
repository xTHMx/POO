public class Matriz {
    
    public static double[][] somaMatriz(double[][] a, double[][] b){
        int i,j;
        double[][] mat;
        
        if(a[0].length == b[0].length && a.length == b.length ){ //matrizes de mesma ordem
            mat = new double[a[0].length][a.length];
            
            for(i=0; i < a.length; i++){            //length of col (mat.length)
                for(j = 0; j < a[0].length; j++){   //length of line (mat[i].length)
                    mat[i][j] = a[i][j] + b[i][j];
                }
            }

            return mat;

        }else{
            System.out.println("Matrizes nao sao de ordem igual!");
            return null;
        }

    }

    public static int[][] somaMatriz(int[][] a, int[][] b){
        int i,j;
        int[][] mat;
        
        if(a[0].length == b[0].length && a.length == b.length ){ //matrizes de mesma ordem
            mat = new int[a[0].length][a.length];
            
            for(i=0; i < a.length; i++){            //length of col (mat.length)
                for(j = 0; j < a[0].length; j++){   //length of line (mat[i].length)
                    mat[i][j] = a[i][j] + b[i][j];
                }
            }

            return mat;

        }else{
            System.out.println("Matrizes nao sao de ordem igual!");
            return null;
        }

    }

    public static void printMatriz(double[][] mat){
        int i, j;

        System.out.print("\n");
        for(i=0; i < mat.length; i++){            //length of col (mat.length)
            for(j = 0; j < mat[0].length; j++){   //length of line (mat[i].length)
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }

    }

    public static void printMatriz(int[][] mat){
        int i, j;

        System.out.print("\n");
        for(i=0; i < mat.length; i++){            //length of col (mat.length)
            for(j = 0; j < mat[0].length; j++){   //length of line (mat[i].length)
                System.out.print(mat[i][j] + " ");
            }
            System.out.print("\n");
        }

    }



}
