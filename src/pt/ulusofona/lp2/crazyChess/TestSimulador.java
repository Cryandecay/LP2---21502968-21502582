package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;

import static org.junit.Assert.*;

public class TestSimulador {
    Simulador simulador = new Simulador();
    @Test
    public void iniciaJogo() {
        File file = new File("dados.txt");
        assertEquals(simulador.iniciaJogo(file),true);
    }
}