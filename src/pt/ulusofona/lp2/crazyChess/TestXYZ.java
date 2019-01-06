package pt.ulusofona.lp2.crazyChess;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class TestXYZ {
    Simulador simulador = new Simulador();
    @Test
    public void iniciaJogo() {
        File file = new File("test.txt");
        File files = new File("input-crazy-chess-4x4.txt");
        assertEquals(simulador.iniciaJogo(file),false);
        assertEquals(simulador.iniciaJogo(files),true);
    }

    @Test
    public void processaJogada() {
        assertEquals(simulador.processaJogada(0,0,4,4),false);
    }


    @Test
    public void jogadaInvalida() {
        simulador.equipaAJogar = 10;// 10 pretas 20 brancas
        simulador.jodaInvalidaPretas=0;
        simulador.jogadaInvalida();
        int valor = simulador.jodaInvalidaPretas;
        assertEquals(valor,1);
    }

    @Test
    public void getPecasMalucas() {
        simulador.crazyList.add(new Rei("1","1","10","Peca",1,1));
        simulador.capturas.add(new Rei("1","1","20","Peca",1,1));

        assertEquals(simulador.getPecasMalucas().size(),2);
        assertEquals(simulador.getPecasMalucas().get(0).getAlcunha(),simulador.crazyList.get(0).getAlcunha());
    }

    @Test
    public void jogoTerminado() {
        List<CrazyPiece> crazyList = new ArrayList<>();
        simulador.crazyList.add(new Rei("1","0","10","Peca",1,1));
        simulador.crazyList.add(new Rei("2","0","20","Peca",1,0));
        //EMPATE
        assertEquals(simulador.jogoTerminado(),true);
        //CONTINUACAO
        simulador.crazyList.add(new Rei("2","0","20","Peca",1,0));
        assertEquals(simulador.jogoTerminado(),false);
        //DERROTA
        simulador.crazyList.remove(0);
        assertEquals(simulador.jogoTerminado(),true);
    }

    @Test
    public void getAutores() {
        assertEquals(simulador.getAutores().get(0),"André Graça");
        assertEquals(simulador.getAutores().get(1),"João Lionço");
        assertEquals(simulador.getAutores().size(),6);
    }

    @Test
    public void getTamanhoTabuleiro() {
        simulador.tamanhoTabuleiro=4;
        assertEquals(simulador.getTamanhoTabuleiro(),4);
    }

    @Test
    public void getIDPeca() {
        simulador.crazyList.add(new Rei("1","1","10","Peca",1,1));
        simulador.crazyList.add(new Rei("2","1","20","Peca",2,1));
        assertEquals(simulador.getIDPeca(1,1),1);
        assertEquals(simulador.getIDPeca(2,1),2);
        assertEquals(simulador.getIDPeca(2,2),0);
    }

    @Test
    public void getIDEquipaAJogar() {
        simulador.equipaAJogar=10;
        assertEquals(simulador.getIDEquipaAJogar(),10);
    }

    @Test
    public void getResultados() {
        simulador.resultadoFinal="Pretas win";

        assertEquals(simulador.getResultados().get(0),"JOGO DE CRAZY CHESS");
        assertEquals(simulador.getResultados().get(1),"Resultado: Pretas win");
        assertEquals(simulador.getResultados().get(4),"0");
    }

    @Test
    public void contarPecasCapturadas() {
        simulador.capturas.add(new Rei("1","1","10","Peca",1,1));
        assertEquals(simulador.contarPecasCapturadas(20),0);
        assertEquals(simulador.contarPecasCapturadas(10),1);
    }

    @Test
    public void getCrazyList() {
        simulador.crazyList.add(new Rei("1","1","10","Peca",1,1));
        assertEquals(simulador.getCrazyList().size(),1);
        assertEquals(simulador.getCrazyList().get(0).getAlcunha(),"Peca");
    }

    @Test
    public void getTurno() {
        simulador.turno=2;
        assertEquals(simulador.getTurno(),2);
    }

    @Test
    public void getCapturas() {
        simulador.capturas.add(new Rei("1","1","10","Peca",1,1));
        assertEquals(simulador.getCapturas().size(),1);
    }

    @Test
    public void obterSugestoesJogada() {
        simulador.crazyList.add(new Rei("1","0","10","Chefe",1,0));
        simulador.crazyList.add(new Rei("2","0","10","Chefe",2,0));
        simulador.crazyList.add(new Rei("3","0","10","Chefe",2,1));
        simulador.crazyList.add(new Rei("4","0","20","Chefe",1,1));
        simulador.crazyList.add(new Rei("5","0","20","Chefe",0,2));
        simulador.crazyList.add(new Rei("6","0","20","Chefe",2,2));

        //ATENÇÂO
        System.out.println(simulador.crazyList);


        System.out.println(simulador.obterSugestoesJogada(2,2));
        assertEquals(simulador.obterSugestoesJogada(2,2).get(0),"Pedido inválido");

    }

    @Test
    public void anularJogadaAnterior() {
        simulador.crazyList.add(new Rei("1","0","10","Chefe",1,0));
        simulador.crazyList.add(new Rei("2","0","10","Chefe",2,0));
        simulador.crazyList.add(new Rei("3","0","10","Chefe",2,1));
        simulador.crazyList.add(new Rei("4","0","20","Chefe",1,1));
        simulador.crazyList.add(new Rei("5","0","20","Chefe",0,2));
        simulador.crazyList.add(new Rei("6","0","20","Chefe",2,2));
        simulador.processaJogada(1, 0, 0,0);
        simulador.anularJogadaAnterior();
        assertEquals(simulador.getIDPeca(1,0),1);
    }

    @Test
    public void gravarJogo() throws FileNotFoundException, UnsupportedEncodingException {
        PrintWriter writer = new PrintWriter("jogo.txt", "UTF-8");
        File jogo = new File("jogo.txt");
        simulador.tamanhoTabuleiro=4;
        simulador.numeroPecas=6;
        simulador.crazyList.add(new Rei("1","0","10","Chefe",1,0));
        simulador.crazyList.add(new Rei("2","0","10","Chefe",2,0));
        simulador.crazyList.add(new Rei("3","0","10","Chefe",2,1));
        simulador.crazyList.add(new Rei("4","0","20","Chefe",1,1));
        simulador.crazyList.add(new Rei("5","0","20","Chefe",0,2));
        simulador.crazyList.add(new Rei("6","0","20","Chefe",2,2));
        List<CrazyPiece> crazyList = new ArrayList<>();
        crazyList=simulador.crazyList;
        simulador.gravarJogo(jogo);
        simulador.iniciaJogo(jogo);
        assertEquals(simulador.crazyList,crazyList);
    }
}