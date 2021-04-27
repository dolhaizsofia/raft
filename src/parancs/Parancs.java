package parancs;

import palya.Palya;

public abstract class Parancs {

    public void csinal(Palya palya) {
        if(tamogatott(palya)) {
            vegrehajt(palya);
        }
    }

    protected abstract boolean tamogatott(Palya palya);

    protected abstract void vegrehajt(Palya palya);
}
