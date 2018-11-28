package pt.ulusofona.lp2.crazyChess;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        String nomeFicheiro = "dados.txt";
        List<List <String>> teste = new ArrayList<List <String>>();
        try {

            File ficheiro = new File(nomeFicheiro);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while(leitorFicheiro.hasNextLine()) {
                List<String> testew = new ArrayList<String>();
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(":");
                testew.addAll(Arrays.asList(dados));
                teste.add(testew);
            }

            System.out.println(teste);
            leitorFicheiro.close();
        }
        catch(FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiro + "nao foi encontrado.";
            System.out.println(mensagem);
        }

    }

    }
