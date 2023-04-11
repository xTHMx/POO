
public class Tempo {
    private int horas;
    private int minutos;
    private int segundos;

    public Tempo(){
        horas = 0;
        minutos = 0;
        segundos = 0;
    }

    public Tempo(int horas, int minutos, int segundos){
        this.horas = horas;
        this.minutos = minutos;
        this.segundos = segundos;
    }

    public void printTempo(){
        System.out.println(horas+ ":" +minutos+ ":" +segundos);
    }

    public void subtractTime(Tempo time){
        long t1, t2, ans;
        t1 = (horas*3600) + (minutos*60) + segundos;
        t2 = (time.getHoras()*3600) + (time.getMinutos()*60) + time.getSegundos();
        ans = t1-t2;

        horas = (int) ans/3600;
        ans -= horas * 3600;
        minutos = (int) ans/60;
        ans -= minutos*60;
        segundos = (int) ans;

    }

    public void addTime(Tempo time){
        long t1, t2, ans;
        t1 = (horas*3600) + (minutos*60) + segundos;
        t2 = (time.getHoras()*3600) + (time.getMinutos()*60) + time.getSegundos();
        ans = t1+t2;

        horas = (int) ans/3600;
        ans -= horas * 3600;
        minutos = (int) ans/60;
        ans -= minutos*60;
        segundos = (int) ans;
    }

    //getters
    public int getHoras(){
        return horas;
    }

    public int getMinutos(){
        return minutos;
    }

    public int getSegundos(){
        return segundos;
    }

    public void setHoras(int val){
        horas = val;
    }

    //setters
    public void setMinutos(int val){
        minutos = val;
    }

    public void setSegundos(int val){
        segundos = val;
    }
}
