package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Tuz.TUZ_TIPUS;

/**
 * viszater igazzal hogy eheto e mar a burgony es megeszi
 */
public class EszikBurgonya extends Parancs {
    /**
     * megadott felteteleknek teljesulnie kell
     *
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellenorizFelsoKetTipusat(JATEKOS_TIPUS, TUZ_TIPUS)
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultBurgonya();
    }

    /**
     * burgonyat eszik es no az eshege
     *
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszBurgonya();
        palya.getJatekos().eszik();
    }
}
