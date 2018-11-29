package pt.ulusofona.lp2.crazyChess;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class TestSimulador {
    Simulador simulador = new Simulador();
    @Test
    void iniciaJogo() {
        File ficheiro = new File("dados.txt");
        assertEquals(simulador.iniciaJogo(ficheiro),true);
    }



    @Test
    void processaJogada() {
        CrazyPiece piece = new CrazyPiece("1","0","0","O Maior",3,2);
        assertEquals(simulador.processaJogada(piece.getCoordenadaX(),piece.coordenadaY,4,3),false);
    }

}