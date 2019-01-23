package pt.ulusofona.lp2.crazyChess;

import java.io.*;
import java.util.*;


public class Simulador {

    int numeroDeJogadas;
    List<Integer> memPeca = new ArrayList<Integer>();
    List<CrazyPiece> crazyList = new ArrayList<>();
    List<CrazyPiece> capturas = new ArrayList<>();
    List<CrazyPiece> listaDeJokers = new ArrayList<>();
    int turnoCaptura = 0; //contador dos turnos sem captura
    int turno = 0; //Turnos do jogo
    int equipaAJogar = 10;// 10 pretas 20 brancas
    Integer jodaInvalidaBrancas = 0;
    Integer jodaInvalidaPretas = 0;
    int jodaValidaBrancas = 0 ;
    int jodaValidaPretas = 0;
    int tamanhoTabuleiro = 0;
    int numeroPecas = 0;
    String resultadoFinal;
    List<String> autores = new ArrayList<>();


    public Simulador(){ }

    public Simulador(List<CrazyPiece> crazyList, int turno, int equipaAJogar, List<CrazyPiece> capturas) {
        //this.ficheiroInicial = ficheiroInicial;
        this.crazyList = crazyList;
        this.turno = turno;
        this.equipaAJogar = equipaAJogar;
        this.capturas = capturas;
    }

      public void iniciaJogo(File ficheiroInicial) throws InvalidSimulatorInputException, IOException{

            List<List <String>> firstRow = new ArrayList<List <String>>();
            List<List <String>> mapas = new ArrayList<List <String>>();
            List<List <String>> pecas = new ArrayList<List <String>>();
            try {

                File ficheiro = new File(ficheiroInicial.getName());
                Scanner leitorFicheiro = new Scanner(ficheiro);

                while (leitorFicheiro.hasNextLine()) {
                    List<String> testew = new ArrayList<String>();
                    String linha = leitorFicheiro.nextLine();
                    String dados[] = linha.split(":");
                    testew.addAll(Arrays.asList(dados));
                    firstRow.add(testew);
                }
                leitorFicheiro.close();

                tamanhoTabuleiro = Integer.parseInt(firstRow.get(0).get(0));
                numeroPecas = Integer.parseInt(firstRow.get(1).get(0));

                if (firstRow.size()>tamanhoTabuleiro+numeroPecas+3){
                    throw new InvalidSimulatorInputException(firstRow.size(), tamanhoTabuleiro+numeroPecas+2);
                }
                if (firstRow.size()<tamanhoTabuleiro+numeroPecas+1){
                    throw new InvalidSimulatorInputException(firstRow.size(), tamanhoTabuleiro+numeroPecas+2);
                }

                if (firstRow.size() == tamanhoTabuleiro + numeroPecas + 1) {
                    for (int e = 0; e < Integer.parseInt(firstRow.get(tamanhoTabuleiro + numeroPecas + 2).get(0)); e++){
                            linhaDeErro = e;
                            capturas.add(new Rei("0", "0", "10", "Dummie", 2, 1));

                    }
                    jodaValidaPretas = Integer.parseInt(firstRow.get(tamanhoTabuleiro + numeroPecas + 2).get(1));
                    jodaInvalidaPretas = Integer.parseInt(firstRow.get(tamanhoTabuleiro + numeroPecas + 2).get(2));
                    for (int e = 0; e < Integer.parseInt(firstRow.get(tamanhoTabuleiro + numeroPecas + 2).get(3)); e++) {
                        linhaDeErro = e;
                        capturas.add(new Rei("0", "0", "20", "Dummie", 2, 1));
                    }
                    jodaValidaPretas = Integer.parseInt(firstRow.get(tamanhoTabuleiro + numeroPecas + 2).get(4));
                    jodaInvalidaBrancas = Integer.parseInt(firstRow.get(tamanhoTabuleiro + numeroPecas + 2).get(5));
                    firstRow.remove(tamanhoTabuleiro + numeroPecas + 2);
                }

                for (int i = 2; i < numeroPecas + 2; i++) {
                    pecas.add(firstRow.get(i));
                }
                for (int i = 2 + numeroPecas; i < firstRow.size(); i++) {
                    mapas.add(firstRow.get(i));
                }

                stringTest(pecas, mapas);

                if (crazyList.size() != numeroPecas) {
                    for (int i = 0; i < numeroPecas - crazyList.size() + 1; i++) {
                        crazyList.add(new Rei(0, 0, 10, "0", -1, -1));
                    }
                }

        } catch (FileNotFoundException e) {
            throw new IOException();
        }catch (IOException ex){
                throw new InvalidSimulatorInputException(getLinhaErro());
            }


    }
    
