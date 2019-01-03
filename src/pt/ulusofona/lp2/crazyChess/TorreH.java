package pt.ulusofona.lp2.crazyChess;

import static pt.ulusofona.lp2.crazyChess.Simulador.tamanhoTabuleiro;

public class TorreH extends CrazyPiece {
    String tipo = "TorreH";

    public TorreH(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    public TorreH(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    @Override
    public String getImagePNG() {
        if (idEquipa == 10){
            return "TowerBlackH.png";
        } else {
            return "TowerWhiteH.png";
        }
    }

    @Override
    public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
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

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, tamanhoTabuleiro, 0)) {
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;

        return true;//TODO:funciona esquerda direita, nao mexe na direçao em que encontra pecas
    }

    @Override
    public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
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

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, tamanhoTabuleiro, 0)) {
            return false;
        }


        return true;//TODO:funciona esquerda direita, nao mexe na direçao em que encontra pecas
    }
}
