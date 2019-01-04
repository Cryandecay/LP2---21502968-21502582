package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {

    public Rei(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    public Rei(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
    }

    @Override
    public String getImagePNG() {
        if (idEquipa == 10){
            return "KingBlack.png";
        } else {
            return "KingWhite.png";
        }
    }

    @Override
    public boolean movimento(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
                //king
                //preta
                if (crazy.getIdTipoPeca() == 0 && crazy.getIdEquipa() == estatisticas.equipaAJogar ) {
                    System.out.println(crazy.getIdEquipa());
                    if (xD == xO + 1 && yD == yO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaPretas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    estatisticas.jodaInvalidaPretas++;
                    return false;
                }

                if (crazy.getIdTipoPeca() == 0 && crazy.getIdEquipa() == estatisticas.equipaAJogar ) {
                    System.out.println(crazy.getIdEquipa());
                    if (xD == xO + 1 && yD == yO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            estatisticas.jodaInvalidaBrancas++;
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }

                    estatisticas.jodaInvalidaBrancas++;
                    return false;
                }
                if (crazy.getIdEquipa() != estatisticas.equipaAJogar ) {
                    if (crazy.getIdEquipa()==10){
                        estatisticas.jodaInvalidaPretas++;
                    }else{
                        estatisticas.jodaInvalidaBrancas++;
                    }
                }
        return false;
    }



    @Override
    public boolean movimentoPrevisao(int xO, int yO, int xD, int yD, CrazyPiece crazy) {
        //king
        //preta
        if (crazy.getIdTipoPeca() == 0 && crazy.getIdEquipa() == estatisticas.equipaAJogar ) {
            if (xD == xO + 1 && yD == yO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (xD == xO - 1 && yD == yO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO - 1 && xD == xO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO + 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO + 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO - 1 && xD == xO + 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO - 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO - 1 && xD == xO - 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            return false;
        }

        if (crazy.getIdTipoPeca() == 0 && crazy.getIdEquipa() == estatisticas.equipaAJogar ) {
            System.out.println(crazy.getIdEquipa());
            if (xD == xO + 1 && yD == yO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (xD == xO - 1 && yD == yO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO - 1 && xD == xO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO + 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO + 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO - 1 && xD == xO + 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO + 1 && xD == xO - 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            if (yD == yO - 1 && xD == xO - 1) {
                if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                    return false;
                }
                return true;
            }
            return false;
        }
        return false;
    }

}
