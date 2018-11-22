package pt.ulusofona.lp2.crazyChess;


import javax.swing.*;
import java.awt.*;

public class CrazyPiece {
    int IdPeca;
    int IdTipoDePeca;
    int IdEquipas;
    String Alcunha;


    //irá representar a peça de Crazy Chess - ou seja, terá de conter
    //os atributos relevantes para a caracterização de uma destas peças


    public int getID(){
        //Deve devolver o ID da peça.
        return IdPeca;
    }

    public String getImagePNG(){
        Image image = new ImageIcon(this.getClass().getResource("/images/horse.png")).getImage();


        //Deve devolver o nome do ficheiro de imagem
        //(formato PNG) que representa a Peça.

        //(As imagens a usar devem ser colocadas na pasta
        //src/images e devem ter tamanho 50x50. As imagens
        //devem ter fundo transparente para que se consiga
        //ver se estão num quadrado branco ou preto).

        //Caso os alunos não pretendam definir
        //nenhuma imagem, a função pode
        //simplesmente retornar null . Isto fará com
        //que o visualizador use uma imagem
        //pré-definida por omissão.
        return "do";
    }

    public String toString(){

        //Retorna uma String com a informação
        //sobre a peça.

        //Sintaxe (se a peça ainda estiver em jogo):
        //“<ID> | <Tipo> | <ID Equipa> |

        //<Alcunha> @ (<x>, <y>)”
        //Sintaxe (se a peça já foi capturada):

        //“<ID> | <Tipo> | <ID Equipa> |
        //<Alcunha> @ (n/a)”
        return "do";
    }
}
