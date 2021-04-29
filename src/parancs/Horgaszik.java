package parancs;

import palya.Palya;
import termek.Hal;

import java.util.Random;

import static palya.Jatekos.JATEKOS_TIPUS;
import static palya.Tenger.TENGER_TIPUS;

/**
 * ha vizen van a jatekos akkor tud horgaszni
 */
public class Horgaszik extends Parancs {

    private static Random random = new Random();

    @Override
    protected boolean tamogatott(Palya palya) {
        return palya.aktualisMezo().ellenorizFelsoKetTipusat(JATEKOS_TIPUS, TENGER_TIPUS);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        if (random.nextInt(4) == 1) {
            palya.getJatekos().felvesz(new Hal());
        }
    }
}
