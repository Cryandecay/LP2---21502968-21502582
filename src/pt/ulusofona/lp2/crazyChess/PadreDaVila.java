package pt.ulusofona.lp2.crazyChess;

import java.util.List;

public class PadreDaVila extends CrazyPiece {
    String tipo = "Padre da Vila";

    public PadreDaVila(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    public PadreDaVila(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    @Override
    public String getImagePNG() {
        if (idEquipa == 10){
            return "PriestWhite.png";
        } else {
            return "PriestBlack.png";
        }
    }

    @Override
    public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {

        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

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

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;
        coordenadaY = yD;

        return true; //TODO:Ja funca com as rainhas, testar board maior e pecas pelo caminho
    }

    public boolean encontraRainha(int xD, int yD){
        List<CrazyPiece> rainhas = getRainha();
        int deltaXDestino;
        int deltaYDestino;

        for(CrazyPiece rainha: rainhas){
            if(rainha.idEquipa != this.idEquipa){
                deltaXDestino = Math.abs(rainha.coordenadaX - xD);
                deltaYDestino = Math.abs(rainha.coordenadaY - yD);

                if (deltaXDestino <= 2 && deltaYDestino <= 2){
                    return true;
                }
            }
        }

        return false;
    }

    }
