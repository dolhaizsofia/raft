package nyersanyag;

import jatekos.JatekElem;

import java.util.Arrays;
import java.util.List;

import static nyersanyag.Deszka.DESZKA;
import static nyersanyag.Hordo.HORDO;
import static nyersanyag.Hulladek.HULLADEK;
import static nyersanyag.Level.LEVEL;

public abstract class Nyersanyag implements JatekElem {

    public static final List<String> nyersanyag = Arrays.asList(DESZKA,HORDO, HULLADEK, LEVEL);

    public static boolean nyersanyagE(String elemTipus) {
        return nyersanyag.contains(elemTipus);
    }

}
