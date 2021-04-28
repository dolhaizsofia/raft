package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Tuz;

public class LehelyezTuzhely extends Parancs {

    private Irany irany;

    public LehelyezTuzhely(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosEsMellettFoldE(palya, irany);
    }

    @Override
    public void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Tuz());
    }
}
