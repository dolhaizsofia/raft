package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Tuz;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;

public class LehelyezTuzhely extends Parancs {

    private Irany irany;

    public LehelyezTuzhely(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosEsMellettFoldE(palya, irany)
                && palya.getJatekos().keresHolmni(DESZKA) >= 2
                && palya.getJatekos().keresHolmni(LEVEL) >= 4
                && palya.getJatekos().keresHolmni(HULLADEK) >= 3;
    }

    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(DESZKA, 2);
        p.getJatekos().csokkentHolmi(LEVEL, 4);
        p.getJatekos().csokkentHolmi(HULLADEK, 3);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Tuz());
    }
}
