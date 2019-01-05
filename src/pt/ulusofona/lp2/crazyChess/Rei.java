package pt.ulusofona.lp2.crazyChess;

public class Rei extends CrazyPiece {

    public Rei(String idPeca, String idTipoPeca, String idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Rei";
        valorRelativo = "(infinito)";
    }

    public Rei(int idPeca, int idTipoPeca, int idEquipa, String alcunha, int x, int y) {
        super(idPeca, idTipoPeca, idEquipa, alcunha, x, y);
        tipoeDePeca = "Rei";
        valorRelativo = "(infinito)";
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
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
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
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (xD == xO - 1 && yD == yO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO + 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO + 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }
                    if (yD == yO - 1 && xD == xO - 1) {
                        if(!findFriend(xD, yD, crazy.getId(), crazy.getIdEquipa())){
                            return false;
                        }
                        crazy.setCoordenadaX(xD);
                        crazy.setCoordenadaY(yD);
                        findCapture(xD, yD,crazy.getId(), crazy.getIdEquipa());
                        return true;
                    }

                    return false;
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
