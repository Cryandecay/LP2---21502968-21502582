package pt.ulusofona.lp2.crazyChess;



public class Joker extends CrazyPiece {
    public Joker(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    public Joker(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
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
        
        return false;

    }

    @Override
    public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        return false;
    }

}
