package parancs;

import palya.Fold;
import palya.Irany;
import palya.Palya;
import palya.Pozicio;

import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;
import static palya.Tenger.TENGER_TIPUS;

/**
 * megvizsgalja a palyat hogy lehet e oda epiteni
 * leepit plusz egy foldteruletett ha van elég nyersanyag amugy meg visszater hamissal és nem csinal semmit
 */
public class Bovites extends Parancs {

    private Irany irany;

    Bovites(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return palya.palyanBelulE(irany)
                && jatekosFoldonEsMellettVmi(palya, irany, TENGER_TIPUS)
                && palya.getJatekos().keresHolmni(DESZKA_TIPUS) >= 2
                && palya.getJatekos().keresHolmni(LEVEL_TIPUS) >= 2;
    }

    @Override
    public void vegrehajt(Palya palya) {
        palya.getJatekos().csokkentHolmi(DESZKA_TIPUS, 2);
        palya.getJatekos().csokkentHolmi(LEVEL_TIPUS, 2);
        foglalTerulet(palya);
    }

    private void foglalTerulet(Palya p) {
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Fold());
    }
}
