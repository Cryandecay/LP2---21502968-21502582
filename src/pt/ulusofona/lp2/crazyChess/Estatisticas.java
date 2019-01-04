package pt.ulusofona.lp2.crazyChess;

public class Estatisticas {
    int turnoCaptura = 0; //contador dos turnos sem captura
    int turno = 0; //Turnos do jogo
    int equipaAJogar = 20;// 10 pretas 20 brancas
    Integer jodaInvalidaBrancas = 0;
    Integer jodaInvalidaPretas = 0;
    int jodaValidaBrancas = 0 ;
    int jodaValidaPretas = 0;

    public Estatisticas(int turnoCaptura, int turno, int equipaAJogar, Integer jodaInvalidaBrancas, Integer jodaInvalidaPretas, int jodaValidaBrancas, int jodaValidaPretas) {
        this.turnoCaptura = turnoCaptura;
        this.turno = turno;
        this.equipaAJogar = equipaAJogar;
        this.jodaInvalidaBrancas = jodaInvalidaBrancas;
        this.jodaInvalidaPretas = jodaInvalidaPretas;
        this.jodaValidaBrancas = jodaValidaBrancas;
        this.jodaValidaPretas = jodaValidaPretas;
    }

    public int getTurnoCaptura() {
        return turnoCaptura;
    }

    public void setTurnoCaptura(int turnoCaptura) {
        this.turnoCaptura = turnoCaptura;
    }

    public int getTurno() {
        return turno;
    }

    public void setTurno(int turno) {
        this.turno = turno;
    }

    public int getEquipaAJogar() {
        return equipaAJogar;
    }

    public void setEquipaAJogar(int equipaAJogar) {
        this.equipaAJogar = equipaAJogar;
    }

    public Integer getJodaInvalidaBrancas() {
        return jodaInvalidaBrancas;
    }

    public void setJodaInvalidaBrancas(Integer jodaInvalidaBrancas) {
        this.jodaInvalidaBrancas = jodaInvalidaBrancas;
    }

    public Integer getJodaInvalidaPretas() {
        return jodaInvalidaPretas;
    }

    public void setJodaInvalidaPretas(Integer jodaInvalidaPretas) {
        this.jodaInvalidaPretas = jodaInvalidaPretas;
    }

    public int getJodaValidaBrancas() {
        return jodaValidaBrancas;
    }

    public void setJodaValidaBrancas(int jodaValidaBrancas) {
        this.jodaValidaBrancas = jodaValidaBrancas;
    }

    public int getJodaValidaPretas() {
        return jodaValidaPretas;
    }

    public void setJodaValidaPretas(int jodaValidaPretas) {
        this.jodaValidaPretas = jodaValidaPretas;
    }
}
