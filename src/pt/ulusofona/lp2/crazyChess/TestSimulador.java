package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestSimulador {
    Simulador simulador = new Simulador();
    @Test
    public void iniciaJogo() {
        File file = new File("random.txt");
        assertEquals(simulador.iniciaJogo(file),false);
    }

    @Test
    public void processaJogada() {
        assertEquals(simulador.processaJogada(0,0,4,4),false);
    }


}