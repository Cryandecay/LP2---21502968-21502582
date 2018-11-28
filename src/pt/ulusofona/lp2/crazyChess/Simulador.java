package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Simulador {

    //File ficheiroInicial;
    List<CrazyPiece> crazyList = new ArrayList<CrazyPiece>();
    int turnoCaptura=0; //contador dos turnos sem captura
    int turno=0; //Turnos do jogo
    int turnoAnterior=0; //contador do turno anterior serve para evitar que jogadas invalidas contem como turno
    int equipaAJogar=0;// 0 pretas 1 brancas
    int tamanhoTabuleiro;
    int numeroPecas;
    List<CrazyPiece> capturas = new ArrayList<CrazyPiece>();
    List<String> listaDocumentos = new ArrayList<String>();
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
        try {
            BufferedReader br = new BufferedReader(new FileReader(ficheiroInicial));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
            String everything = sb.toString();
            String dados[] = everything.split("[\n\r]");
            for(int i = 0; i < dados.length; ++i) {
                if((i%2)==0){
                    listaDocumentos.add(dados[i]);
                }
            }
            br.close();
            tamanhoTabuleiro = numberInt(listaDocumentos.get(0));
            numeroPecas = numberInt(listaDocumentos.get(1));
            if(listaDocumentos.size()!=(tamanhoTabuleiro+numeroPecas+2)){
                return false;
            }
            List<List<String>> listaMapa = new ArrayList<>();
            for(int i=2+numeroPecas; i<listaDocumentos.size();i++) {
                List<String> save = new ArrayList<String>();
                String linha[]=listaDocumentos.get(i).split(":");
                for(int e=0; e<linha.length;e++ ){
                    save.add(linha[e]);
                }
                listaMapa.add(save);
            }
            for(int i=2; i<=listaDocumentos.size()-1;i++){
                        String dado[] = listaDocumentos.get(i).split(":");
                        stringTest(listaMapa,dado);
            }
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
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






    void stringTest(List<List<String>> listaMapa, String dado[]){
        List<Integer> stringTest = new ArrayList<Integer>();
        for(int i=0;i<listaMapa.size();i++){
            for(int e=0;e<listaMapa.get(i).size();e++){
                if(listaMapa.get(i).get(e).equals(dado[0])){
                    if(crazyList.size()<numeroPecas){
                        if (dado[2].equals("0")){
                            CrazyPiece piece = new CrazyPiece(dado[0],dado[2],dado[1]+6, dado[3], e, i);
                            crazyList.add(piece);
                        }else{
                            CrazyPiece piece = new CrazyPiece(dado[0],dado[2],dado[1], dado[3], e, i);
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
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    return false;
                }

                if (crazy.getIdTipoPeca() == 6 && equipaAJogar==0 ) {
                    if (xD == xO + 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.idPeca);
                        return true;
                    }
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
            System.out.println("EMPATE 1 KING EACH");
            return true;
        }
        if (blackKing.size()==0){
            System.out.println("WHITE PIECES WIN");
            return true;
        }
        if (whiteKing.size()==0){
            System.out.println("BLACK PIECES WIN");
            return true;
        }
        if(turnoCaptura==4){
            System.out.println("EMPATE 10 TURNS WHIT NO CAPTURE");
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
        return resultado;
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
