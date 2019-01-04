package pt.ulusofona.lp2.crazyChess;


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
    @Override
    public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {

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

        return true; //TODO:Testar com board maior, para quando encontra alguem na direcao em que se dirige
    }


    }
