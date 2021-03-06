package parancs;

import palya.Irany;
import palya.Palya;
import palya.Pozicio;
import termek.Halo;

import static palya.elemek.Tenger.TENGER_TIPUS;
import static palya.elemek.nyersanyag.Deszka.DESZKA_TIPUS;
import static palya.elemek.nyersanyag.Level.LEVEL_TIPUS;

/**
 * megnezi hogy rakhat e le halot oda ahova szeretne es hogy van e eleg nyersanyaga ha mindaketto
 * igaz akkor lerak egy halot
 */
public class LehelyezHalo extends Parancs {

    private final Irany irany;

    /**
     * milyen iranyba rakja le a halot
     *
     * @param irany
     */
    LehelyezHalo(Irany irany) {
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
        return jatekosFoldonEsMellettVmi(palya, irany, TENGER_TIPUS)
                && palya.getJatekos().keresHolmni(DESZKA_TIPUS) >= 2
                && palya.getJatekos().keresHolmni(LEVEL_TIPUS) >= 6;
    }

    /**
     * lerakja a halot
     * csokkenti az alapanyagok mennyiseget
     *
     * @param p
     */
    @Override
    public void vegrehajt(Palya p) {
        p.getJatekos().csokkentHolmi(DESZKA_TIPUS, 2);
        p.getJatekos().csokkentHolmi(LEVEL_TIPUS, 6);
        Pozicio kovetkezoLepes = p.getKovetkezoLepes(irany);
        p.getTabla()[kovetkezoLepes.getY()][kovetkezoLepes.getX()].lehelyez(new Halo());

    }
}
