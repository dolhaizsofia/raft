package parancs;

import palya.*;
import termek.Tuz;

import static palya.Fold.FOLD;
import static palya.Jatekos.JATEKOS;

public class LehelyezTuzhely extends Parancs {

    private Irany irany;

    public LehelyezTuzhely(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        Pozicio kovetkezoLepes = palya.getKovetkezoLepes(irany);
        return palya.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()]
                .getLegfelso()
                .tipus().equals(FOLD) && mezo.getLegfelso().tipus().equals(JATEKOS);
    }

    @Override
    public void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Tuz());
    }
}
