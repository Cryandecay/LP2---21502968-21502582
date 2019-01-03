package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

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

    public abstract boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy);

    @Override
    public String toString() {//TODO: Falta fazer para capturadas
        return  idPeca + " | "
                + getClass().getSimpleName() + " | "
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

    public boolean encontraRainha(int xD, int yD){
        List<CrazyPiece> rainhas = getRainha();
        int deltaXDestino;
        int deltaYDestino;

        for(CrazyPiece rainha: rainhas){
            if(rainha.idEquipa != this.idEquipa){
                deltaXDestino = Math.abs(rainha.coordenadaX - xD);
                deltaYDestino = Math.abs(rainha.coordenadaY - yD);

                if (this.idTipoPeca == 1){
                    if(deltaXDestino == 0 && deltaYDestino == 0){
                        return false;
                    }
                }

                if (deltaXDestino <= 2 && deltaYDestino <= 2){
                    return true;
                }
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

    public boolean descobreDirecao(int direcaoX, int direcaoY, int xO, int yO, int deltaXMAXIMO, int deltaYMAXIMO) {
        List<CrazyPiece> linha = new ArrayList<>();

        if (direcaoX < 0 && direcaoY > 0) {//ESQUERDA BAIXO
            int deltaXCrazy;
            int deltaYCrazy;

            int deltaXPeca;
            int deltaYPeca;
            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaXPeca = Math.abs(peca.coordenadaX - xO);
                    deltaYPeca = Math.abs(peca.coordenadaY - yO);
                    if (peca.coordenadaX < xO && peca.coordenadaY > yO && deltaXPeca < deltaXMAXIMO && deltaYPeca < deltaYMAXIMO){//le para a esquerda
                        return false;
                    }
                }
                return true;
            }
        }

        if (direcaoX < 0 && direcaoY < 0) {//ESQUERDA CIMA
            int deltaXCrazy;
            int deltaYCrazy;

            int deltaXPeca;
            int deltaYPeca;
            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaXPeca = Math.abs(peca.coordenadaX - xO);
                    deltaYPeca = Math.abs(peca.coordenadaY - yO);
                    if (peca.coordenadaX < xO && peca.coordenadaY < yO && deltaXPeca < deltaXMAXIMO && deltaYPeca < deltaYMAXIMO){//le para a esquerda
                        return false;
                    }
                }
                return true;
            }

        }

        if (direcaoX > 0 && direcaoY < 0) {//DIREITA CIMA
            int deltaXCrazy;
            int deltaYCrazy;

            int deltaXPeca;
            int deltaYPeca;
            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaXPeca = Math.abs(peca.coordenadaX - xO);
                    deltaYPeca = Math.abs(peca.coordenadaY - yO);
                    if (peca.coordenadaX > xO && peca.coordenadaY < yO && deltaXPeca < deltaXMAXIMO && deltaYPeca < deltaYMAXIMO){//le para a esquerda
                        return false;
                    }
                }
                return true;
            }
        }

        if (direcaoX > 0 && direcaoY > 0) {//DIREITA BAIXO
            int deltaXCrazy;
            int deltaYCrazy;

            int deltaXPeca;
            int deltaYPeca;
            for(CrazyPiece crazy: crazyList){
                deltaXCrazy = Math.abs(crazy.coordenadaX - xO);
                deltaYCrazy = Math.abs(crazy.coordenadaY - yO);
                if (deltaXCrazy == deltaYCrazy) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaXPeca = Math.abs(peca.coordenadaX - xO);
                    deltaYPeca = Math.abs(peca.coordenadaY - yO);
                    if (peca.coordenadaX > xO && peca.coordenadaY > yO && deltaXPeca < deltaXMAXIMO && deltaYPeca < deltaYMAXIMO){//le para a esquerda
                        return false;
                    }
                }
                return true;
            }
        }

        if (direcaoX == 0 && direcaoY < 0) {//CIMA
            int deltaYPeca;
            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaX == xO) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaYPeca = Math.abs(peca.coordenadaY - yO);
                    if (peca.coordenadaY < yO && deltaYPeca < deltaYMAXIMO){//le para cima
                        return false;
                    }
                }
                return true;
            }
        }

        if (direcaoX == 0 && direcaoY > 0){//BAIXO
            int deltaYPeca;
            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaX == xO) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaYPeca = Math.abs(peca.coordenadaY - yO);
                    if (peca.coordenadaY > yO && deltaYPeca < deltaYMAXIMO){//le para baixo
                        return false;
                    }
                }
                return true;
            }

        }

        if (direcaoX > 0 && direcaoY == 0) {//DIREITA
            int deltaXPeca;
            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaY == yO) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaXPeca = Math.abs(peca.coordenadaX - xO);
                    if (peca.coordenadaX > xO && deltaXPeca < deltaXMAXIMO){//le para a direita
                        return false;
                    }
                }
                return true;
            }
        }

        if (direcaoX < 0 && direcaoY == 0) {//ESQUERDA
            int deltaXPeca;
            for(CrazyPiece crazy: crazyList){
                if (crazy.coordenadaY == yO) {
                    linha.add(crazy);
                }
            }

            if (linha.size() == 0) {
                return true;
            } else {
                for (CrazyPiece peca: linha){
                    deltaXPeca = Math.abs(peca.coordenadaX - xO);
                    if (peca.coordenadaX < xO && deltaXPeca < deltaXMAXIMO){//le para a esquerda
                        return false;
                    }
                }
                return true;
            }
        }

        return false;
    }

}
