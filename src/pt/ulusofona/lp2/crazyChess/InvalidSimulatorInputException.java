package pt.ulusofona.lp2.crazyChess;

import java.io.IOException;

    class InvalidSimulatorInputException extends IOException {
    private int  linhaErro;
    InvalidSimulatorInputException(int linhaErro) {
        this.linhaErro = linhaErro;
    }
    int getLinhaErro() {
        return linhaErro;
    }

    public String getDescricaoProblema(){
        return "DADOS A MAIS (Esperava: x ; Obtive: y )";
    }


}
