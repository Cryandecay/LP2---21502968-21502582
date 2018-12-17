package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public void previsoes(){
        List<Integer> indentacao = new ArrayList<>();

        indentacao.add(coordenadaX + 1);//direita
        indentacao.add(coordenadaY);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX - 1);//esquerda
        indentacao.add(coordenadaY);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX);//cima
        indentacao.add(coordenadaY + 1);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX);//baixo
        indentacao.add(coordenadaY - 1);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX + 1);//cima direita
        indentacao.add(coordenadaY + 1);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX + 1);//baixo direita
        indentacao.add(coordenadaY - 1);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX - 1);//baixo esquerda
        indentacao.add(coordenadaY - 1);
        previsao.add(indentacao);
        indentacao.clear();

        indentacao.add(coordenadaX - 1);//cima esquerda
        indentacao.add(coordenadaY + 1);
        previsao.add(indentacao);
        indentacao.clear();


    }


}
