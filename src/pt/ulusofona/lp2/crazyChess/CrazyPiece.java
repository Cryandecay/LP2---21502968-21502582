package pt.ulusofona.lp2.crazyChess;


public class CrazyPiece {
    int idPeca;
    int idTipoPeca;
    int idEquipa;
    String alcunha;
    int coordenadaX;
    int coordenadaY;



    public CrazyPiece(String idPeca, String idTipoPeca,String idEquipa , String alcunha, int coordenadaX, int coordenadaY) {
        this.idPeca = Integer.parseInt(idPeca);
        this.idTipoPeca = Integer.parseInt(idTipoPeca);
        this.idEquipa = Integer.parseInt(idEquipa);
        this.alcunha = alcunha;
        this.coordenadaX = coordenadaX;
        this.coordenadaY = coordenadaY;
    }

    public CrazyPiece(int idPeca, int idTipoPeca,int idEquipa, String alcunha, int x, int y) {
        this.idPeca = idPeca;
        this.idTipoPeca = idTipoPeca;
        this.idEquipa = idEquipa;
        this.alcunha = alcunha;
        this.coordenadaX = x;
        this.coordenadaY = y;
    }





    public int getId(){
        return idPeca;
    }

    public String getImagePNG()  {
            if (idTipoPeca ==0 && idEquipa==1){
                return "KingWhite.png";
            }
            if (idTipoPeca ==1){
                return "HorseWhite.png";
            }
            if (idTipoPeca ==2){
                return "BishopWhite.png";
            }
            if (idTipoPeca ==3){
                return "QueenWhite.png";
            }
            if (idTipoPeca ==4){
                return "TowerWhite.png";
            }
            if (idTipoPeca ==5){
                return "PeonWhite.png";
            }
            if (idTipoPeca ==8){
                return "BishopBlack.png";
            }
            if (idTipoPeca ==7){
                return "HorseBlack.png";
            }
            if (idTipoPeca ==0 && idEquipa==0){
                return "KingBlack.png";
            }
            if (idTipoPeca ==9){
                return "QueenBlack.png";
            }
            if (idTipoPeca ==10){
                return "TowerBlack.png";
            }
            if (idTipoPeca ==11){
                return "PeonBlack.png";
            }
            return "table";
        }

    @Override
    public String toString() {
        return  idPeca +" | "+
                + idTipoPeca + " | "
                + idEquipa + " | "
                + alcunha + " @"+
                " (" + coordenadaX +
                ", " + coordenadaY +")";
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

    public void setCoordenadaX(int coordenadaX) {
        this.coordenadaX = coordenadaX;
    }

    public void setCoordenadaY(int coordenadaY) {
        this.coordenadaY = coordenadaY;
    }




}
