package parancs;

import nyersanyag.Deszka;
import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import palya.Tenger;
import termek.Halo;
import termek.Tuz;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;

public class LehelyezHalo extends Parancs {

    private Irany irany;

    public LehelyezHalo(Irany irany) {
        this.irany = irany;
    }

// todo palya mellet foldnek kell lennie
    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosEsMellettVmi(palya, irany, Tenger.TENGER)
              /*  && palya.getJatekos().keresHolmni(DESZKA) >= 2
                && palya.getJatekos().keresHolmni(LEVEL) >= 6;*/;
    }


    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(DESZKA, 2);
        p.getJatekos().csokkentHolmi(LEVEL, 6);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Halo());

    }
}
