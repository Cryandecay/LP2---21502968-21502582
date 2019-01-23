package pt.ulusofona.lp2.crazyChess;


public class TowerV extends CrazyPiece {
    public TowerV(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "TorreV";
        valorRelativo = "3";
        valorRelativoParaCalculo = 3;
    }

    public TowerV(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "TorreV";
        valorRelativo = "3";
        valorRelativoParaCalculo = 3;
    }

    @Override
    public String getImagePNG() {
        if (idEquipa == 10){
            return "TowerBlackV.png";
                    } else {
                    return "TowerWhiteV.png";
                    }
                    }

@Override
public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if (deltaX != 0) {
        return false;
        }

        if (!findFriend(xD, yD, idPeca, idEquipa)) {
        return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
        return false;
        }

        findCapture(xD, yD, idPeca, idEquipa);
        coordenadaY = yD;
        estatisticas.maisUmTurno();
        estatisticas.maisUmTurnoCaptura();

        return true;//TODO:funcionou para Cima e Baixo nao mexe na direcao em que tiver pecas
        }

@Override
public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        int deltaX = Math.abs(xD - xO);
        int deltaY = Math.abs(yD - yO);

        int direcaoX = xD - xO;
        int direcaoY = yD - yO;

        if (deltaX != 0) {
        return false;
        }

        if (!findFriend(xD, yD, idPeca, idEquipa)) {
        return false;
        }

        if (!descobreDirecao(direcaoX, direcaoY, xO, yO, deltaX, deltaY)) {
        return false;
        }

        return true;//TODO:funcionou para Cima e Baixo nao mexe na direcao em que tiver pecas
        }
        }