    void stringTest(List<List<String>> peca, List<List <String>> mapas){
        for(int i=0; i< peca.size();i++) {
            for (int e = 0; e < mapas.size(); e++) {
                for (int u = 0; u < mapas.get(e).size(); u++) {
                    if (mapas.get(e).get(u).equals(peca.get(i).get(0))) {
                        //peca.get(i).get(0) = id
                        //peca.get(i).get(1) = tipoPecas
                        //peca.get(i).get(2) = equipas
                        //peca.get(i).get(3) = alcunhas
                        //coordenadaX= u;
                        //coordenadaY= e;

                        if(peca.get(i).get(1).equals("0")) {//Rei
                            crazyList.add(new Rei(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("1")) {//Rainha
                            crazyList.add(new Rainha(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("2")) {//PoneiMagico
                            crazyList.add(new PoneiMagico(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("3")){//PadreDaVila
                            crazyList.add(new PadreDaVila(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("4")){//TorreH
                            crazyList.add(new TorreH(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("5")){//TorreV
                            crazyList.add(new TowerV(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("6")){//Lebre
                            crazyList.add(new Lebre(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));

                        } else if(peca.get(i).get(1).equals("7")){//Joker
                            crazyList.add(new Joker(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));
                            listaDeJokers.add(new Joker(peca.get(i).get(0),peca.get(i).get(1) , peca.get(i).get(2), peca.get(i).get(3), u, e));
                        }
                    }
                }
            }
        }
    }

    void jogadaInvalida(CrazyPiece crazy){

        crazy.adicionaJogadaInvalidaPeca();

        if(equipaAJogar == 10){
            jodaInvalidaPretas++;
        } else {
            jodaInvalidaBrancas++;
        }
    }

    void atualizaJoker(CrazyPiece joker){

        int contador = 0;
        int multiploDe5 = 0;
        while(contador != turno){

            if (contador % 5 == 0 && contador != 0){
                multiploDe5 = multiploDe5 + 5;
            }

            contador++;
        }

        if (turno - multiploDe5 == 0){//Rainha
            joker.setIdTipoPeca(1);
            joker.setTipoeDePeca("Joker/Rainha");
        }

        if (turno - multiploDe5 == 1){//Ponei Magico
            joker.setIdTipoPeca(2);
            joker.setTipoeDePeca("Joker/Magico");
        }

        if (turno - multiploDe5 == 2){//Padre da Vila
            joker.setIdTipoPeca(3);
            joker.setTipoeDePeca("Joker/Padre da Vila");
        }

        if (turno - multiploDe5 == 3){//TorreH
            joker.setIdTipoPeca(4);
            joker.setTipoeDePeca("Joker/TorreH");
        }

        if (turno - multiploDe5 == 4){//TorreV
            joker.setIdTipoPeca(5);
            joker.setTipoeDePeca("Joker/TorreV");
        }

        if (turno - multiploDe5 == 5){//Lebre
            joker.setIdTipoPeca(6);
            joker.setTipoeDePeca("Joker/Lebre");
        }

    }

    public boolean processaJogada(int xO, int yO, int xD, int yD) {
        Estatisticas estatisticas = new Estatisticas(turnoCaptura, turno, equipaAJogar);

        for (CrazyPiece crazy: crazyList){
            for (CrazyPiece joker: listaDeJokers){
                if (joker.getId() == crazy.getId()){
                    atualizaJoker(crazy);
                }
            }
        }

        numeroDeJogadas++;

        for (CrazyPiece crazy: crazyList) {

            if(xO == xD && yO == yD){
                jogadaInvalida(crazy);
                return false;
            }
            if(xD < 0 || yD < 0){
                jogadaInvalida(crazy);
                return false;
            }
            if(xD > tamanhoTabuleiro || yD > tamanhoTabuleiro){
                jogadaInvalida(crazy);
                return false;
            }

            crazy.setCrayList(crazyList);
            crazy.setCapturas(capturas);
            crazy.setEstatisticas(estatisticas);

             if (crazy.getCoordenadaX() == xO && crazy.getCoordenadaY() == yO) {
                 if(equipaAJogar == crazy.getIdEquipa()) {
                     memPeca.clear();
                     memPeca.add(crazy.getId());
                     memPeca.add(xO);
                     memPeca.add(yO);

                     if (equipaAJogar == 10){
                         equipaAJogar = 20;
                         jodaValidaPretas++;
                     } else {
                         equipaAJogar = 10;
                         jodaValidaBrancas++;
                     }

                     turno = crazy.getEstatisticas().getTurno();
                     turnoCaptura = crazy.getEstatisticas().getTurnoCaptura();
                     capturas = crazy.getCapturas();
                     crazyList = crazy.getCrazyList();

                     crazy.adicionaJogadaValidaPeca();
                     return crazy.movimento(xO, yO, xD, yD, crazy);
                 } else {
                     jogadaInvalida(crazy);
                     return false;
                 }
             }
        }
        return false;
    }

    public List<CrazyPiece> getPecasMalucas(){
        List<CrazyPiece> merged = new ArrayList<>();
        merged.addAll(crazyList);
        merged.addAll(capturas);

        return merged;
    }

    public boolean jogoTerminado(){
        List<CrazyPiece> whiteKing = new ArrayList<CrazyPiece>();
        List<CrazyPiece> blackKing = new ArrayList<CrazyPiece>();

        for(CrazyPiece crazy: crazyList){
            if(crazy.getIdEquipa() == 10 && crazy.getIdTipoPeca() == 0){
                blackKing.add(crazy);
            }
            if(crazy.getIdEquipa() == 20 && crazy.getIdTipoPeca() == 0){
                whiteKing.add(crazy);
            }
        }
        if (blackKing.size() == 1 && whiteKing.size() == 1 && crazyList.size() == 2){
            resultadoFinal="EMPATE";
            return true;
        }
        if (blackKing.size() == 0){
            resultadoFinal="VENCERAM AS BRANCAS";
            return true;
        }
        if (whiteKing.size() == 0){
            resultadoFinal="VENCERAM AS PRETAS";
            return true;
        }
        if(turnoCaptura == 10 && capturas.size() >= 1){
            resultadoFinal = "EMPATE";
            return true;
        }
        return false;
    }

    public List<String> getAutores(){
        autores.add("André Graça/21502968");
        autores.add("João Lionço/21502583");
        return autores;
    }

    public int getTamanhoTabuleiro(){
        return tamanhoTabuleiro;
    }

    public int getIDPeca(int x, int y) {
        for(CrazyPiece crazy: crazyList){
            if(crazy.getCoordenadaX() == x && crazy.getCoordenadaY() == y){
                return crazy.getId();
            }
        }
        return 0;
    }

    public int getIDEquipaAJogar(){
        return equipaAJogar;
    }

    public List<String> getResultados(){//TODO:No Clue
        List<String> resultado = new ArrayList<String>();

        resultado.add("JOGO DE CRAZY CHESS");
        resultado.add("Resultado: " + resultadoFinal );
        resultado.add( "---" );
        resultado.add("Equipa das Pretas");
        resultado.add(contarPecasCapturadas(10)+"");
        resultado.add(jodaValidaPretas+"");
        resultado.add(jodaInvalidaPretas+"");
        resultado.add("Equipa das Brancas");
        resultado.add( contarPecasCapturadas(20)+"" );
        resultado.add(jodaValidaBrancas+"" );
        resultado.add("" + jodaInvalidaBrancas);

        return resultado;
    }

    public int contarPecasCapturadas(int equipa){
        int capturadas = 0;
        for (CrazyPiece captured: capturas){
            if(captured.getIdEquipa() == equipa){
                capturadas++;
            }
        }
        return capturadas;
    }

    public List<CrazyPiece> getCrazyList() {
        return crazyList;
    }

    public int getTurno() {
        return turno;
    }

    public List<CrazyPiece> getCapturas() {
        return capturas;
    }

    public List<Comparable> obterSugestoesJogada(int xO, int yO){ //TODO: isto ta mal
        List<Comparable> listaDeSugestoes = new ArrayList<>();
        Estatisticas estatisticas = new Estatisticas(turnoCaptura, turno, equipaAJogar);
        String equipaNaoAtiva = "Pedido inválido";

        for (CrazyPiece aCrazyList : crazyList) {
            if (aCrazyList.getCoordenadaX() == xO && aCrazyList.getCoordenadaY() == yO) {

                if (equipaAJogar != aCrazyList.getIdEquipa()) {
                    listaDeSugestoes.add(equipaNaoAtiva);
                    return listaDeSugestoes;
                }
                aCrazyList.setCrayList(crazyList);
                aCrazyList.setCapturas(capturas);
                aCrazyList.setEstatisticas(estatisticas);

                for (int linhaX = 0; linhaX < getTamanhoTabuleiro(); linhaX++) {
                    for (int colunaY = 0; colunaY < getTamanhoTabuleiro(); colunaY++) {
                        if (aCrazyList.movimentoPrevisao(xO, yO, linhaX, colunaY, aCrazyList)) {
                            listaDeSugestoes.add(linhaX + ", " + colunaY);
                        }
                    }
                }
                return listaDeSugestoes;
            }
        }

        listaDeSugestoes.add(equipaNaoAtiva);
        return listaDeSugestoes;
    }

    public void anularJogadaAnterior(){//TODO:funciona?
        for (int i=0;i<crazyList.size();i++){
            if (memPeca.get(0)==crazyList.get(i).getId()){
                for (int a=0;a<capturas.size();a++){
                    if(capturas.get(a).getCoordenadaX()==crazyList.get(i).getCoordenadaX() && capturas.get(a).getCoordenadaY()==crazyList.get(i).getCoordenadaY()){
                        crazyList.add(capturas.get(a));
                        getIDPeca( capturas.get(a).getCoordenadaX(), capturas.get(a).getCoordenadaY());
                        capturas.remove(a);
                    }
                }
                crazyList.get(i).setCoordenadaX(memPeca.get(1));
                crazyList.get(i).setCoordenadaY(memPeca.get(2));
                getIDPeca( crazyList.get(i).getCoordenadaX(), crazyList.get(i).getCoordenadaY());
            }
        }

        if (equipaAJogar == 10){
            equipaAJogar = 20;
        } else {
            equipaAJogar = 10;
        }

        turno--;

    }

    public boolean gravarJogo(File ficheiroDestino){//TODO:??
        String newLine = System.getProperty( "line.separator" );
        try {
            File output = new File( ficheiroDestino.getName() );
            FileWriter writer = new FileWriter(output);
            writer.write(String.valueOf(getTamanhoTabuleiro()));
            writer.write(newLine);
            writer.write(String.valueOf(numeroPecas));
            writer.write(newLine);

            for (CrazyPiece aCrazyList : crazyList) {
                writer.write(aCrazyList.getId() + ":" + aCrazyList.getIdTipoPeca() + ":" + aCrazyList.getIdEquipa() + ":" + aCrazyList.getAlcunha());
                writer.write(newLine);
            }

            if (capturas.size()>0){
                for (int i=0; i<capturas.size();i++){
                    writer.write(capturas.get(i).getId() + ":" + capturas.get(i).getIdTipoPeca() + ":" + capturas.get(i).getIdEquipa() + ":" + capturas.get(i).getAlcunha());
                    writer.write(newLine);
                }
            }

            for (int i=0;i<getTamanhoTabuleiro();i++){
                for(int a=0;a<getTamanhoTabuleiro();a++){
                    String zero = "0";
                    for (CrazyPiece aCrazyList : crazyList) {
                        if(aCrazyList.getCoordenadaX()==a && aCrazyList.getCoordenadaY()==i){
                            writer.write(String.valueOf(aCrazyList.getId()));
                            zero="1";
                        }
                    }
                    if (zero.equals("0")){
                        writer.write(zero);
                    }
                    if (a<getTamanhoTabuleiro()-1){
                        writer.write(":");
                    }else{

                    }
                }
                writer.write(newLine);
            }
            writer.write(String.valueOf(contarPecasCapturadas(10)));
            writer.write(":");
            writer.write(String.valueOf(jodaValidaPretas));
            writer.write(":");
            writer.write(String.valueOf(jodaInvalidaPretas));
            writer.write(":");
            writer.write(String.valueOf(contarPecasCapturadas(20)));
            writer.write(":");
            writer.write(String.valueOf(jodaValidaBrancas));
            writer.write(":");
            writer.write(String.valueOf(jodaInvalidaBrancas));
            writer.close();
        }
        catch (IOException e) {
            System.out.println( "Ocorreu um erro." );
        }
        return true;
    }


    public Map<String, List<String>> getEstatisticas(){//TODO:Testar

        List<CrazyPiece> todasAsPecas = getPecasMalucas();

        Map<String, List<String>> estatisticas = new HashMap<>();

        List<String> top5Capturas = new ArrayList<>();


        todasAsPecas.stream()//top5Capturas
                .filter((p) -> p.temCapturas())
                .sorted((p1, p2) -> p2.getCapturasFeitasPorEstaPeca().size() - p1.getCapturasFeitasPorEstaPeca().size())
                .limit(5);

        todasAsPecas.stream()//top5Pontos
                .filter((p) -> p.temCapturas())
                .sorted((p1, p2) -> p2.numeroDePontos() - p1.numeroDePontos())
                .limit(5);

        todasAsPecas.stream()//pecas5MaisCapturas
                .filter((p) -> p.temCapturas())
                .filter((p) -> p.getCapturasFeitasPorEstaPeca().size() >= 5);

        todasAsPecas.stream()//3pecasMaisBaralhadas
                    .sorted((p1, p2) -> p2.jogadaInvalidaPeca/numeroDeJogadas - p1.jogadaInvalidaPeca/numeroDeJogadas)
                    .limit(3);

        todasAsPecas.stream()
                .sorted((p1,p2) -> p2.getCapturasFeitasPorEstaPeca().size() - p1.getCapturasFeitasPorEstaPeca().size());


        estatisticas.put("top5Capturas",top5Capturas);

        return estatisticas;

        //p.getIdEquipa() + ":" + p.getAlcunha() + ":" + p.numeroDePontos() + ":" + p.getCapturasFeitasPorEstaPeca().size()
    }

}
