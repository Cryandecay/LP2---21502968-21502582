package pt.ulusofona.lp2.crazyChess;

import java.util.List;

public class Rainha extends CrazyPiece{
    public Rainha(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Rainha";
        valorRelativo = "8";
        valorRelativoParaCalculo = 8;
    }

    public Rainha(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Rainha";
        valorRelativo = "8";
        valorRelativoParaCalculo = 8;
    }

    @Override
    public String getImagePNG() {
        if (idEquipa == 10){
            return "QueenBlack.png";
        } else {
            return "QueenWhite.png";
        }
    }

    @Override
    public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
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
            if(!findFriend(xD, yD, idPeca, idEquipa)){
                return false;
            }

            if (!antiRainha(xD, yD)){
                return false;
            }

            if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
                return false;
            }

            findCapture(xD, yD, idPeca, idEquipa);
            coordenadaX = xD;
            coordenadaY = yD;
            estatisticas.maisUmTurno();
            estatisticas.maisUmTurnoCaptura();

            return true;//TODO:Testar direcao, testar caça rainha
        } else {
            return false;
        }


    }

    @Override
    public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
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
            if(!findFriend(xD, yD, idPeca, idEquipa)){
                return false;
            }

            if (!antiRainha(xD, yD)){
                return false;
            }

            if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
                return false;
            }


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

}
