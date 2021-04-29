package parancs;

import palya.Mezo;
import palya.Palya;

import static palya.elemek.Jatekos.JATEKOS_TIPUS;

/**
 * ez az osztaly minden cselekvesnel az jatekosunk erejebol azaz szomjusagabol es esegebol
 */
public class LeveszEro extends Parancs {
    /**
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.getLegfelso().tipus().equals(JATEKOS_TIPUS);
    }

    /**
     * csokenti az eletet a jatekosnak
     *
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        palya.getJatekos().csokkentElet();
        palya.getJatekos().csokkentCselekvesSzamlalo();
    }
}
