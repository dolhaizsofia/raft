package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Hal;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Hal.HAL_TIPUS;
import static termek.Tuz.TUZ_TIPUS;

/**
 * megnezihogy tud e halat sutni es ha igen akkor suti
 */
public class SutHal extends Parancs {
    /**
     * megadott felteteleknek teljesulnie kell
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellFelsoKetTipusat(JATEKOS_TIPUS, TUZ_TIPUS)
                && palya.getJatekos().keresHolmni(HAL_TIPUS) > 0;
    }

    /**
     * ha tamogatott akkor vegrehajtja
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        palya.getJatekos().csokkentHolmi(HAL_TIPUS, 1);
        ((Tuz) mezo.getMasodikLegfelso()).rarak(new Hal());
    }

}
