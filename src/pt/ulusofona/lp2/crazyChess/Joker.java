package pt.ulusofona.lp2.crazyChess;


import java.util.List;

public class Joker extends CrazyPiece {

    public Joker(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Joker";
        valorRelativo = "4";
    }

    public Joker(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Joker";
        valorRelativo = "4";
    }

    public String getImagePNG() {
        if (idEquipa == 10){
            return "JokerBlack.png";
        } else {
            return "JokerWhite.png";
        }
    }

    @Override
    public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        if (estatisticas.turno % 5 == 0 && estatisticas.turno != 0){

        }
        if (estatisticas.turno == 0){//Rainha
            idTipoPeca = 1;
            return movimentoRainha(xO, yO, xD, yD, crazy);
        }

        if (estatisticas.turno == 1){//Ponei Magico
            idTipoPeca = 2;
            return movimentoPoneiMagico(xO, yO, xD, yD, crazy);
        }

        if (estatisticas.turno == 2){//Padre da Vila
            idTipoPeca = 3;
            return movimentoPadreDaVila(xO, yO, xD, yD, crazy);
        }

        if (estatisticas.turno == 3){//TorreH
            idTipoPeca = 4;
            return movimentoTorreH(xO, yO, xD, yD, crazy);
        }

        if (estatisticas.turno == 4){//TorreV
            idTipoPeca = 5;
            return movimentoTorreV(xO, yO, xD, yD, crazy);
        }

        if (estatisticas.turno == 5){//Lebre
            idTipoPeca = 6;
            return movimentoLebre(xO, yO, xD, yD, crazy);
        }

        return false;
    }

    public boolean movimentoRainha(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if (deltaX > 5) {
            return false;
        }

        if (deltaY > 5) {
            return false;
        }

        if (deltaX == deltaY || deltaX == 0 || deltaY == 0) {
            if (!findFriend(xD, yD, idPeca, idEquipa)) {
                return false;
            }

            if (!antiRainha(xD, yD)) {
                return false;
            }

            if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
                return false;
            }

            findCapture(xD, yD, idPeca, idEquipa);
            coordenadaX = xD;
            coordenadaY = yD;

            return true;//TODO:Testar direcao, testar caça rainha
        } else {
            return false;
        }
    }
    public boolean antiRainha(int xD, int yD){
        List<CrazyPiece> rainhas = getRainha();
        int deltaXDestino;
        int deltaYDestino;

        for(CrazyPiece rainha: rainhas){
            deltaXDestino = Math.abs(rainha.coordenadaX - xD);
            deltaYDestino = Math.abs(rainha.coordenadaY - yD);

            if (deltaXDestino == 0 && deltaYDestino == 0){
                return false;
            }
        }

        return true;
    }

    public boolean movimentoPoneiMagico(int xO, int yO, int xD, int yD, CrazyPiece crazy){
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if (deltaX != 2) {
            return false;
        }
        if (deltaY != 2) {
            return false;
        }

        if(!findFriend(xD, yD, idPeca, idEquipa)){
            return false;
        }

        if(!antiRei(xO, yO, xD, yD, direcaoX, direcaoY)){
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;
        coordenadaY = yD;

        return true;
    }
    public boolean antiRei(int xO, int yO, int xD, int yD, int direcaoX, int direcaoY) {
        List<CrazyPiece> reis = getRei();
        int deltaXReiOrigem;
        int deltaYReiOrigem;

        int deltaXReiDestino;
        int deltaYReiDestino;

        for (CrazyPiece rei: reis){
            deltaXReiOrigem = Math.abs(rei.coordenadaX - xO);
            deltaYReiOrigem = Math.abs(rei.coordenadaY - yO);

            deltaXReiDestino = Math.abs(rei.coordenadaX - xD);
            deltaYReiDestino = Math.abs(rei.coordenadaY - yD);

            if (rei.coordenadaX == xD && rei.coordenadaY == yD){
                return true;
            }

            if (deltaXReiOrigem > 2 || deltaYReiOrigem > 2) {
                continue;
            }

            if (deltaXReiOrigem == 1 && deltaYReiOrigem == 1){
                continue;
            }

            if (direcaoX < 0 && direcaoY > 0) {//ESQUERDA BAIXO

                if (deltaXReiOrigem == -1 && deltaYReiOrigem == 0 || deltaXReiOrigem == 0 && deltaYReiOrigem == 1){
                    return false;
                }

                if(deltaXReiDestino <= 2 && deltaYReiDestino <= 2){
                    return false;
                }

            }

            if (direcaoX < 0 && direcaoY < 0) {//ESQUERDA CIMA

                if (deltaXReiOrigem == -1 && deltaYReiOrigem == 0 || deltaXReiOrigem == 0 && deltaYReiOrigem == -1){
                    return false;
                }

                if(deltaXReiDestino <= 2 && deltaYReiDestino <= 2){
                    return false;
                }
            }

            if (direcaoX > 0 && direcaoY < 0) {//DIREITA CIMA

                if (deltaXReiOrigem == 1 && deltaYReiOrigem == 0 || deltaXReiOrigem == 0 && deltaYReiOrigem == -1){
                    return false;
                }

                if(deltaXReiDestino <= 2 && deltaYReiDestino <= 2){
                    return false;
                }
            }

            if (direcaoX > 0 && direcaoY > 0) {//DIREITA BAIXO

                if (deltaXReiOrigem == 1 && deltaYReiOrigem == 0 || deltaXReiOrigem == 0 && deltaYReiOrigem == 1){
                    return false;
                }

                if(deltaXReiDestino <= 2 && deltaYReiDestino <= 2){
                    return false;
                }
            }

        }

        return true;
    }

    public boolean movimentoPadreDaVila(int xO, int yO, int xD, int yD, CrazyPiece crazy){
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if (deltaX != deltaY) {
            return false;
        }

        if (deltaX > 3 || deltaY > 3){
            return false;
        }

        if (!findFriend(xD, yD, idPeca, idEquipa)){
            return false;
        }

        if (!encontraRainha(xD, yD)){
            return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;
        coordenadaY = yD;

        return true; //TODO:Testar com board maior, para quando encontra alguem na direcao em que se dirige
    }

    public boolean movimentoTorreH(int xO, int yO, int xD, int yD, CrazyPiece crazy){
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if(deltaY != 0){
            return false;
        }

        if(!findFriend(xD, yD, idPeca, idEquipa)){
            return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;

        return true;//TODO:funciona esquerda direita, nao mexe na direçao em que encontra pecas
    }

    public boolean movimentoTorreV(int xO, int yO, int xD, int yD, CrazyPiece crazy){
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if (deltaX != 0) {
            return false;
        }

        if (!findFriend(xD, yD, idPeca, idEquipa)) {
            return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaY = yD;

        return true;
    }

    public boolean movimentoLebre(int xO, int yO, int xD, int yD, CrazyPiece crazy){
        if(estatisticas.turno%2 == 0){
            return false;
        } else {

            int deltaX = Math.abs(xD - xO);
            int deltaY = Math.abs(yD - yO);

            if (deltaX != 1) {
                return false;
            }
            if (deltaY != 1) {
                return false;
            }

            if(!findFriend(xD, yD, idPeca, idEquipa)){
                return false;
            }

            findCapture(xD, yD, idPeca, idEquipa);
            coordenadaX = xD;
            coordenadaY = yD;

            return true; //TODO: Até contrário funciona.
        }
    }


    @Override
    public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        return false;
    }

}
