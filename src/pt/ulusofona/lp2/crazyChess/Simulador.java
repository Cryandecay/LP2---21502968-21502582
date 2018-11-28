package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Simulador {

    //File ficheiroInicial;
    List<CrazyPiece> crazyList = new ArrayList<CrazyPiece>();
    int turnoCaptura=0; //contador dos turnos sem captura
    int turno=0; //Turnos do jogo
    int turnoAnterior=0; //contador do turno anterior serve para evitar que jogadas invalidas contem como turno
    int equipaAJogar=0;// 0 pretas 1 brancas
    int jodaInvalidaBrancas =0;
    int jodaInvalidaPretas =0;
    int jodaValidaBrancas =0;
    int jodaValidaPretas =0;
    int tamanhoTabuleiro;
    int numeroPecas;
    String resultadoFinal;
    List<CrazyPiece> capturas = new ArrayList<CrazyPiece>();
    List<String> autores = new ArrayList<String>();
    List<String> resultado = new ArrayList<String>();


    public Simulador(){

    }

    public Simulador(List<CrazyPiece> crazyList, int turno, int equipaAJogar, List<CrazyPiece> capturas) {
        //this.ficheiroInicial = ficheiroInicial;
        this.crazyList = crazyList;
        this.turno = turno;
        this.equipaAJogar = equipaAJogar;
        this.capturas = capturas;
    }


    public boolean iniciaJogo(File ficheiroInicial) {
            List<List <String>> teste = new ArrayList<List <String>>();
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
                    teste.add(testew);
                }
                leitorFicheiro.close();
                tamanhoTabuleiro=Integer.parseInt(teste.get(0).get(0));
                numeroPecas=Integer.parseInt(teste.get(1).get(0));
                for(int i=2;i<numeroPecas+2;i++){
                    pecas.add(teste.get(i));
                }
                for(int i=2+numeroPecas;i<teste.size();i++){
                    mapas.add(teste.get(i));
                }
                stringTest(pecas, mapas);
                System.out.println(crazyList);
                return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }

    }

    public int numberInt(String number){
            return Integer.parseInt(number);
    }

    void findCapture(int x, int y, int iD){
        turno=turno+1;
        turnoCaptura=turnoCaptura+1;
        for(CrazyPiece crazy: crazyList){
            if(crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y ){
                if(crazy.getId()!=iD && crazy.getId()!=0){
                    capturas.add(crazy);
                    turnoCaptura=0;
                }
            }
        }
        removeCrazyList();
    }

    void removeCrazyList(){
        for(CrazyPiece captured: capturas){
                crazyList.remove(captured);
            }
        }






    void stringTest(List<List<String>> peca, List<List <String>> mapas){
        for(int i=0; i< peca.size();i++) {
            for (int e = 0; e < mapas.size(); e++) {
                for (int u = 0; u < mapas.get(e).size(); u++) {
                    if (mapas.get(e).get(u).equals(peca.get(i).get(0))) {
                        if(peca.get(i).get(2).equals("0")){
                            //peca.get(i).get(0) = id
                            //peca.get(i).get(1) = tipoPecas
                            //peca.get(i).get(2) = equipas
                            //peca.get(i).get(3) = alcunhas
                            //coordenadaX= u;
                            //coordenadaY= e;
                            CrazyPiece piece = new CrazyPiece(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e);
                            crazyList.add(piece);
                        }else{
                            CrazyPiece piece = new CrazyPiece(peca.get(i).get(0),peca.get(i).get(1), peca.get(i).get(2) , peca.get(i).get(3), u, e);
                            crazyList.add(piece);
                        }
                    }
                }

            }
        }
    }


    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }



    public boolean processaJogada(int xO, int yO, int xD, int yD) {
        for (CrazyPiece crazy: crazyList) {
            if (crazy.getCoordenadaX() == xO && crazy.getCoordenadaY() == yO) {
                //bishop
                if (crazy.getIdTipoPeca() == 2 || crazy.getIdTipoPeca() == 8 ) {
                    for (int e = 0; e < tamanhoTabuleiro; e++) {
                        if (xD == xO + e && yD == yO + e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            return true;
                        }
                        if (xD == xO - e && yD == yO - e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            return true;
                        }
                        if (xD == xO + e && yD == yO - e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            return true;
                        }
                        if (xD == xO - e && yD == yO + e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            return true;
                        }
                    }
                    return false;
                }
                //horse
                if (crazy.getIdTipoPeca() == 1 || crazy.getIdTipoPeca() == 7 ) {
                    if (xD == xO + 1 && yD == yO + 2) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (xD == xO + 1 && yD == yO - 2) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);;
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO - 2) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO + 2) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (xD == xO - 2 && yD == yO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (xD == xO - 2 && yD == yO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (xD == xO + 2 && yD == yO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (xD == xO + 2 && yD == yO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    return false;
                }
                //king

                if (crazy.getIdTipoPeca() == 0 && equipaAJogar==1 ) {
                    if (xD == xO + 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaBrancas++;
                        return true;
                    }
                    jodaInvalidaBrancas++;
                    return false;
                }

                if (crazy.getIdTipoPeca() == 6 && equipaAJogar==0 ) {
                    if (xD == xO + 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        jodaValidaPretas++;
                        return true;
                    }
                    jodaInvalidaPretas++;
                    return false;
                }

                //dama
                if (crazy.getIdTipoPeca() == 3 | crazy.getIdTipoPeca() == 9) {
                    for (int e = 0; e <= tamanhoTabuleiro; e++) {
                        if (xD == xO + e && yD == yO + e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (xD == xO - e && yD == yO - e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (xD == xO + e && yD == yO - e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (xD == xO - e && yD == yO + e) {
                            crazy.setCoordenadaX(xD);
                            crazy.setCoordenadaY(yD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (yD == yO + e && xD == xO) {
                            crazy.setCoordenadaY(yD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (yD == yO - e && xD == xO) {
                            crazy.setCoordenadaY(yD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (yD == yO && xD == xO + e) {
                            crazy.setCoordenadaX(xD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }
                        if (yD == yO && xD == xO - e) {
                            crazy.setCoordenadaX(xD);
                            findCapture(xD, yD,crazy.idPeca);
                            return true;
                        }

                    }
                    return false;
                }
                //tower
                if (crazy.getIdTipoPeca() == 4 | crazy.getIdTipoPeca() == 10) {
                    for (int e = 0; e <= tamanhoTabuleiro; e++) {
                        if (yD == yO + e && xD == xO) {
                            crazy.setCoordenadaY(yD);
                            return true;
                        }
                        if (yD == yO - e && xD == xO) {
                            crazy.setCoordenadaY(yD);
                            return true;
                        }
                        if (yD == yO && xD == xO + e) {
                            crazy.setCoordenadaX(xD);
                            return true;
                        }
                        if (yD == yO && xD == xO - e) {
                            crazy.setCoordenadaX(xD);
                            return true;
                        }

                    }
                    return false;
                }
                //peon
                if (crazy.getIdTipoPeca() == 5 || crazy.getIdTipoPeca() == 11) {
                    if (yD == yO + 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
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
            if(crazy.getIdEquipa()==0 && crazy.getIdTipoPeca()==6){
                blackKing.add(crazy);
            }
            if(crazy.getIdEquipa()==1 && crazy.getIdTipoPeca()==0){
                whiteKing.add(crazy);
            }
        }
        if (blackKing.size()==1 && whiteKing.size()==1){
            resultadoFinal="EMPATE 1 KING EACH";
            return true;
        }
        if (blackKing.size()==0){
            resultadoFinal="WHITE PIECES WIN";
            return true;
        }
        if (whiteKing.size()==0){
            resultadoFinal="BLACK PIECES WIN";
            return true;
        }
        if(turnoCaptura==10){
            resultadoFinal="EMPATE 10 TURNS WHIT NO CAPTURE";
            return true;
        }
        return false;
    }

    public List<String> getAutores(){
        autores.add("André Graça");
        autores.add("João Lionço");
        return autores;
    }


    public int getIDPeca(int x, int y) {
        for(CrazyPiece crazy: crazyList){
            if(crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y){
                return crazy.getIdPeca();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        if (equipaAJogar==0 && turno!=turnoAnterior){
            equipaAJogar=1;
            turnoAnterior=turno;
            return 1;
        }
        if (equipaAJogar==1 && turno!=turnoAnterior){
            equipaAJogar=0;
            turnoAnterior=turno;
            return 0;
        }
        return equipaAJogar;
    }

    public List<String> getResultados(){
        resultado.add("JOGO DE CRAZY CHESS");
        resultado.add("Resultado: " + resultadoFinal );
        resultado.add( "---" );
        resultado.add("Equipa das Pretas\n");
        resultado.add("<NR CAPTURAS> " + contarPecasCapturadas(1));
        resultado.add("<NR JOGADAS VALIDAS> " + jodaValidaPretas);
        resultado.add("<NR INVALIDAS>\n" + jodaInvalidaPretas);
        resultado.add("Equipa das Brancas\n");
        resultado.add("<NR CAPTURAS> " + contarPecasCapturadas(0));
        resultado.add("<NR VALIDAS> " + jodaValidaBrancas);
        resultado.add("<NR INVALIDAS>" + jodaInvalidaBrancas);
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

}
