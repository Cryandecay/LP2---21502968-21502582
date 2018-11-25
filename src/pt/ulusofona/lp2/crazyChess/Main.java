package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public Main(){
        ArrayList<CrazyPiece> listaTeste = new ArrayList<CrazyPiece>();
        ArrayList<CrazyPiece> listaTesteVazia = new ArrayList<CrazyPiece>();
        CrazyPiece WhiteKing = new CrazyPiece(0,0);
        listaTeste.add(WhiteKing);
        Simulador sumular = new Simulador(listaTeste,0,0,listaTesteVazia);
    }
}
