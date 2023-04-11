public class Main {
    public static void main(String[] args) throws Exception {
        Tempo t1 = new Tempo();
        Tempo t2 = new Tempo(2,30,22);

        t1.subtractTime(t2);
        t1.printTempo();
    }
}
