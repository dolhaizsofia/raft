package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Viztisztito;

import static nyersanyag.Hulladek.HULLADEK_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static palya.Fold.FOLD_TIPUS;
/**
 * a tamogatott megnezi hogy lehet e viztisztitot lehelyezni jo helyre akkarod e lerakni es van e eleg nyeranyagod
 * a vegrehajt metodus meg lehelyezi es csokkenti a nyersanyagokat
 */
public class LehelyezViztisztito extends Parancs {

    private Irany irany;

    LehelyezViztisztito(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosEsMellettVmi(palya, irany, FOLD_TIPUS)
                && palya.getJatekos().keresHolmni(LEVEL_TIPUS) >= 2
                && palya.getJatekos().keresHolmni(HULLADEK_TIPUS) >= 4;
    }

    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(LEVEL_TIPUS, 2);
        p.getJatekos().csokkentHolmi(HULLADEK_TIPUS, 4);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Viztisztito());
    }
}
