package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulador {

    //File ficheiroInicial;
    List<CrazyPiece> crazyList = new ArrayList<CrazyPiece>();
    int turno;
    int equipaAJogar;// 0 pretas 1 brancas
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
            BufferedReader br = new BufferedReader(new FileReader(ficheiroInicial.toString()));
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
            for(int i=2; i<listaDocumentos.size();i++){
                if (i == 2) {
                        String dado[] = listaDocumentos.get(i).split(":");
                        int[] random = new int[2];
                        random = randomXeY();
                        CrazyPiece piece = new CrazyPiece(dado[0], dado[1], dado[2], dado[3], random[0], random[1]);
                        crazyList.add(piece);
                } else {
                        String dado[] = listaDocumentos.get(i).split(":");
                        int[] random = new int[2];
                        random = randomXeYComparation();
                        CrazyPiece piece = new CrazyPiece(dado[0], dado[1], dado[2], dado[3], random[0], random[1]);
                        crazyList.add(piece);

                }

            }
            System.out.println(crazyList);
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }catch(NumberFormatException ex) { // handle your exception
            return false;
        }

    }





    public int numberInt(String number){
            return Integer.parseInt(number);
    }

    public int[] randomXeYComparation(){
        Random rand = new Random();
        int[] random = new int[2];
        random[0]= rand.nextInt(tamanhoTabuleiro);
        random[1]= rand.nextInt(tamanhoTabuleiro);
        while  (true){
            for(CrazyPiece crazy: crazyList){
                if(random[0] == crazy.getCoordenadaX() && random[1] == crazy.getCoordenadaY()){
                    random[0]= rand.nextInt(tamanhoTabuleiro);
                    random[1]= rand.nextInt(tamanhoTabuleiro);
                }else{
                    return random;
                }
            }
        }
    }

    public int[] randomXeY(){
        Random rand = new Random();
        int[] random = new int[2];
        random[0]= rand.nextInt(tamanhoTabuleiro);
        random[1]= rand.nextInt(tamanhoTabuleiro);
        return random;
    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }


    public boolean processaJogada(int xO, int yO, int xD, int yD) {
        for (CrazyPiece crazy: crazyList) {
            if (crazy.getCoordenadaX() == xO && crazy.getCoordenadaY() == yO) {
                //bishop
                if (crazy.getIdTipoPeca() == 0 || crazy.getIdTipoPeca() == 6 ) {
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
                if (crazy.getIdTipoPeca() == 2 || crazy.getIdTipoPeca() == 8 ) {
                    if (xD == xO + 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        crazy.setCoordenadaX(xD);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
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
        for(CrazyPiece crazy: crazyList){
            if(crazy.getIdPeca() == 3){
                return false;
            }
            else{
                return false;
            }
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
