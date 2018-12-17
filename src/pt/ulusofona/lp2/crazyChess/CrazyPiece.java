package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public abstract class CrazyPiece {

    protected ArrayList<List<Integer>> previsao = new ArrayList<>();
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

    public abstract void previsoes();

    @Override
    public String toString() {
        return  idPeca +" | "+
                + idTipoPeca + " | "
                + idEquipa + " | "
                + alcunha + " @"+
                " (" + coordenadaX +
                ", " + coordenadaY +")";
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

    public ArrayList<List<Integer>> getPrevisao() {
        return previsao;
    }
}
