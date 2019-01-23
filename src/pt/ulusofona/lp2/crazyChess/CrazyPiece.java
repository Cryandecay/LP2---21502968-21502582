package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public abstract class CrazyPiece {

    List<CrazyPiece> crazyList = null;
    List<CrazyPiece> capturas = null;
    Estatisticas estatisticas = null;

    protected String tipoeDePeca;
    protected String valorRelativo;

    protected List<CrazyPiece> capturasFeitasPorEstaPeca;

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

    public abstract boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy);

    @Override
    public String toString() {//TODO: Falta fazer para capturadas
        return  idPeca + " | " +
                this.tipoeDePeca + " | "
                + this.valorRelativo + " | "
                + idEquipa + " | "
                + alcunha + " @"+
                " (" + coordenadaX +
                ", " + coordenadaY +")";
    }

    void setCrayList(List<CrazyPiece> lista) {
        crazyList = lista;
    }

    public void setTipoeDePeca(String tipoeDePeca) {
        this.tipoeDePeca = tipoeDePeca;
    }

    public void setIdTipoPeca(int idTipoPeca) {
        this.idTipoPeca = idTipoPeca;
    }

    void setEstatisticas(Estatisticas dados){
        estatisticas = dados;
    }

    public void setCapturas(List<CrazyPiece> capturas) {
        this.capturas = capturas;
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
        estatisticas.maisUmTurno();
        estatisticas.maisUmTurnoCaptura();

        for(CrazyPiece crazy: crazyList){
            if(crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y ){
                if(crazy.getId() != iD && crazy.getId() != 0){
                    if(crazy.getIdEquipa() != equipa){
                        capturas.add(crazy);
                        capturasFeitasPorEstaPeca.add(crazy);
                        estatisticas.setTurnoCaptura(0);
                    }
                }
            }
        }

        for(CrazyPiece crazy: crazyList){
            if(crazy.getId() == 0){
                capturas.add(crazy);
                estatisticas.setTurnoCaptura(0);
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

    public List<CrazyPiece> getCrazyList() {
        return crazyList;
    }

    public List<CrazyPiece> getCapturas() {
        return capturas;
    }

    public Estatisticas getEstatisticas() {
        return estatisticas;
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

    public String getTipoeDePeca() {
        return tipoeDePeca;
    }

    public String getValorRelativo() {
        return valorRelativo;
    }

    public List<CrazyPiece> getCapturasFeitasPorEstaPeca() {
        return capturasFeitasPorEstaPeca;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public boolean encontraRainha(int xD, int yD){
        List<CrazyPiece> rainhas = getRainha();
        int deltaXDestino;
        int deltaYDestino;

        for(CrazyPiece rainha: rainhas){
            deltaXDestino = Math.abs(rainha.coordenadaX - xD);
            deltaYDestino = Math.abs(rainha.coordenadaY - yD);

                if (deltaXDestino <= 2 && deltaYDestino <= 2){
                    return true;
                }

        }

        return false;
    }

    public List<CrazyPiece> getRainha(){
        List<CrazyPiece> rainhas = new ArrayList<>();

        for(CrazyPiece crazy: crazyList){
            if(crazy.idTipoPeca == 1){
                rainhas.add(crazy);
            }
        }
        return rainhas;
    }

    public List<CrazyPiece> getRei(){
        List<CrazyPiece> reis = new ArrayList<>();

        for(CrazyPiece crazy: crazyList){
            if(crazy.idTipoPeca == 0){
                reis.add(crazy);
            }
        }
        return reis;
    }

    public boolean estaNoCaminho(List<CrazyPiece> linha, int xO, int yO, int deltaXDestino , int deltaYDestino){
        int deltaXPeca;
        int deltaYPeca;

        if (linha.size() == 0) {
            return true;
        } else {
            for (CrazyPiece peca: linha) {

                deltaXPeca = Math.abs(peca.coordenadaX - xO);
                deltaYPeca = Math.abs(peca.coordenadaY - yO);

                if (deltaXPeca < deltaXDestino || deltaYPeca < deltaYDestino){
                    return false;
                }
            }
            return true;
        }
    }

    public boolean descobreDirecao(int direcaoX, int direcaoY, int xO, int yO, int deltaX, int deltaY) {
        List<CrazyPiece> linha = new ArrayList<>();

        if (direcaoX < 0 && direcaoY > 0) {//ESQUERDA BAIXO
            int deltaXCrazy;
            int deltaYCrazy;

            for (CrazyPiece crazy: crazyList) {
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    if (crazy.coordenadaX < xO && crazy.coordenadaY > yO){//le para a esquerda
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        if (direcaoX < 0 && direcaoY < 0) {//ESQUERDA CIMA
            int deltaXCrazy;
            int deltaYCrazy;

            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    if (crazy.coordenadaX < xO && crazy.coordenadaY < yO){//le para a esquerda
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        if (direcaoX > 0 && direcaoY < 0) {//DIREITA CIMA
            int deltaXCrazy;
            int deltaYCrazy;

            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    if (crazy.coordenadaX > xO && crazy.coordenadaY < yO){//le para a esquerda
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        if (direcaoX > 0 && direcaoY > 0) {//DIREITA BAIXO
            int deltaXCrazy;
            int deltaYCrazy;

            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    if (crazy.coordenadaX > xO && crazy.coordenadaY > yO){//le para a esquerda
                        linha.add(crazy);
                    }

                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);
        }

        if (direcaoX == 0 && direcaoY < 0) {//CIMA

            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaX == xO) {
                    if (crazy.coordenadaY < yO ){//le para cima
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        if (direcaoX == 0 && direcaoY > 0){//BAIXO

            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaX == xO) {
                    if (crazy.coordenadaY > yO ){//le para baixo
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        if (direcaoX > 0 && direcaoY == 0) {//DIREITA

            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaY == yO) {
                    if (crazy.coordenadaX > xO ){//le para a direita
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        if (direcaoX < 0 && direcaoY == 0) {//ESQUERDA

            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaY == yO) {
                    if (crazy.coordenadaX < xO){//le para a esquerda
                        linha.add(crazy);
                    }
                }
            }

            return estaNoCaminho(linha, xO, yO, deltaX, deltaY);

        }

        return false;
    }

    public boolean temCapturas(){
        if (capturasFeitasPorEstaPeca.size() > 0){
            return true;
        }
        return false;
    }

    public int numeroDePontos(){

        int total = 0;

        if (temCapturas() == false){
            return 0;
        } else {
           for (CrazyPiece peca: capturasFeitasPorEstaPeca){
               total = total + Integer.parseInt(peca.valorRelativo);
           }

           return total;
        }
    }
}
