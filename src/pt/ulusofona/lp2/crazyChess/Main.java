package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main(){
        File file = new File("dados.txt");
        Simulador simulador = new Simulador();
        simulador.iniciaJogo(file);
    }
}
