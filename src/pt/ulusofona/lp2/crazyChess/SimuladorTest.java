package pt.ulusofona.lp2.crazyChess;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class SimuladorTest {

    @Test
    void iniciaJogo() {

    }

    @Test
    void getTamanhoTabuleiro() {
        Simulador simulador = new Simulador();
        List<List <String>> firstRow = new ArrayList<List <String>>();
        try {
            File ficheiro = new File("dados.txt");
            Scanner leitorFicheiro = new Scanner(ficheiro);
            while(leitorFicheiro.hasNextLine()) {
                List<String> testew = new ArrayList<String>();
                String linha = leitorFicheiro.nextLine();
                String dados[] = linha.split(":");
                testew.addAll(Arrays.asList(dados));
                firstRow.add(testew);
            }

        assertEquals(simulador.getTamanhoTabuleiro(), firstRow.get(0).get(0));
    } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}