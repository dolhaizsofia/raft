package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Halo;

import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static palya.Tenger.TENGER_TIPUS;

/**
 *megnezi hogy rakhat e le halot oda ahova szeretne es hogy van e eleg nyersanyaga ha mindaketto
 * igaz akkor lerak egy halot
 */
public class LehelyezHalo extends Parancs {

    private Irany irany;

    LehelyezHalo(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosFoldonEsMellettVmi(palya, irany, TENGER_TIPUS)
                && palya.getJatekos().keresHolmni(DESZKA_TIPUS) >= 2
                && palya.getJatekos().keresHolmni(LEVEL_TIPUS) >= 6;
    }

    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(DESZKA_TIPUS, 2);
        p.getJatekos().csokkentHolmi(LEVEL_TIPUS, 6);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Halo());

    }
}
