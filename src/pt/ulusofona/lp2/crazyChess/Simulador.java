package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Simulador {

    File ficheiroInicial;
    List<CrazyPiece> crazyList=new ArrayList<CrazyPiece>();
    int turno=1;

    public Simulador(){

    }

    public List<String> lista(){
        List<String> lista=new ArrayList<>();
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
                    lista.add(dados[i]);
                }
            }
            br.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lista;
    }

    public boolean iniciaJogo(File ficheiroInicial) {
        this.ficheiroInicial=ficheiroInicial;
        if (ficheiroInicial==null){
            return false;
        }else{
            return true;
        }
    }

    public int getTamanhoTabuleiro(){
        List<String> lista= lista();
        return Integer.parseInt(lista.get(0));
    }


    public boolean processaJogada(int xO, int yO, int xD, int Yd) {
        List<String> lista= lista();
        for (int i = 0; i <= crazyList.size(); i++) {
            if (crazyList.get(i).x == xO & crazyList.get(i).y == yO) {
                //bishop
                if (crazyList.get(i).IdTipoPeca == 1 | crazyList.get(i).IdTipoPeca == 7 ) {
                    for (int e = 0; e < Integer.parseInt(lista.get(0)); e++) {
                        if (xD == xO + e & Yd == yO + e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (xD == xO - e & Yd == yO - e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (xD == xO + e & Yd == yO - e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (xD == xO - e & Yd == yO + e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                    }
                    return false;
                }
                //horse
                if (crazyList.get(i).IdTipoPeca == 2 | crazyList.get(i).IdTipoPeca == 8 ) {
                    if (xD == xO + 1 & Yd == yO + 2) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO + 1 & Yd == yO - 2) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO - 1 & Yd == yO - 2) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO - 1 & Yd == yO + 2) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO - 2 & Yd == yO + 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO - 2 & Yd == yO - 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO + 2 & Yd == yO + 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (xD == xO + 2 & Yd == yO - 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    return false;
                }
                //king
                if (crazyList.get(i).IdTipoPeca == 3 | crazyList.get(i).IdTipoPeca == 9 ) {
                    if (xD == xO + 1 & Yd == yO) {
                        crazyList.get(i).x = xD;
                        return true;
                    }
                    if (xD == xO - 1 & Yd == yO) {
                        crazyList.get(i).x = xD;
                        return true;
                    }
                    if (Yd == yO - 1 & xD == xO) {
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO + 1 & xD == xO) {
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO + 1 & xD == xO + 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO + 1 & xD == xO + 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO - 1 & xD == xO + 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO + 1 & xD == xO - 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO - 1 & xD == xO - 1) {
                        crazyList.get(i).x = xD;
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    return false;
                }
                //dama
                if (crazyList.get(i).IdTipoPeca == 4 | crazyList.get(i).IdTipoPeca == 10) {
                    for (int e = 0; e <= Integer.parseInt(lista.get(0)); e++) {
                        if (xD == xO + e & Yd == yO + e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (xD == xO - e & Yd == yO - e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (xD == xO + e & Yd == yO - e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (xD == xO - e & Yd == yO + e) {
                            crazyList.get(i).x = xD;
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (Yd == yO + e & xD == xO) {
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (Yd == yO - e & xD == xO) {
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (Yd == yO & xD == xO+e) {
                            crazyList.get(i).x = xD;
                            return true;
                        }
                        if (Yd == yO & xD == xO-e) {
                            crazyList.get(i).x = xD;
                            return true;
                        }

                    }
                    return false;
                }
                //tower
                if (crazyList.get(i).IdTipoPeca == 5 | crazyList.get(i).IdTipoPeca == 11) {
                    for (int e = 0; e <= Integer.parseInt(lista.get(0)); e++) {
                        if (Yd == yO + e & xD == xO) {
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (Yd == yO - e & xD == xO) {
                            crazyList.get(i).y = Yd;
                            return true;
                        }
                        if (Yd == yO & xD == xO+e) {
                            crazyList.get(i).x = xD;
                            return true;
                        }
                        if (Yd == yO & xD == xO-e) {
                            crazyList.get(i).x = xD;
                            return true;
                        }

                    }
                    return false;
                }
                //peon
                if (crazyList.get(i).IdTipoPeca == 6 | crazyList.get(i).IdTipoPeca == 12) {
                    if (Yd == yO + 1 & xD == xO) {
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    if (Yd == yO - 1 & xD == xO) {
                        crazyList.get(i).y = Yd;
                        return true;
                    }
                    return false;
                }
            }
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){
        List<String> lista= lista();
        CrazyPiece KingWhite = new CrazyPiece();
        CrazyPiece KingBlack = new CrazyPiece();
        Random rando = new Random();
        //THERE MUST ALWAYS BE A CHESS KING
        KingWhite.IdPeca=0;
        KingWhite.IdEquipa=0;
        KingWhite.IdTipoPeca=3;
        KingWhite.Alcunha="Ferrari";
        KingWhite.x= rando.nextInt(Integer.parseInt(lista.get(0)));
        KingWhite.y= rando.nextInt(Integer.parseInt(lista.get(0)));
        crazyList.add(KingWhite);
        KingBlack.IdPeca=1;
        KingBlack.IdEquipa=0;
        KingBlack.IdTipoPeca=9;
        KingBlack.Alcunha="Ferrari";
        KingBlack.x= rando.nextInt(Integer.parseInt(lista.get(0)));
        KingBlack.y= rando.nextInt(Integer.parseInt(lista.get(0)));
        crazyList.add(KingBlack);

        for(int i=2;i<=Integer.parseInt(lista.get(1));i++){
            CrazyPiece piece1 = new CrazyPiece();
            Random rand = new Random();
            if(i<Integer.parseInt(lista.get(1))/2+1){
                piece1.IdPeca=i;
                piece1.IdEquipa=0;
                piece1.IdTipoPeca=rand.nextInt(5)+1;
                piece1.Alcunha="Ferrari";
                piece1.x= rand.nextInt(Integer.parseInt(lista.get(0)));
                piece1.y= rand.nextInt(Integer.parseInt(lista.get(0)));
                crazyList.add(piece1);
            }else{
                piece1.IdPeca=i;
                piece1.IdEquipa=1;
                piece1.IdTipoPeca=rand.nextInt(5)+6;
                piece1.Alcunha="Ferrari";
                piece1.x= rand.nextInt(Integer.parseInt(lista.get(0)));
                piece1.y= rand.nextInt(Integer.parseInt(lista.get(0)));
                crazyList.add(piece1);
            }
        }


        return crazyList;
    }

    public boolean jogoTerminado(){
        for(int i=0;i<crazyList.size();i++){
            if(crazyList.get(i).IdTipoPeca == 3 & crazyList.get(i).captured == true){
                return true;
            }
        }
        return false;
    }

    public List<String> getAutores(){
        List<String> autores = new ArrayList<String>();
        autores.add("André Graça");
        autores.add("João Lionço");
        return autores;
    }


    public int getIDPeca(int x, int y) {
        for(int i=0; i<crazyList.size();i++){
            if(crazyList.get(i).getId()==i){
                if (x == crazyList.get(i).x & y == crazyList.get(i).y) {
                    if(crazyList.get(i).captured==false){
                        return crazyList.get(i).getId();
                    }else{
                        return 0;
                    }

                }
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        if (turno==0){
            turno=1;
            return 0;
        }else{
            turno=0;
            return 1;
        }

    }

    public String getResultados(){
     return "qa";
    }
}
