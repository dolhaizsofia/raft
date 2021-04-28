package parancs;

import palya.Irany;
import palya.Mezo;
import palya.Palya;
import palya.Pozicio;
import termek.Tuz;

import static palya.Jatekos.JATEKOS;

public class LehelyezTuzhely extends Parancs {

    private Irany irany;

    public LehelyezTuzhely(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS);
    }

    @Override
    public void vegrehajt(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Tuz());
    }
}
