public class Main {
    public static void main(String[] args) throws Exception {
        Capitulo cap1 = new Capitulo("Terezinha", 56, "Marco");
        Capitulo cap2 = new Capitulo("A velha Amiga", 72, "Marco");

        Livro livro = new Livro("Herbet Richards", "A Menina", 2, 60.0f);

        livro.addCapitulo(cap1);
        livro.addCapitulo(cap2);
    }
}
