package pt.ulusofona.lp2.crazyChess;

public class Estatisticas {
    int turnoCaptura = 0; //contador dos turnos sem captura
    int turno = 0; //Turnos do jogo
    int equipaAJogar = 0;// 10 pretas 20 brancas

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

    public int getEquipaAJogar() {
        return equipaAJogar;
    }
}
