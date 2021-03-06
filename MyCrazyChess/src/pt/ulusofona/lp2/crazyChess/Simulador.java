package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Simulador {

    //File ficheiroInicial;
    static List<CrazyPiece> crazyList = new ArrayList<>();
    static int turnoCaptura = 0; //contador dos turnos sem captura
    static int turno = 0; //Turnos do jogo
    static int equipaAJogar = 20;// 10 pretas 20 brancas
    static Integer jodaInvalidaBrancas = 0;
    static Integer jodaInvalidaPretas = 0;
    static int jodaValidaBrancas = 0 ;
    static int jodaValidaPretas = 0;
    static int tamanhoTabuleiro = 0;
    static int numeroPecas = 0;
    String resultadoFinal;
    static List<CrazyPiece> capturas = new ArrayList<>();
    List<String> autores = new ArrayList<>();


    public Simulador(){ }

    public Simulador(List<CrazyPiece> crazyList, int turno, int equipaAJogar, List<CrazyPiece> capturas) {
        //this.ficheiroInicial = ficheiroInicial;
        this.crazyList = crazyList;
        this.turno = turno;
        this.equipaAJogar = equipaAJogar;
        this.capturas = capturas;
    }

    public boolean iniciaJogo(File ficheiroInicial) {
            List<List <String>> firstRow = new ArrayList<List <String>>();
            List<List <String>> mapas = new ArrayList<List <String>>();
            List<List <String>> pecas = new ArrayList<List <String>>();
            try {

                File ficheiro = new File(ficheiroInicial.getName());
                Scanner leitorFicheiro = new Scanner(ficheiro);

                while(leitorFicheiro.hasNextLine()) {
                    List<String> testew = new ArrayList<String>();
                    String linha = leitorFicheiro.nextLine();
                    String dados[] = linha.split(":");
                    testew.addAll(Arrays.asList(dados));
                    firstRow.add(testew);
                }
                leitorFicheiro.close();

                tamanhoTabuleiro = Integer.parseInt(firstRow.get(0).get(0));
                numeroPecas = Integer.parseInt(firstRow.get(1).get(0));

                for(int i = 2; i < numeroPecas + 2; i++){
                    pecas.add(firstRow.get(i));
                }
                for(int i = 2 + numeroPecas; i < firstRow.size(); i++){
                    mapas.add(firstRow.get(i));
                }

                stringTest(pecas, mapas);

                if (crazyList.size() != numeroPecas){
                    for (int i = 0; i < numeroPecas - crazyList.size() + 1; i++){
                        crazyList.add(new Rei(0,0,10,"0",-1,-1));
                    }
                }

                return true;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    void stringTest(List<List<String>> peca, List<List <String>> mapas){
        for(int i=0; i< peca.size();i++) {
            for (int e = 0; e < mapas.size(); e++) {
                for (int u = 0; u < mapas.get(e).size(); u++) {
                    if (mapas.get(e).get(u).equals(peca.get(i).get(0))) {
                        //peca.get(i).get(0) = id
                        //peca.get(i).get(1) = tipoPecas
                        //peca.get(i).get(2) = equipas
                        //peca.get(i).get(3) = alcunhas
                        //coordenadaX= u;
                        //coordenadaY= e;

                        if(peca.get(i).get(1).equals("0")) {//Rei
                            crazyList.add(new Rei(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("1")) {//Rainha
                            crazyList.add(new Rainha(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("2")) {//PoneiMagico
                            crazyList.add(new PoneiMagico(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("3")){//PadreDaVila
                            crazyList.add(new PadreDaVila(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("4")){//TorreH
                            crazyList.add(new TorreH(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("5")){//TorreV
                            crazyList.add(new TowerV(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("6")){//Lebre
                            crazyList.add(new Lebre(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("7")){//Joker
                            crazyList.add(new Joker(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));
                        }
                    }
                }
            }
        }
    }

    public boolean processaJogada(int xO, int yO, int xD, int yD) {
        if(xO == xD && yO == yD){
            return false;
        }
        if(xD < 0 || yD < 0){
            return false;
        }
        if(xD > tamanhoTabuleiro || yD > tamanhoTabuleiro){
            return false;
        }

        for (CrazyPiece crazy: crazyList) {
             if (crazy.getCoordenadaX() == xO && crazy.getCoordenadaY() == yO) {
                 if(equipaAJogar == crazy.getIdEquipa()) {
                     return crazy.movimento(xO, yO, xD, yD, crazy);
                 } else {
                     return false;
                 }
             }
        }

        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){
        return crazyList;
    }

    public boolean jogoTerminado(){
        List<CrazyPiece> whiteKing = new ArrayList<CrazyPiece>();
        List<CrazyPiece> blackKing = new ArrayList<CrazyPiece>();
        for(CrazyPiece crazy: crazyList){
            if(crazy.getIdEquipa()==10 && crazy.getIdTipoPeca()==0){
                blackKing.add(crazy);
            }
            if(crazy.getIdEquipa()==20 && crazy.getIdTipoPeca()==0){
                whiteKing.add(crazy);
            }
        }
        if (blackKing.size()==1 && whiteKing.size()==1){
            resultadoFinal="EMPATE";
            return true;
        }
        if (blackKing.size()==0){
            resultadoFinal="VENCERAM AS BRANCAS";
            return true;
        }
        if (whiteKing.size()==0){
            resultadoFinal="VENCERAM AS PRETAS";
            return true;
        }
        if(turnoCaptura==10 && capturas.size()>=1){
            resultadoFinal="EMPATE";
            return true;
        }
        return false;
    }

    public List<String> getAutores(){
        autores.add("André Graça");
        autores.add("João Lionço");
        return autores;
    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }

    public int getIDPeca(int x, int y) {
        for(CrazyPiece crazy: crazyList){
            if(crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y){
                return crazy.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        return equipaAJogar;
    }

    public List<String> getResultados(){
        List<String> resultado = new ArrayList<String>();
        resultado.add("JOGO DE CRAZY CHESS");
        resultado.add("Resultado: " + resultadoFinal );
        resultado.add( "---" );
        resultado.add("Equipa das Pretas");
        resultado.add(contarPecasCapturadas(1)+"");
        resultado.add(jodaValidaPretas+"");
        resultado.add(jodaInvalidaPretas+"");
        resultado.add("Equipa das Brancas");
        resultado.add( contarPecasCapturadas(0)+"" );
        resultado.add(jodaValidaBrancas+"" );
        resultado.add("" + jodaInvalidaBrancas);
        return resultado;
    }

    public int contarPecasCapturadas(int equipa){
        int capturadas=0;
        for (CrazyPiece captured: capturas){
            if(captured.getIdEquipa()==equipa){
                capturadas++;
            }
        }
        return capturadas;
    }

    public List<CrazyPiece> getCrazyList() {
        return crazyList;
    }

    public int getTurno() {
        return turno;
    }

    public List<CrazyPiece> getCapturas() {
        return capturas;
    }

    public List<String> obterSugestoesJogada(int xO, int yO){
        List<String> listaDeSugestoes = new ArrayList<>();

        for (CrazyPiece crazy: crazyList) {
            if(crazy.coordenadaX == xO && crazy.coordenadaY == yO){
                if(crazy.getIdEquipa() != equipaAJogar){
                    listaDeSugestoes.add("Pedido Invalido");
                    return listaDeSugestoes;
                }
                listaDeSugestoes.add("");//TODO
            }
        }

        listaDeSugestoes.add("Pedido Invalido");
        return listaDeSugestoes;
    }

}
