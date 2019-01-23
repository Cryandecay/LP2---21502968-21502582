package pt.ulusofona.lp2.crazyChess;

import java.util.ArrayList;
import java.util.List;

public class Sugestao implements Comparable<Sugestao>{
    List<Comparable> listaDeSugestoes = new ArrayList<>();
    List<CrazyPiece> crazyList = new ArrayList<>();
    List<CrazyPiece> capturas = new ArrayList<>();
    int equipaAJogar;
    int tamanhoTabuleiro;
    int xO;
    int yO;
    int ponto;
    List<Integer> pontos = new ArrayList<>();


    public Sugestao(List<CrazyPiece> crazyList, List<CrazyPiece> capturas, int equipaAJogar, int tamanhoTabuleiro, int xO, int yO) {
        this.crazyList = crazyList;
        this.capturas = capturas;
        this.equipaAJogar = equipaAJogar;
        this.tamanhoTabuleiro = tamanhoTabuleiro;
        this.xO = xO;
        this.yO = yO;
    }

    public List<Comparable> sugestao() {
        String equipaNaoAtiva = "Pedido inválido";
        pontos = new ArrayList<>();
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
                        if(linhaX == xO && colunaY == yO){
                            this.ponto = aCrazyList.previsaoDePontos(linhaX,colunaY);
                            continue;
                        }
                        if (aCrazyList.movimentoPrevisao(xO, yO, linhaX, colunaY, aCrazyList)) {
                            ponto = aCrazyList.previsaoDePontos(linhaX,colunaY);
                            listaDeSugestoes.add(linhaX + " , " + colunaY + " , " + ponto );
                            pontos.add(ponto);
                        }
                    }
                }

                System.out.println(listaDeSugestoes);
                boolean truth = true;
                for (int i=0; i<pontos.size();i++) {


                       for (int e=0; e<pontos.size(); e++){
                            if (1 == pontos.get(i).compareTo(pontos.get(e))) {
                                int tmpPonto = pontos.get(e);
                                Comparable tmpSujest = listaDeSugestoes.get(e);
                                pontos.set(e, pontos.get(i));
                                listaDeSugestoes.set(e, listaDeSugestoes.get(i));
                                pontos.set(i, tmpPonto);
                                listaDeSugestoes.set(i, tmpSujest);

                            }
                       }

                }

                return listaDeSugestoes;
            }

        }

        return listaDeSugestoes;
    }


    public List<Integer> getPontos(){
        return pontos;
    }


    @Override
    public int compareTo(Sugestao o) {
        if (this.ponto == o.ponto){
            return 0;
        }
        if (this.ponto < o.ponto){
            return -1;
        } else {
            return 1;
        }
    }
}
