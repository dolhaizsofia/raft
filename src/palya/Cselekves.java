package palya;

public enum Cselekves {
    FRISSIT_PALYA(1),
    TERULET_BOVITES(2),
    MOZGAS_LE(3),
    MOZGAS_FEL(4),
    MOZGAS_BALRA(5),
    MOZGAS_JOBBRA(6);

    private int kod;

    Cselekves(int kod) {
        this.kod = kod;
    }

    public int getKod() {
        return kod;
    }

    public static Cselekves keresKodAlapjan(int kod){
        for(Cselekves cs : values()){
            if( cs.getKod() == kod){
                return cs;
            }
        }
        return null;
    }

}
