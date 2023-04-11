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

    }
}
