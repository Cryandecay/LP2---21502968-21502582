package pt.ulusofona.lp2.crazyChess;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Simulador   {
    //irá representar a simulação

    Simulador(){
        //A classe Simulador tem de conter (pelo menos) o construtor sem argumentos
    }

    public boolean iniciaJogo(File ficheiroInicial){
        //Deve fazer a leitura do ficheiro de texto e
        //carregar para a memória a informação
        //relevante.

        //Esta função deve devolver true caso a
        //leitura do ficheiro decorra sem problemas,
        //e false em caso contrário.
        return true;
    }

    public int getTamanhoTabuleiro(){
        //Deve devolver o tamanho do tabuleiro,
        //conforme lido do ficheiro respectivo.
        return 0;
    }

    public boolean processaJogada(int xO, int yO, int xD, int Yd){
        //Deve tentar executar uma jogada,
        //considerando que (xO, yO) representa a
        //origem a jogada e (xD, yD) representa o
        //destino da jogada.


        //Caso a jogada seja válida, deve executar a
        //mesma e devolver true . Em caso
        //contrário, deve devolver false .

        return true;
    }


    public boolean jogoTerminado(){
        //Deve devolver true caso já tenha sido
        //alcançada uma das condições de paragem
        //do jogo () e false em caso contrário.

        return true;
    }

    public List<CrazyPiece> getPecasMalucas(){
        //Devolve uma lista com todos os objectos
        //CrazyPiece que existem na simulação.
        List<CrazyPiece> lista=null;
        return lista;
    }

    public List<String> getAutores(){
        //Devolve uma lista de Strings com os
        //nomes dos autores do projecto.

        //Esta informação será usada para mostrar o
        //conteúdo da janela que aparece ao
        //carregar no botão de “Créditos”.
        List<String> autor = null;
        return autor;
    }

    public List<String> getResultados(){
        //Devolve uma lista de Strings que
        //representem os resultados do jogo,
        //conforme descrito na secção dos
        //“Resultados da execução …”.

        //Este método não pode devolver null .
        //Caso não calculem a informação
        //respectiva, devem devolver uma lista
        //vazia .


        List<String> getResultados=null;
        return getResultados;
    }

    public int getIDPeca(int x, int y){
        //Deve devolver o ID da peça que se
        //encontra na posição indicada pelas
        //coordenadas (x,y) passadas por
        //argumento.

        //Caso não exista nenhuma peça na posição
        //indicada, o método deve devolver o valor 0
        //(zero).
        return 0;
    }

    public int getIDEquipaAJogar(){
        //Deve devolver o ID da equipa que está
        //activa no turno actual.
        return 0;
    }


}
