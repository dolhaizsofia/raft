package parancs;

import palya.*;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Level.LEVEL;
import static palya.Tenger.TENGER;

public class Bovites extends Parancs {

    private boolean valid = true;

    private Irany irany;

    public Bovites(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return palya.palyanBelulE(irany)
                && jatekosFoldonEsMellettVmi(palya, irany, TENGER)
                && palya.getJatekos().keresHolmni(DESZKA) >= 2
                && palya.getJatekos().keresHolmni(LEVEL) >= 2
                && valid;
    }

    @Override
    public void vegrehajt(Palya palya) {
        palya.getJatekos().csokkentHolmi(DESZKA, 2);
        palya.getJatekos().csokkentHolmi(LEVEL, 2);

        foglalTerulet(palya);
        valid = false;
    }

    private void foglalTerulet(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Fold());
    }
}
