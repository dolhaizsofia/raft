package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Tuz;

import static palya.elemek.Jatekos.JATEKOS_TIPUS;
import static termek.Tuz.TUZ_TIPUS;

/**
 * megvizsgalja a palyat ha van hal es megsult visszater igazzal ha me nincs vagy meg nyers akkor hamissal
 */
public class EszikHal extends Parancs {
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
                && ((Tuz) mezo.getMasodikLegfelso()).vanSultHal();
    }

    /**
     * vegrehajtja ha tamogatott
     *
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        ((Tuz) mezo.getMasodikLegfelso()).leveszHal();
        palya.getJatekos().eszik();
    }
}
