package pt.ulusofona.lp2.crazyChess;

import static pt.ulusofona.lp2.crazyChess.Simulador.equipaAJogar;
import static pt.ulusofona.lp2.crazyChess.Simulador.jodaValidaPretas;
import static pt.ulusofona.lp2.crazyChess.Simulador.jodaValidaBrancas;
import static pt.ulusofona.lp2.crazyChess.Simulador.turno;
import static pt.ulusofona.lp2.crazyChess.Simulador.turnoCaptura;
import static pt.ulusofona.lp2.crazyChess.Simulador.capturas;
import static pt.ulusofona.lp2.crazyChess.Simulador.crazyList;

public abstract class CrazyPiece {

    protected int idPeca;
    protected int idTipoPeca;
    protected int idEquipa;
    protected String alcunha;
    protected int coordenadaX;
    protected int coordenadaY;


    public CrazyPiece(String idPeca, String idTipoPeca,String idEquipa , String alcunha, int x, int y) {
        this.idPeca = Integer.parseInt(idPeca);
        this.idTipoPeca = Integer.parseInt(idTipoPeca);
        this.idEquipa = Integer.parseInt(idEquipa);
        this.alcunha = alcunha;
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public CrazyPiece(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        this.idPeca = idPeca;
        this.idTipoPeca = idTipoPeca;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public abstract String getImagePNG();

    public abstract boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy);

    @Override
    public String toString() {
        return  idPeca +" | "+
                + idTipoPeca + " | "
                + idEquipa + " | "
                + alcunha + " @"+
                " (" + coordenadaX +
                ", " + coordenadaY +")";
    }

    boolean findFriend(int x, int y, int iD, int equipa) {
        for (CrazyPiece crazy : crazyList) {
            if (crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y) {
                if (crazy.getId() != iD && crazy.getId() != 0) {
                    if(crazy.getIdEquipa() == equipa){
                        return false;
                    }
                }
            }
        }
        return true;
    }

    void findCapture(int x, int y, int iD, int equipa) {
        turno++;
        turnoCaptura++;

        if (equipaAJogar == 10){
            equipaAJogar = 20;
            jodaValidaPretas++;
        } else {
            equipaAJogar = 10;
            jodaValidaBrancas++;
        }

        for(CrazyPiece crazy: crazyList){
            if(crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y ){
                if(crazy.getId() != iD && crazy.getId() != 0){
                    if(crazy.getIdEquipa() != equipa){
                        capturas.add(crazy);
                        turnoCaptura = 0;
                    }
                }
            }
        }

        for(CrazyPiece crazy: crazyList){
            if(crazy.getId() == 0){
                capturas.add(crazy);
                turnoCaptura = 0;
            }
        }
        removeCrazyList();
    }

    void removeCrazyList(){
        for(CrazyPiece captured: capturas){
            crazyList.remove(captured);
        }
    }

    public int getId(){
        return idPeca;
    }

    public int getIdTipoPeca() {
        return idTipoPeca;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }

}
