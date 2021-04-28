package parancs;

import palya.Palya;

import static termek.Halo.HALO;

public class HaloBegyujt extends Parancs {

    @Override
    protected boolean tamogatott(Palya palya) {
        return mezoTipusu(palya, HALO);
    }

    @Override
    protected void vegrehajt(Palya palya) {

    }

}
