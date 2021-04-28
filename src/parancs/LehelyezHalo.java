package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Halo;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Level.LEVEL;
import static palya.Tenger.TENGER;

public class LehelyezHalo extends Parancs {

    private Irany irany;

    LehelyezHalo(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosFoldonEsMellettVmi(palya, irany, TENGER)
                && palya.getJatekos().keresHolmni(DESZKA) >= 2
                && palya.getJatekos().keresHolmni(LEVEL) >= 6;
    }

    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(DESZKA, 2);
        p.getJatekos().csokkentHolmi(LEVEL, 6);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Halo());

    }
}
