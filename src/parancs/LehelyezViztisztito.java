package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Viztisztito;

import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;

public class LehelyezViztisztito extends Parancs {

    private Irany irany;

    public LehelyezViztisztito(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosEsMellettFoldE(palya, irany)
                && palya.getJatekos().keresHolmni(LEVEL) >= 2 && palya.getJatekos().keresHolmni(HULLADEK) >= 4;
    }

    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(LEVEL, 2);
        p.getJatekos().csokkentHolmi(HULLADEK, 4);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Viztisztito());
    }
}
