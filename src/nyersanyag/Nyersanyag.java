package nyersanyag;

import jatekos.JatekElem;

public abstract class Nyersanyag implements JatekElem {

    public static final String NYERSANYAG = "nyersanyag";

    @Override
    public String tipus() {
        return NYERSANYAG;
    }

    @Override
    public String getImageName() {
        return "tenger";
    }

}
