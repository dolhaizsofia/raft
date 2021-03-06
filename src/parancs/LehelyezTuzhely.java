package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Tuz;

import static palya.elemek.Fold.FOLD_TIPUS;
import static palya.elemek.nyersanyag.Deszka.DESZKA_TIPUS;
import static palya.elemek.nyersanyag.Hulladek.HULLADEK_TIPUS;
import static palya.elemek.nyersanyag.Level.LEVEL_TIPUS;

/**
 * ez az osztaly megnezi hogy minden feltetel teljesul e a tuzhely lehelyezesehez azaz van eleg palya.elemek.nyersanyag es jo helyre szeretne e lerakni
 * a felhasznalo ha mindketto igaz lerak egy tuzhelyet
 */
public class LehelyezTuzhely extends Parancs {

    private final Irany irany;

    public LehelyezTuzhely(Irany irany) {
        this.irany = irany;
    }

    /**
     * megadott felteteleknek teljesulnie kell
     *
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        return jatekosEsMellettVmi(palya, irany, FOLD_TIPUS)
                && palya.getJatekos().keresHolmni(DESZKA_TIPUS) >= 2
                && palya.getJatekos().keresHolmni(LEVEL_TIPUS) >= 4
                && palya.getJatekos().keresHolmni(HULLADEK_TIPUS) >= 3;
    }

    /**
     * lerakja a tuzhelyet
     * csokkenti az alapanyagok mennyiseget
     *
     * @param p
     */
    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(DESZKA_TIPUS, 2);
        p.getJatekos().csokkentHolmi(LEVEL_TIPUS, 4);
        p.getJatekos().csokkentHolmi(HULLADEK_TIPUS, 3);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Tuz());
    }
}
