package palya.elemek.nyersanyag;

import palya.JatekElem;

import java.util.List;

import static java.util.Arrays.asList;
import static palya.elemek.nyersanyag.Deszka.DESZKA_TIPUS;
import static palya.elemek.nyersanyag.Hordo.HORDO_TIPUS;
import static palya.elemek.nyersanyag.Hulladek.HULLADEK_TIPUS;
import static palya.elemek.nyersanyag.Level.LEVEL_TIPUS;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public abstract class Nyersanyag implements JatekElem {

    private static final List<String> NYERSANYAGOK = asList(DESZKA_TIPUS, HORDO_TIPUS, HULLADEK_TIPUS, LEVEL_TIPUS);

    protected Nyersanyag() {
    }

    /**
     * @param elemTipus a gyerekosztalyaiba definialt tipusok
     * @return letezo palya.elemek.nyersanyag e
     */
    public static boolean nyersanyagE(String elemTipus) {
        return NYERSANYAGOK.contains(elemTipus);
    }

}
