package nyersanyag;

import palya.JatekElem;

import java.util.List;

import static java.util.Arrays.asList;
import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Hordo.HORDO_TIPUS;
import static nyersanyag.Hulladek.HULLADEK_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;

/**
 * eldonti a statikus metodusa  hogy valami nyersanyage
 */
public abstract class Nyersanyag implements JatekElem {

    private static final List<String> NYERSANYAGOK = asList(DESZKA_TIPUS, HORDO_TIPUS, HULLADEK_TIPUS, LEVEL_TIPUS);

    protected Nyersanyag() {
    }

    /**
     * @param elemTipus a gyerekosztalyaiba definialt tipusok
     * @return letezo nyersanyag e
     */
    public static boolean nyersanyagE(String elemTipus) {
        return NYERSANYAGOK.contains(elemTipus);
    }

}
