package parancs;

import palya.Irany;
import palya.Palya;

public class LehelyezHalo extends Parancs {

    private Irany irany;

    public LehelyezHalo(Irany irany) {
        this.irany = irany;
    }

    @Override
    protected boolean tamogatott(Palya palya) {
        return false;
    }

    @Override
    public void vegrehajt(Palya palya) {

    }
}
