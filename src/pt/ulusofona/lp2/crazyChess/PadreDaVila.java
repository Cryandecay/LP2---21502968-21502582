package pt.ulusofona.lp2.crazyChess;

public class PadreDaVila extends CrazyPiece {

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

        if (deltaX != 1 || deltaX != 2 || deltaX != 3) {
            return false;
        }

        if (deltaY != 1 || deltaX !=2 || deltaX != 3){
            return false;
        }

        if(!findFriend(xD, yD, idPeca, idEquipa)){
            return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaX = xD;
        coordenadaY = yD;

        return true; //TODO: Não Testado
        }
    }
