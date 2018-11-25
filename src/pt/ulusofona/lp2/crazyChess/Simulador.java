package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Simulador {

    //File ficheiroInicial;
    List<CrazyPiece> crazyList = new ArrayList<CrazyPiece>();
    int turno;
    int equipaAJogar;// 0 pretas 1 brancas
    List<CrazyPiece> capturas = new ArrayList<CrazyPiece>();
    List<String> listaDocumentos = new ArrayList<String>();
    List<String> autores = new ArrayList<String>();


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
            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int getTamanhoTabuleiro(){
        return Integer.parseInt(listaDocumentos.get(0));
    }


    public boolean processaJogada(int xO, int yO, int xD, int yD) {
        int tamanhoTabuleiro = Integer.parseInt(listaDocumentos.get(0));
        for (CrazyPiece crazy: crazyList) {
            if (crazy.getCoordenadaX() == xO && crazy.getCoordenadaY() == yO) {
                //bishop
                if (crazy.getIdTipoPeca() == 1 || crazy.getIdTipoPeca() == 7 ) {
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
                if (crazy.getIdTipoPeca() == 2 || crazy.getIdTipoPeca() == 8 ) {
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
                if (crazy.getIdTipoPeca() == 3 || crazy.getIdTipoPeca() == 9 ) {
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
                if (crazy.getIdTipoPeca() == 4 | crazy.getIdTipoPeca() == 10) {
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
                if (crazy.getIdTipoPeca() == 5 | crazy.getIdTipoPeca() == 11) {
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
                if (crazy.getIdTipoPeca() == 6 || crazy.getIdTipoPeca() == 12) {
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
                return crazy.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        return equipaAJogar;
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
