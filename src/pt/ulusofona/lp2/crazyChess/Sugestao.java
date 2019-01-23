package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public class Sugestao implements Comparable<CrazyPiece>{
    List<String> listaDeSugestoes = new ArrayList<>();
    List<CrazyPiece> crazyList = new ArrayList<>();
    List<CrazyPiece> capturas = new ArrayList<>();
    int equipaAJogar;
    int tamanhoTabuleiro;
    int xO;
    int yO;

    public Sugestao(List<CrazyPiece> crazyList, List<CrazyPiece> capturas, int equipaAJogar, int tamanhoTabuleiro, int xO, int yO) {
        this.crazyList = crazyList;
        this.capturas = capturas;
        this.equipaAJogar = equipaAJogar;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.xO = xO;
        this.yO = yO;
    }

    public List<String> sugestao() {
        String equipaNaoAtiva = "Pedido inválido";

        for (CrazyPiece aCrazyList : crazyList) {
            if (aCrazyList.getCoordenadaX() == xO && aCrazyList.getCoordenadaY() == yO) {
                if (equipaAJogar != aCrazyList.getIdEquipa()) {
                    listaDeSugestoes.add(equipaNaoAtiva);
                    return listaDeSugestoes;
                }
                aCrazyList.setCrayList(crazyList);
                aCrazyList.setCapturas(capturas);


                for (int linhaX = 0; linhaX < tamanhoTabuleiro; linhaX++) {
                    for (int colunaY = 0; colunaY < tamanhoTabuleiro; colunaY++) {
                        if (aCrazyList.movimentoPrevisao(xO, yO, linhaX, colunaY, aCrazyList)) {
                            listaDeSugestoes.add(linhaX + " , " + colunaY);

                        }
                    }
                }


                return listaDeSugestoes;
            }

        }

        return listaDeSugestoes;
    }


    @Override
    public int compareTo(CrazyPiece o) {
        return 0;
    }
}
