public class Main {
    public static void main(String[] args) throws Exception {
        Tempo t1 = new Tempo(1,29,12);
        Tempo t2 = new Tempo(2,30,22);

        t2.subtractTime(t1);
        t2.printTempo();
        t1.addTime(t1);
        t1.printTempo();
    }
}
