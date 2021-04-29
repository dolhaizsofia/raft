package parancs;

import palya.Mezo;
import palya.Palya;
import termek.Burgonya;
import termek.Tuz;

import static palya.Jatekos.JATEKOS_TIPUS;
import static termek.Burgonya.BURGONYA_TIPUS;
import static termek.Tuz.TUZ_TIPUS;

/**
 * ha van burgonya es felrakjuk sutni akkor megsuti
 */
public class SutBurgonya extends Parancs {
    /**
     * megadott felteteleknek teljesulnie kell
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    protected boolean tamogatott(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        return mezo.ellenorizFelsoKetTipusat(JATEKOS_TIPUS, TUZ_TIPUS)
                && palya.getJatekos().keresHolmni(BURGONYA_TIPUS) > 0;
    }

    /**
     * ha tamogatott akkor vegrehajtja
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        Mezo mezo = palya.aktualisMezo();
        palya.getJatekos().csokkentHolmi(BURGONYA_TIPUS, 1);
        ((Tuz) mezo.getMasodikLegfelso()).rarak(new Burgonya());
    }
}
