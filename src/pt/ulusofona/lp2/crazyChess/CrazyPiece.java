package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    int idPeca;
    int idTipoPeca;
    int idEquipa;
    String alcunha;
    int coordenadaX;
    int coordenadaY;
    boolean captured;


    public CrazyPiece(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y, boolean captured) {
        this.idPeca = idPeca;
        this.idTipoPeca = idTipoPeca;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;
        this.coordenadaX = x;
        this.coordenadaY = y;
        this.captured = captured;
    }

    public CrazyPiece(int coordenadaX, int coordenadaY) {
        idPeca =1;
        idTipoPeca=3;
        idEquipa=0;
        alcunha="Rei";
        this.coordenadaX=coordenadaX;
        this.coordenadaY=coordenadaY;
        captured= false;
    }

    public int getId(){
        return idPeca;
    }

    public String getImagePNG()  {
            if (idTipoPeca ==1){
                return "BishopWhite.png";
            }
            if (idTipoPeca ==2){
                return "HorseWhite.png";
            }
            if (idTipoPeca ==3){
                return "KingWhite.png";
            }
            if (idTipoPeca ==4){
                return "QueenWhite.png";
            }
            if (idTipoPeca ==5){
                return "TowerWhite.png";
            }
            if (idTipoPeca ==6){
                return "PeonWhite.png";
            }
            if (idTipoPeca ==7){
                return "BishopBlack.png";
            }
            if (idTipoPeca ==8){
                return "HorseBlack.png";
            }
            if (idTipoPeca ==9){
                return "KingBlack.png";
            }
            if (idTipoPeca ==10){
                return "QueenBlack.png";
            }
            if (idTipoPeca ==11){
                return "TowerBlack.png";
            }
            if (idTipoPeca ==12){
                return "PeonBlack.png";
            }
            return "table";
        }

    @Override
    public String toString() {
        return "CrazyPiece{" +
                "idPeca=" + idPeca +
                ", idTipoPeca=" + idTipoPeca +
                ", idEquipa=" + idEquipa +
                ", alcunha='" + alcunha + '\'' +
                ", coordenadaX=" + coordenadaX +
                ", coordenadaY=" + coordenadaY +
                ", captured=" + captured +
                '}';
    }

    public int getIdPeca() {
        return idPeca;
    }

    public int getIdTipoPeca() {
        return idTipoPeca;
    }

    public int getIdEquipa() {
        return idEquipa;
    }

    public String getAlcunha() {
        return alcunha;
    }

    public int getCoordenadaX() {
        return coordenadaX;
    }

    public int getCoordenadaY() {
        return coordenadaY;
    }

    public boolean isCaptured() {
        return captured;
    }

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }
}
