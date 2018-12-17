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
    public void previsoes() {

    }


}
