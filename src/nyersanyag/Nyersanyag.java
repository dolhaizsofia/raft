package nyersanyag;

import palya.JatekElem;

import java.util.List;

import static java.util.Arrays.asList;
import static nyersanyag.Deszka.DESZKA_TIPUS;
import static nyersanyag.Hordo.HORDO;
import static nyersanyag.Hulladek.HULLADEK_TIPUS;
import static nyersanyag.Level.LEVEL_TIPUS;

public abstract class Nyersanyag implements JatekElem {
    /** eldonti a statikus metodusa  hogy valami nyersanyage
     *
     */

    protected Nyersanyag() {}

    private static final List<String> NYERSANYAGOK = asList(DESZKA_TIPUS,HORDO, HULLADEK_TIPUS, LEVEL_TIPUS);

    public static boolean nyersanyagE(String elemTipus) {
        return NYERSANYAGOK.contains(elemTipus);
    }

}
