package pt.ulusofona.lp2.crazyChess;


import org.junit.Test;

import java.io.File;

import static junit.framework.TestCase.assertTrue;

public class Main {
    public static void main(String[] args) {



            Simulador simulador = new Simulador();

            System.out.println(simulador.iniciaJogo(new File("input-crazy-chess-4x4.txt")));


    }
}