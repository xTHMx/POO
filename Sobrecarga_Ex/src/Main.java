public class Main {
    public static void main(String[] args) throws Exception {
        /// Vetores
        int[] a = {1,2,3,4,5};
        int[] b = {2,4,6,8,10};
        double[] c = {1.2, 12.3, 56.2, 4.3};
        double[] d = {2.2, 6.3, 32.2, 7.4};

        int[] res;
        double[] res1;

        res = Vetor.somaVetor(a, b);
        Vetor.printVetor(res);
        res1 = Vetor.somaVetor(c, d);
        Vetor.printVetor(res1);

        //Fracao

        Fracao fra = new Fracao(1, 2);
        Fracao fra2 = new Fracao(2, 3);

        Fracao.somaFracao(fra,fra2);
        Fracao.subtFracao(fra,fra2);
        Fracao.multFracao(fra,fra2);
        Fracao.divFracao(fra,fra2);

        //Matrizes
        double[][] mat1 = {{1,2,3},{1,2,3},{1,2,3}};
        double[][] mat2 = {{2,2,2},{1,1,1},{3,3,3}};
        double[][] mat3;

        int[][] mat4 = {{1,2,3},{1,2,3},{1,2,3}};
        int[][] mat5 = {{2,2,2},{1,1,1},{3,3,3}};
        int[][] mat6;

        mat3 = Matriz.somaMatriz(mat1,mat2);
        Matriz.printMatriz(mat3);
        mat6 = Matriz.somaMatriz(mat4,mat5);
        Matriz.printMatriz(mat6);

    }
}
