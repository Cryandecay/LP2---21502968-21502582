package pt.ulusofona.lp2.crazyChess;

public class CrazyPiece {
    int IdPeca;
    int IdTipoPeca;
    int IdEquipa;
    String Alcunha;
    int x;
    int y;
    boolean captured=false;

    public int getId(){
        return IdPeca;
    }

    public String getImagePNG()  {
            if (IdTipoPeca==1){
                return "BishopWhite.png";
            }
            if (IdTipoPeca==2){
                return "HorseWhite.png";
            }
            if (IdTipoPeca==3){
                return "KingWhite.png";
            }
            if (IdTipoPeca==4){
                return "QueenWhite.png";
            }
            if (IdTipoPeca==5){
                return "TowerWhite.png";
            }
            if (IdTipoPeca==6){
                return "PeonWhite.png";
            }
            if (IdTipoPeca==7){
                return "BishopBlack.png";
            }
            if (IdTipoPeca==8){
                return "HorseBlack.png";
            }
            if (IdTipoPeca==9){
                return "KingBlack.png";
            }
            if (IdTipoPeca==10){
                return "QueenBlack.png";
            }
            if (IdTipoPeca==11){
                return "TowerBlack.png";
            }
            if (IdTipoPeca==12){
                return "PeonBlack.png";
            }
            return "table";
        }

    public String toString(){return "1|1|1|Peca";}



}
