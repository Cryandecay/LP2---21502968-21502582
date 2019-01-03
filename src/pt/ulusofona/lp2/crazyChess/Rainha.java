package pt.ulusofona.lp2.crazyChess;

public class Rainha extends CrazyPiece{
    public Rainha(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    public Rainha(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
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

        if(!findFriend(xD, yD, idPeca, idEquipa)){
            return false;
        }

        if (!encontraRainha(xD, yD)){
            return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, 5, 5)) {
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;
        coordenadaY = yD;

        return true;//TODO:Testar direcao, testar caça rainha
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

        if(!findFriend(xD, yD, idPeca, idEquipa)){
            return false;
        }

        if (!encontraRainha(xD, yD)){
            return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, 5, 5)) {
            return false;
        }

        return true;//TODO:Testar direcao, testar caça rainha
    }


}
