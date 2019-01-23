package pt.ulusofona.lp2.crazyChess;

import java.io.IOException;

public class InvalidSimulatorInputException extends IOException {
    private int  linhaErro;
    private static int numeroTotal;
    private static int numeroEsperado;

    public InvalidSimulatorInputException(int linhaErro) {
        this.linhaErro = linhaErro;
    }

    public InvalidSimulatorInputException(int numeroTotal, int numerEsperado) {
        this.numeroTotal= numeroTotal;
        this.numeroEsperado = numerEsperado;
    }

    public int getLinhaErro() {
        return linhaErro;
    }

    public String getDescricaoProblema(){
        if (numeroTotal > numeroEsperado){
            return "DADOS A MAIS (Esperava: " + numeroEsperado +" ; Obtive: " + numeroTotal +" )";
        } else {
            return "DADOS A MENOS (Esperava: " + numeroEsperado +" ; Obtive: " + numeroTotal +" )";
        }
    }



}