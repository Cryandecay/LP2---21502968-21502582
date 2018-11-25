package pt.ulusofona.lp2.crazyChess;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

class Utilizador {
    int id;
    String nome;
    public Utilizador(int id, String nome) {
        this.id = id;
        /* ... */
        }
    }
public class Main {
    public static void main(String[] args) {
        String nomeFicheiro = "dados.txt";
        try {
            File ficheiro = new File(nomeFicheiro);
            Scanner leitorFicheiro = new Scanner(ficheiro);
            // enquanto o ficheiro tiver linhas não-lidas
            while(leitorFicheiro.hasNextLine()) {
               // ler uma linha do ficheiro
                String linha = leitorFicheiro.nextLine();
                // partir a linha no caractere separador
                String dados[] = linha.split(":");
                // converter as Strings lidas para os tipos esperados
                int id = Integer.parseInt(dados[0]);
                String nome = dados[1];
                // criar o objecto Utilizador
                System.out.println(id);
            }
            leitorFicheiro.close();
        }
        catch(FileNotFoundException exception) {
            String mensagem = "Erro: o ficheiro " + nomeFicheiro + " nao foi encontrado.";
            System.out.println(mensagem);
        }
    }
}