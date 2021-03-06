package parancs;

import palya.Palya;
import termek.Hal;

import java.util.Random;

import static palya.elemek.Jatekos.JATEKOS_TIPUS;
import static palya.elemek.Tenger.TENGER_TIPUS;

/**
 * ha vizen van a jatekos akkor tud horgaszni
 */
public class Horgaszik extends Parancs {

    private static final Random random = new Random();

    /**
     * megadott felteteleknek teljesulnie kell
     *
     * @param palya az adott palyat vizsgalom
     * @return igaz ha megfelel a felteteleknek
     */
    @Override
    protected boolean tamogatott(Palya palya) {
        return palya.aktualisMezo().ellenorizFelsoKetTipusat(JATEKOS_TIPUS, TENGER_TIPUS);
    }

    /**
     * horgaszik randomadok egy szamot es ennek megfelelo szazalekba halaszunk halat
     *
     * @param palya
     */
    @Override
    protected void vegrehajt(Palya palya) {
        if (random.nextInt(4) == 1) {
            palya.getJatekos().felvesz(new Hal());
        }
    }
}
