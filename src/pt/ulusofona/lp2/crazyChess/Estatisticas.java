package pt.ulusofona.lp2.crazyChess;

public class Estatisticas {
    private int turnoCaptura = 0; //contador dos turnos sem captura
    private int turno = 0; //Turnos do jogo
    private int equipaAJogar = 0;// 10 pretas 20 brancas

    public Estatisticas(int turnoCaptura, int turno, int equipaAJogar) {
        this.turnoCaptura = turnoCaptura;
        this.turno = turno;
        this.equipaAJogar = equipaAJogar;
    }

    public int getTurnoCaptura() {
        return turnoCaptura;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurnoCaptura(int turnoCaptura) {
        this.turnoCaptura = turnoCaptura;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public void maisUmTurno(){
        turno++;
    }

    public void maisUmTurnoCaptura(){
        turnoCaptura++;
    }

    public int getEquipaAJogar() {
        return equipaAJogar;
    }
}
