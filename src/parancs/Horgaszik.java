package parancs;

import palya.Palya;
import termek.Hal;

import java.util.Random;

import static palya.Jatekos.JATEKOS_TIPUS;
import static palya.Tenger.TENGER;

public class Horgaszik extends Parancs {

    private static Random random = new Random();

    @Override
    protected boolean tamogatott(Palya palya) {
        return palya.aktualisMezo().ellFelsoKetTipusat(JATEKOS_TIPUS, TENGER);
    }

    @Override
    protected void vegrehajt(Palya palya) {
        if (random.nextInt(4) == 1) {
            palya.getJatekos().felvesz(new Hal());
        }
    }
}
