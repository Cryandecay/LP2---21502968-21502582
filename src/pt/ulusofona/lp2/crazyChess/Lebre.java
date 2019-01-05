package pt.ulusofona.lp2.crazyChess;

public class Lebre extends CrazyPiece {

    public Lebre(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Lebre";
        valorRelativo = "2";
    }

    public Lebre(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Lebre";
        valorRelativo = "2";
    }

    @Override
    public String getImagePNG() {
        if (idEquipa == 10){
            return "LebreBlack.png";
        } else {
            return "LebreWhite.png";
        }
    }

    @Override
    public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {

        if(estatisticas.turno%2 != 0){
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

        if(estatisticas.turno%2 != 0){
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
            return true; //TODO: Até contrário funciona.
        }
    }
    }
