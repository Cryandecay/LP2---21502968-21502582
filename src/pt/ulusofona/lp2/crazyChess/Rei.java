package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {

    public Rei(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    public Rei(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    @Override
    public String getImagePNG() {

        if (idEquipa == 10){
            return "KingBlack.png";
        } else {
            return "KingWhite.png";
        }

    }

    public void moverCima(){
        coordenadaY = coordenadaY + 1;
    }

    public void moverBaixo(){
        coordenadaY = coordenadaY - 1;
    }

    public void moverEsquerda(){
        coordenadaX = coordenadaX - 1;
    }

    public void moverDireita(){
        coordenadaX = coordenadaX + 1;
    }


}
