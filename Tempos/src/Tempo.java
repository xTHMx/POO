
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
        horas -= time.getHoras();
        minutos -= time.getMinutos();
        segundos -= time.getSegundos();
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
