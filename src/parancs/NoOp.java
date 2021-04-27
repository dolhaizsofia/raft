package parancs;

import palya.Palya;

public class NoOp extends Parancs {
    @Override
    protected boolean tamogatott(Palya palya) {
        return false;
    }

    @Override
    protected void vegrehajt(Palya palya) {

    }
}
